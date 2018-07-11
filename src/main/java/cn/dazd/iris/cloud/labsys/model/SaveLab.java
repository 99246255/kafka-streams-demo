package cn.dazd.iris.cloud.labsys.model;

import java.util.Date;

/**
 *  保存lab，topic输入
 */
public class SaveLab {

    public long tradeCode;
    public String creatorId;
    public String creatorName;

    public String deptName;
    public String PLLegalRepresentative;
    public String PLAddress;
    public String PLRegistrationNumber;
    public Date PLStartTime;
    public Date PLEndTime;
    public Date PLIssueTime;
    public String PLPicId;

    public String BLname;
    public String BLLegalRepresentative;
    public String BLAddress;
    public String BLCode;
    public Date BLStartTime;
    public Date BLEndTime;
    public Date BLIssueTime;
    public String BLPicId;

    public SaveLab(String creatorId, String creatorName, String deptName) {
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.deptName = deptName;
    }

    public long getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(long tradeCode) {
        this.tradeCode = tradeCode;
    }


    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPLLegalRepresentative() {
        return PLLegalRepresentative;
    }

    public void setPLLegalRepresentative(String PLLegalRepresentative) {
        this.PLLegalRepresentative = PLLegalRepresentative;
    }

    public String getPLAddress() {
        return PLAddress;
    }

    public void setPLAddress(String PLAddress) {
        this.PLAddress = PLAddress;
    }

    public String getPLRegistrationNumber() {
        return PLRegistrationNumber;
    }

    public void setPLRegistrationNumber(String PLRegistrationNumber) {
        this.PLRegistrationNumber = PLRegistrationNumber;
    }

    public Date getPLStartTime() {
        return PLStartTime;
    }

    public void setPLStartTime(Date PLStartTime) {
        this.PLStartTime = PLStartTime;
    }

    public Date getPLEndTime() {
        return PLEndTime;
    }

    public void setPLEndTime(Date PLEndTime) {
        this.PLEndTime = PLEndTime;
    }

    public Date getPLIssueTime() {
        return PLIssueTime;
    }

    public void setPLIssueTime(Date PLIssueTime) {
        this.PLIssueTime = PLIssueTime;
    }

    public String getPLPicId() {
        return PLPicId;
    }

    public void setPLPicId(String PLPicId) {
        this.PLPicId = PLPicId;
    }

    public String getBLname() {
        return BLname;
    }

    public void setBLname(String BLname) {
        this.BLname = BLname;
    }

    public String getBLLegalRepresentative() {
        return BLLegalRepresentative;
    }

    public void setBLLegalRepresentative(String BLLegalRepresentative) {
        this.BLLegalRepresentative = BLLegalRepresentative;
    }

    public String getBLAddress() {
        return BLAddress;
    }

    public void setBLAddress(String BLAddress) {
        this.BLAddress = BLAddress;
    }

    public String getBLCode() {
        return BLCode;
    }

    public void setBLCode(String BLCode) {
        this.BLCode = BLCode;
    }

    public Date getBLStartTime() {
        return BLStartTime;
    }

    public void setBLStartTime(Date BLStartTime) {
        this.BLStartTime = BLStartTime;
    }

    public Date getBLEndTime() {
        return BLEndTime;
    }

    public void setBLEndTime(Date BLEndTime) {
        this.BLEndTime = BLEndTime;
    }

    public Date getBLIssueTime() {
        return BLIssueTime;
    }

    public void setBLIssueTime(Date BLIssueTime) {
        this.BLIssueTime = BLIssueTime;
    }

    public String getBLPicId() {
        return BLPicId;
    }

    public void setBLPicId(String BLPicId) {
        this.BLPicId = BLPicId;
    }
}
