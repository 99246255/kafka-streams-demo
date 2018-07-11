package cn.dazd.iris.cloud.labsys.config;

import cn.dazd.iris.cloud.labsys.model.CrewSchedule;
import cn.dazd.iris.cloud.labsys.model.TestItem;
import cn.dazd.iris.cloud.labsys.serializer.JsonDeserializer;
import cn.dazd.iris.cloud.labsys.serializer.JsonSerializer;
import cn.dazd.iris.cloud.labsys.util.LabConstant;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.Consumed;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
@Configuration
public class KafkaStreamsConfig implements ApplicationListener<ApplicationReadyEvent> {


    @Value("${kafka.connect}")
    private String kafka;
    @Value("${zookeeper.connect}")
    private String zookeeper;
    @Value("${kafka.groupId}")
    private String groupId;
    @Value("${kafka.client.id}")
    private String clientId;
    @Value("${kafka.application.id}")
    private String applicationId;

    private KafkaStreams streaming;


    @Bean(destroyMethod = "close")
    public KafkaStreams kafkaStreams(){
        StreamsConfig streamingConfig = new StreamsConfig(getProperties());
        JsonDeserializer<TestItem> testItemJsonDeserializer = new JsonDeserializer<>(TestItem.class);
        JsonSerializer<TestItem> testItemJsonSerializer = new JsonSerializer<TestItem>();
        Serde<TestItem> testItemSerde = Serdes.serdeFrom(testItemJsonSerializer,testItemJsonDeserializer);
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, TestItem> testItemKStream = streamsBuilder.stream(LabConstant.TOPIC_LAB_TESTITEM_SAVE, Consumed.with(Serdes.String(), testItemSerde));
        // 修改key, 改为TradeCode, 返回结构为KStream<Long, SaveLab>
        testItemKStream.map((KeyValueMapper<String, TestItem, KeyValue<String, TestItem>>) (s, testItem) -> {
            if(testItem.getId() == 0 ){// 没有TradeCode设置一个
                testItem.setId(System.currentTimeMillis());
            }
            return new KeyValue<String, TestItem>(String.valueOf(testItem.getId()), testItem);
        }).to(LabConstant.TOPIC_LAB_TESTITEM, Produced.with(Serdes.String(), testItemSerde));

        JsonDeserializer<CrewSchedule> crewScheduleJsonDeserializer = new JsonDeserializer<>(CrewSchedule.class);
        JsonSerializer<CrewSchedule> crewScheduleJsonSerializer = new JsonSerializer<CrewSchedule>();
        Serde<CrewSchedule> crewScheduleSerde = Serdes.serdeFrom(crewScheduleJsonSerializer,crewScheduleJsonDeserializer);
        KStream<String, CrewSchedule> crewScheduleKStream = streamsBuilder.stream(LabConstant.TOPIC_LAB_CREW_SCHEDULE_SAVE, Consumed.with(Serdes.String(), crewScheduleSerde));
        // 修改key, 改为TradeCode, 返回结构为KStream<Long, SaveLab>
        crewScheduleKStream.map((KeyValueMapper<String, CrewSchedule, KeyValue<String, CrewSchedule>>) (s, crewSchedule) -> {
            return new KeyValue<String, CrewSchedule>(crewSchedule.getName(), crewSchedule);
        }).to(LabConstant.TOPIC_LAB_CREW_SCHEDULE, Produced.with(Serdes.String(), crewScheduleSerde));
        streaming = new KafkaStreams(streamsBuilder.build() ,streamingConfig);
        return streaming;
    }

    private Properties getProperties() {
        Properties props = new Properties();
        props.put(StreamsConfig.CLIENT_ID_CONFIG, clientId);
        props.put("group.id", groupId);
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafka);
        props.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, zookeeper);
        props.put(StreamsConfig.REPLICATION_FACTOR_CONFIG, 1);
        return props;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        streaming.start();
        System.out.println("Starting kafka stream");
    }
}
