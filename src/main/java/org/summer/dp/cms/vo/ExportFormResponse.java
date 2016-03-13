package org.summer.dp.cms.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.summer.dp.cms.support.cloud.ExportFormSqlBuilder;
/**
 * 报表折线图
 * @author 赵宝东
 *
 */
public class ExportFormResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4821315380383421989L;
	private String msg;
	private List<String> horizontalCoordinate;//横坐标时间数组
	private List<String> electricNumberVerticalCoordinate;//电量纵坐标时间数组
	private List<String> productionNumberVerticalCoordinate;//产量纵坐标时间数组
	private List<String> gasNumberVerticalCoordinate;//气量纵坐标时间数组
	private List<String> saleNumberVerticalCoordinate;//销售量纵坐标时间数组
	private List<String> temperatureNumberVerticalCoordinate;//温度纵坐标时间数组
	private List<String> warnNumberVerticalCoordinate;//热量纵坐标时间数组
	private List<String> waterNumberVerticalCoordinate;//水量纵坐标时间数组

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<String> getHorizontalCoordinate() {
		return horizontalCoordinate;
	}
	public void setHorizontalCoordinate(List<String> horizontalCoordinate) {
		this.horizontalCoordinate = horizontalCoordinate;
	}
	public List<String> getElectricNumberVerticalCoordinate() {
		return electricNumberVerticalCoordinate;
	}
	public void setElectricNumberVerticalCoordinate(List<String> electricNumberVerticalCoordinate) {
		this.electricNumberVerticalCoordinate = electricNumberVerticalCoordinate;
	}
	public List<String> getProductionNumberVerticalCoordinate() {
		return productionNumberVerticalCoordinate;
	}
	public void setProductionNumberVerticalCoordinate(List<String> productionNumberVerticalCoordinate) {
		this.productionNumberVerticalCoordinate = productionNumberVerticalCoordinate;
	}


	public List<String> getGasNumberVerticalCoordinate() {
		return gasNumberVerticalCoordinate;
	}
	public void setGasNumberVerticalCoordinate(List<String> gasNumberVerticalCoordinate) {
		this.gasNumberVerticalCoordinate = gasNumberVerticalCoordinate;
	}
	public List<String> getSaleNumberVerticalCoordinate() {
		return saleNumberVerticalCoordinate;
	}
	public void setSaleNumberVerticalCoordinate(List<String> saleNumberVerticalCoordinate) {
		this.saleNumberVerticalCoordinate = saleNumberVerticalCoordinate;
	}
	public List<String> getTemperatureNumberVerticalCoordinate() {
		return temperatureNumberVerticalCoordinate;
	}
	public void setTemperatureNumberVerticalCoordinate(List<String> temperatureNumberVerticalCoordinate) {
		this.temperatureNumberVerticalCoordinate = temperatureNumberVerticalCoordinate;
	}
	public List<String> getWarnNumberVerticalCoordinate() {
		return warnNumberVerticalCoordinate;
	}
	public void setWarnNumberVerticalCoordinate(List<String> warnNumberVerticalCoordinate) {
		this.warnNumberVerticalCoordinate = warnNumberVerticalCoordinate;
	}
	public List<String> getWaterNumberVerticalCoordinate() {
		return waterNumberVerticalCoordinate;
	}
	public void setWaterNumberVerticalCoordinate(List<String> waterNumberVerticalCoordinate) {
		this.waterNumberVerticalCoordinate = waterNumberVerticalCoordinate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExportFormResponse [horizontalCoordinate=");
		builder.append(horizontalCoordinate);
		builder.append(", electricNumberVerticalCoordinate=");
		builder.append(electricNumberVerticalCoordinate);
		builder.append(", productionNumberVerticalCoordinate=");
		builder.append(productionNumberVerticalCoordinate);
		builder.append(", gasNumberVerticalCoordinate=");
		builder.append(gasNumberVerticalCoordinate);
		builder.append(", saleNumberVerticalCoordinate=");
		builder.append(saleNumberVerticalCoordinate);
		builder.append(", temperatureNumberVerticalCoordinate=");
		builder.append(temperatureNumberVerticalCoordinate);
		builder.append(", warnNumberVerticalCoordinate=");
		builder.append(warnNumberVerticalCoordinate);
		builder.append(", waterNumberVerticalCoordinate=");
		builder.append(waterNumberVerticalCoordinate);
		builder.append("]");
		return builder.toString();
	}
	public void toResponse(List<ExportForm> list,ExportFormRequest exportFormRequest){
		List<String> lines = Arrays.asList(exportFormRequest.getLines());
	
		horizontalCoordinate = new ArrayList<String>();
		if(lines.contains(ExportFormSqlBuilder.electric_column))electricNumberVerticalCoordinate = new ArrayList<String>();
		if(lines.contains(ExportFormSqlBuilder.production_number_column))productionNumberVerticalCoordinate = new ArrayList<String>(); 
		if(lines.contains(ExportFormSqlBuilder.gas_number_column))gasNumberVerticalCoordinate = new ArrayList<String>();
		if(lines.contains(ExportFormSqlBuilder.sale_number_column))saleNumberVerticalCoordinate = new ArrayList<String>();
		if(lines.contains(ExportFormSqlBuilder.temperature_column))temperatureNumberVerticalCoordinate = new ArrayList<String>();
		if(lines.contains(ExportFormSqlBuilder.warn_number_column))warnNumberVerticalCoordinate = new ArrayList<String>();
		if(lines.contains(ExportFormSqlBuilder.water_number_column))waterNumberVerticalCoordinate = new ArrayList<String>();
		for(ExportForm exportForm:list){
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.YEAR))horizontalCoordinate.add(exportForm.getYear());
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.MONTH))horizontalCoordinate.add(exportForm.getMonth());
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.HOUR))horizontalCoordinate.add(exportForm.getHour());
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.DAY))horizontalCoordinate.add(exportForm.getDay());
			if(electricNumberVerticalCoordinate!=null)electricNumberVerticalCoordinate.add(exportForm.getElectricNumber());
			if(productionNumberVerticalCoordinate!=null)productionNumberVerticalCoordinate.add(exportForm.getProductionNumber());
			if(gasNumberVerticalCoordinate!=null)gasNumberVerticalCoordinate.add(exportForm.getGasNumber());
			if(saleNumberVerticalCoordinate!=null)saleNumberVerticalCoordinate.add(exportForm.getSaleNumber());
			if(temperatureNumberVerticalCoordinate!=null)temperatureNumberVerticalCoordinate.add(exportForm.getTemperatureNumber());
			if(warnNumberVerticalCoordinate!=null)warnNumberVerticalCoordinate.add(exportForm.getWarnNumber());
			if(waterNumberVerticalCoordinate!=null)waterNumberVerticalCoordinate.add(exportForm.getWarnNumber());
		}
	}
}
