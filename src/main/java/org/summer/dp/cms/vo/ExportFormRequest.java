package org.summer.dp.cms.vo;

import java.util.Arrays;
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
	private String groupby;//YEAR,MONTH,DAY 横坐标
	private String geogId;//地理位置ID
	private String workShopId;//厂房ID
	private String typeId;//类型ID
	/**
	 * 返回的线 下面就是值
	 * electric_number 
	 * gas_number 
	 * production_number
	 * sale_number 
	 * temperature 
	 * warn_number 
	 * water_number
	 */
	private String lines[];
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
	
	public String[] getLines() {
		return lines;
	}
	public void setLines(String[] lines) {
		this.lines = lines;
	}
	
	public String getGeogId() {
		return geogId;
	}
	public void setGeogId(String geogId) {
		this.geogId = geogId;
	}
	public String getWorkShopId() {
		return workShopId;
	}
	public void setWorkShopId(String workShopId) {
		this.workShopId = workShopId;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "ExportFormRequest [function=" + function + ", groupby=" + groupby + ", geogId=" + geogId
				+ ", workShopId=" + workShopId + ", typeId=" + typeId + ", lines=" + Arrays.toString(lines)
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	



}
