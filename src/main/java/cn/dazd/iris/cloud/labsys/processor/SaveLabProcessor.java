package cn.dazd.iris.cloud.labsys.processor;

import cn.dazd.iris.cloud.labsys.model.LabInfo;
import com.google.gson.Gson;
import org.apache.kafka.streams.processor.AbstractProcessor;

public class SaveLabProcessor extends AbstractProcessor<String, LabInfo> {


    @Override
    public void process(String s, LabInfo labInfo) {
        context().forward(String.valueOf(labInfo.getTradeCode()) ,labInfo);
        context().commit();
        System.out.println("处理消息：" + new Gson().toJson(labInfo));
    }
}
