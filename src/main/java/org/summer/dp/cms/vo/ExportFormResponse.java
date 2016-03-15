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
	private List<String> x;//横坐标时间数组
	private List<List<String>> y;//纵坐标数组
//	private List<String> electricNumberVerticalCoordinate;//电量纵坐标时间数组
//	private List<String> productionNumberVerticalCoordinate;//产量纵坐标时间数组
//	private List<String> gasNumberVerticalCoordinate;//气量纵坐标时间数组
//	private List<String> saleNumberVerticalCoordinate;//销售量纵坐标时间数组
//	private List<String> temperatureNumberVerticalCoordinate;//温度纵坐标时间数组
//	private List<String> warnNumberVerticalCoordinate;//热量纵坐标时间数组
//	private List<String> waterNumberVerticalCoordinate;//水量纵坐标时间数组

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	

	public List<String> getX() {
		return x;
	}
	public void setX(List<String> x) {
		this.x = x;
	}
	public List<List<String>> getY() {
		return y;
	}
	public void setY(List<List<String>> y) {
		this.y = y;
	}
	public void toResponse(List<ExportForm> list,ExportFormRequest exportFormRequest){
		
		x = new ArrayList<String>();
	    y = new ArrayList<List<String>>();

		for(ExportForm exportForm:list){
			y.add(exportForm.getColumns());
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.YEAR))x.add(exportForm.getYear());
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.MONTH))x.add(exportForm.getMonth());
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.HOUR))x.add(exportForm.getHour());
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.DAY))x.add(exportForm.getDay());
//			if(electricNumberVerticalCoordinate!=null)electricNumberVerticalCoordinate.add(exportForm.getElectricNumber());
//			if(productionNumberVerticalCoordinate!=null)productionNumberVerticalCoordinate.add(exportForm.getProductionNumber());
//			if(gasNumberVerticalCoordinate!=null)gasNumberVerticalCoordinate.add(exportForm.getGasNumber());
//			if(saleNumberVerticalCoordinate!=null)saleNumberVerticalCoordinate.add(exportForm.getSaleNumber());
//			if(temperatureNumberVerticalCoordinate!=null)temperatureNumberVerticalCoordinate.add(exportForm.getTemperatureNumber());
//			if(warnNumberVerticalCoordinate!=null)warnNumberVerticalCoordinate.add(exportForm.getWarnNumber());
//			if(waterNumberVerticalCoordinate!=null)waterNumberVerticalCoordinate.add(exportForm.getWarnNumber());
		}
	}
}
