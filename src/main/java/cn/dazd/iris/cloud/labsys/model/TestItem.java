package cn.dazd.iris.cloud.labsys.model;

/**
 * 检测项， 套餐有商务那边定义组合，一个套餐有多个检测项
 */
public class TestItem {

    /**
     * 检测项id
     */
    public long id;

    /**
     * 检测项名称
     */
    public String name;

    /**
     * 检测项编号
     */
    public String code;

    /**
     * 样本类型
     */
    public String sampleType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }
}
