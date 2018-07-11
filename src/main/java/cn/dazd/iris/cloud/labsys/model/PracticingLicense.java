package cn.dazd.iris.cloud.labsys.model;

import java.util.Date;
/**
 * 执业许可证
 * @author chenyu
 * @version 1.0
 */
public class PracticingLicense {

	public long PLId;
	public long tradeCode;
	public String deptName;
	public String legalRepresentative;
	public String address;
	public String registrationNumber;
	public Date startTime;
	public Date endTime;
	public Date issueTime;
	public String picId;

	public long getPLId() {
		return PLId;
	}

	public void setPLId(long PLId) {
		this.PLId = PLId;
	}

	public long getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(long tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
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

	public Date getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}

	public String getPicId() {
		return picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}
}