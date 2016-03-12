package org.summer.dp.cms.vo;

/**
 * 报表BEAN
 * @author 赵宝东
 *
 */
public class ExportForm {

	private String electricNumber;
	private String gasNumber;
	private String productionNumber;
	private String saleNumber;
	private String temperatureNumber;
	private String warnNumber;
	private String waterNumber;
	private String year;
	private String month;
	private String day;
	private String hour;
	private String id;
	public String getElectricNumber() {
		return electricNumber;
	}
	public void setElectricNumber(String electricNumber) {
		this.electricNumber = electricNumber;
	}
	public String getGasNumber() {
		return gasNumber;
	}
	public void setGasNumber(String gasNumber) {
		this.gasNumber = gasNumber;
	}
	public String getProductionNumber() {
		return productionNumber;
	}
	public void setProductionNumber(String productionNumber) {
		this.productionNumber = productionNumber;
	}
	public String getSaleNumber() {
		return saleNumber;
	}
	public void setSaleNumber(String saleNumber) {
		this.saleNumber = saleNumber;
	}
	public String getTemperatureNumber() {
		return temperatureNumber;
	}
	public void setTemperatureNumber(String temperatureNumber) {
		this.temperatureNumber = temperatureNumber;
	}
	public String getWarnNumber() {
		return warnNumber;
	}
	public void setWarnNumber(String warnNumber) {
		this.warnNumber = warnNumber;
	}
	public String getWaterNumber() {
		return waterNumber;
	}
	public void setWaterNumber(String waterNumber) {
		this.waterNumber = waterNumber;
	}
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExportForm [electricNumber=");
		builder.append(electricNumber);
		builder.append(", gasNumber=");
		builder.append(gasNumber);
		builder.append(", productionNumber=");
		builder.append(productionNumber);
		builder.append(", saleNumber=");
		builder.append(saleNumber);
		builder.append(", temperatureNumber=");
		builder.append(temperatureNumber);
		builder.append(", warnNumber=");
		builder.append(warnNumber);
		builder.append(", waterNumber=");
		builder.append(waterNumber);
		builder.append(", year=");
		builder.append(year);
		builder.append(", month=");
		builder.append(month);
		builder.append(", day=");
		builder.append(day);
		builder.append(", hour=");
		builder.append(hour);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	public ExportForm(String electricNumber, String gasNumber, String productionNumber, String saleNumber,
			String temperatureNumber, String warnNumber, String waterNumber) {
		super();
		this.electricNumber = electricNumber;
		this.gasNumber = gasNumber;
		this.productionNumber = productionNumber;
		this.saleNumber = saleNumber;
		this.temperatureNumber = temperatureNumber;
		this.warnNumber = warnNumber;
		this.waterNumber = waterNumber;
	}
	
	
}
