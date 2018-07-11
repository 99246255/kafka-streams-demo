package cn.dazd.iris.cloud.labsys.producer;

import cn.dazd.iris.cloud.labsys.model.CrewSchedule;
import cn.dazd.iris.cloud.labsys.model.TestItem;
import cn.dazd.iris.cloud.labsys.serializer.JsonSerializer;
import cn.dazd.iris.cloud.labsys.util.LabConstant;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
@Component
public class LabProducer {

	private Producer<String, CrewSchedule> crewScheduleProducer;

    private Producer<String, TestItem> testItemProducer;

	@Value("${kafka.connect}")
	private String kafka;

    private static String [] testNames =new String[]{"血常规","尿常规","肝功能"};
    private static String [] sampleTypes =new String[]{"血液","尿","血液"};
    private long dateCount = 1;
    private long testCode = 1;
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate plus = now.plus(1, ChronoUnit.DAYS);
        System.out.println(      plus.toString()
        );
    }
	@Scheduled(cron="0/20 * * * * *")
	public void crewScheduleProducerJob(){
        LocalDate now = LocalDate.now();
        now = now.plusDays(dateCount++);
        UUID uuid = UUID.randomUUID();
        CrewSchedule crewSchedule = new CrewSchedule();
        Date date = localDateToUdate(now);
        crewSchedule.setStartTime(date);
        crewSchedule.setEndTime(date);
        crewSchedule.setContent("张三上班时间： " + now.toString() + " 8:00-17:00；制定时间"+ new Date().toString()) ;
        crewSchedule.setName("张三计划" + dateCount);
        crewSchedule.setDeptName("杭检");
        crewScheduleProducer.send(new ProducerRecord<String, CrewSchedule>(LabConstant.TOPIC_LAB_CREW_SCHEDULE_SAVE, uuid.toString(), crewSchedule));
	}
    @Scheduled(cron="0/20 * * * * *")
    public void testItemProducerJob(){
        UUID uuid = UUID.randomUUID();
        TestItem testItem = new TestItem();
        testItem.setId(System.currentTimeMillis());
        testItem.setCode(String.valueOf(testCode++));
        int i = new Random().nextInt(testNames.length);
        testItem.setName(testNames[i] + testCode);
        testItem.setSampleType(sampleTypes[i]);
        testItemProducer.send(new ProducerRecord<String, TestItem>(LabConstant.TOPIC_LAB_TESTITEM_SAVE, uuid.toString(), testItem));
    }

	@PostConstruct
	public void init(){
		java.util.Properties props = new java.util.Properties();
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafka);
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "application-lab-producer-id");
		props.put(StreamsConfig.CLIENT_ID_CONFIG, "application-lab-producer-id");

		StringSerializer stringSerializer = new StringSerializer();

        crewScheduleProducer = new KafkaProducer<String, CrewSchedule>(props, stringSerializer, new JsonSerializer<CrewSchedule>());
        testItemProducer = new KafkaProducer<String, TestItem>(props, stringSerializer, new JsonSerializer<TestItem>());
	}

    // 05. java.time.LocalDate --> java.util.Date
    public Date localDateToUdate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }
}
