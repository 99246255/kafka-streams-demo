package cn.dazd.iris.cloud.labsys.model;

import java.util.Date;
/**
 * @author chenyu
 * @version 1.0
 */
public class LabInfo {

	public long tradeCode;
	public int state;
	public Date createTime;
	public Date upDateTime;
	public String creatorId;
	public String creatorName;

	public long getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(long tradeCode) {
		this.tradeCode = tradeCode;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpDateTime() {
		return upDateTime;
	}

	public void setUpDateTime(Date upDateTime) {
		this.upDateTime = upDateTime;
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
}