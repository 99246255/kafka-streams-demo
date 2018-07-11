package cn.dazd.iris.cloud.labsys.model;

import java.util.Date;
/**
 *  营业执照
 * @author chenyu
 * @version 1.0
 */
public class BusinessLicense {

	public long BLId;
	public long tradeCode;
	public String name;
	public String legalRepresentative;
	public String address;
	public String code;
	public java.util.Date startTime;
	public Date endTime;
	public Date issueTime;
	public String picId;


	public long getBLId() {
		return BLId;
	}

	public void setBLId(long BLId) {
		this.BLId = BLId;
	}

	public long getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(long tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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