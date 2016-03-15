package org.summer.dp.cms.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 报表BEAN
 * @author 赵宝东
 *
 */
public class ExportForm {

    private List<String> columns = new ArrayList<String>();
	private String year;
	private String month;
	private String day;
	private String hour;
	private String id;

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	@Override
	public String toString() {
		return "ExportForm [columns=" + columns + ", year=" + year + ", month=" + month + ", day=" + day + ", hour="
				+ hour + ", id=" + id + "]";
	}

}
