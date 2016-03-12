package org.summer.dp.cms.support.cloud;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.summer.dp.cms.vo.ExportFormRequest;

/**
 * 根据条件生成报表SQL语句
 * @author 赵宝东
 *
 */
public class ExportFormSqlBuilder {
	private static final String left = "(";
	private static final String right = ")";
	private static final String electric_column = "t.electric_number";
	private static final String gas_number_column = "t.gas_number";
	private static final String production_number_column = "t.production_number";
	private static final String sale_number_column = "t.sale_number";
	private static final String temperature_column = "t.temperature";
	private static final String warn_number_column = "t.warn_number";
	private static final String water_number_column = "t.water_number";
	private static final String dimdatetime_table = "dim_datatime dt";
	private static final String dimgeog_table = "dim_geog dg";
	private static final String dimworkshop_table = "dim_workshop dw";
	private static final String dimtype_table = "dim_type dtype";
	public static final String YEAR = "YEAR";
	public static final String MONTH = "MONTH";
	public static final String DAY = "DAY";
	public static final String HOUR = "HOUR";
	private static final String AVG = "AVG";
	private static final String SUM = "SUM";
	private static final String MAX = "MAX";
	private static final String MIN = "MIN";
	private static final String DOUHAO = ",";
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static String genSql(ExportFormRequest exportFormRequest){
		StringBuilder selectsql  = new StringBuilder("SELECT ");
		StringBuilder groupBysql  = new StringBuilder(" group by ");
		StringBuilder fromsql  = new StringBuilder(" from data_number t LEFT JOIN dim_datatime dt on dt.ID = t.dim_datetime_id " + 
          "LEFT JOIN dim_geog dg on dg.ID = t.dim_geog_id " +
          "LEFT JOIN dim_workshop dw on dw.ID = t.dim_workshop_id " +
          "LEFT JOIN dim_type dtype on dtype.ID = t.dim_type_id ");
		StringBuilder wheresql  = new StringBuilder(" where ");

		//build select 
		if(exportFormRequest.getFunction().equals(AVG))
			selectsql
			.append(AVG).append(left).append(electric_column).append(right).append(" as electric_number").append(DOUHAO)
			.append(AVG).append(left).append(gas_number_column).append(right).append(" as gas_number").append(DOUHAO)
			.append(AVG).append(left).append(production_number_column).append(right).append(" as production_number").append(DOUHAO)
			.append(AVG).append(left).append(sale_number_column).append(right).append(" as sale_number").append(DOUHAO)
			.append(AVG).append(left).append(temperature_column).append(right).append(" as temperature").append(DOUHAO)
			.append(AVG).append(left).append(warn_number_column).append(right).append(" as warn_number").append(DOUHAO)
			.append(AVG).append(left).append(water_number_column).append(right).append(" as water_number").append(DOUHAO);

		if(exportFormRequest.getFunction().equals(SUM))
			selectsql			
			.append(SUM).append(left).append(electric_column).append(right).append(" as electric_number").append(DOUHAO)
			.append(SUM).append(left).append(gas_number_column).append(right).append(" as gas_number").append(DOUHAO)
			.append(SUM).append(left).append(production_number_column).append(right).append(" as production_number").append(DOUHAO)
			.append(SUM).append(left).append(sale_number_column).append(right).append(" as sale_number").append(DOUHAO)
			.append(SUM).append(left).append(temperature_column).append(right).append(" as temperature").append(DOUHAO)
			.append(SUM).append(left).append(warn_number_column).append(right).append(" as warn_number").append(DOUHAO)
			.append(SUM).append(left).append(water_number_column).append(right).append(" as water_number").append(DOUHAO);

		//build where 
        wheresql.append(" create_date >= '" + sdf.format(exportFormRequest.getStartDate())+"'");
        wheresql.append(" and create_date <= '" + sdf.format(exportFormRequest.getEndDate())+"'");
        
		//build group by
		if(exportFormRequest.getGroupby().equals(YEAR)){ groupBysql.append("dt.year");selectsql.append("dt.year");  }
		if(exportFormRequest.getGroupby().equals(MONTH)){ groupBysql.append("dt.month");selectsql.append("dt.month");  }
		if(exportFormRequest.getGroupby().equals(DAY)){ groupBysql.append("dt.day");selectsql.append("dt.day");    }
		if(exportFormRequest.getGroupby().equals(HOUR)){ groupBysql.append("dt.hour");selectsql.append("dt.hour");   }

		//dimType;//1 dimGeog 2 dimType 3 dimWorkshop
		if(exportFormRequest.getDimType()==1) {
			if(groupBysql.length()>0) groupBysql.append(",");
			if(selectsql.length()>0) selectsql.append(",");
			selectsql.append("dg.id");
			groupBysql.append("dg.id");
		}else  if(exportFormRequest.getDimType()==2) {
			if(groupBysql.length()>0) groupBysql.append(",");
			if(selectsql.length()>0) selectsql.append(",");
			selectsql.append("dt.id");
			groupBysql.append("dt.id");
		}else  if(exportFormRequest.getDimType()==3) {
			if(groupBysql.length()>0) groupBysql.append(",");
			if(selectsql.length()>0) selectsql.append(",");
			selectsql.append("dw,id");
			groupBysql.append("dw.id");
		}


		return selectsql.toString() + fromsql.toString() + wheresql.toString() + groupBysql.toString();
	}
}
