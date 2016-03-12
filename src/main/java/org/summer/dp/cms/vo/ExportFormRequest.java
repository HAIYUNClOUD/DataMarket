package org.summer.dp.cms.vo;

import java.util.Date;

/**
 * 报表请求参数
 * @author zhaobaodong
 *
 */
public class ExportFormRequest {
	public enum function{
		AVG,SUM,MAX,MIN 
	}
	public enum groupby{
		YEAR,MONTH,DAY
	}
	private String function;// AVG,SUM,MAX,MIN 
	private String groupby;//YEAR,MONTH,DAY,HOUR
	private byte dimType;//1 dimGeog 2 dimType 3 dimWorkshop
	private Date startDate;
	private Date endDate;
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getGroupby() {
		return groupby;
	}
	public void setGroupby(String groupby) {
		this.groupby = groupby;
	}
	public byte getDimType() {
		return dimType;
	}
	public void setDimType(byte dimType) {
		this.dimType = dimType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExportFormRequest [function=");
		builder.append(function);
		builder.append(", groupby=");
		builder.append(groupby);
		builder.append(", dimType=");
		builder.append(dimType);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}


}
