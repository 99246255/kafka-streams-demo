package cn.dazd.iris.cloud.labsys.model;

import java.util.Date;

/**
 * 排班
 */
public class CrewSchedule {

    /**
     * 排班名称
     */
    public String name;
    /**
     * 所属部门
     */
    public String deptName;
    /**
     * 排班起始时间
     */
    public Date startTime;
    /**
     * 排班起始时间
     */
    public Date endTime;

    /**
     * 排班内容，先这样写
     */
    public String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
