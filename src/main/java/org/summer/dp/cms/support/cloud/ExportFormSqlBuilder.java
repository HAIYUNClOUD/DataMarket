package org.summer.dp.cms.support.cloud;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	private static final String tdoc = "t.";
	private static final String AS = " as ";
//	private static final String dimdatetime_table = "dim_datatime dt";
//	private static final String dimgeog_table = "dim_geog dg";
//	private static final String dimworkshop_table = "dim_workshop dw";
//	private static final String dimtype_table = "dim_type dtype";
	public static final String YEAR = "YEAR";
	public static final String MONTH = "MONTH";
	public static final String DAY = "DAY";
	public static final String HOUR = "HOUR";
	public static final String DIMGEOG = "DIMGEOG";
	public static final String DIMTYPE = "DIMTYPE";
	public static final String DIMWORKSHOP = "DIMWORKSHOP";

//	private static final String AVG = "AVG";
//	private static final String SUM = "SUM";
//	private static final String MAX = "MAX";
//	private static final String MIN = "MIN";
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
		for(String columnAndFunction:exportFormRequest.getLines()){
			String[] columnAndFunctionArray = columnAndFunction.split("-");
			String column = columnAndFunctionArray[0];
			selectsql.append(columnAndFunctionArray[1]).append(left).append(tdoc).append(column).append(right).append(AS).append(column+columnAndFunctionArray[1]).append(DOUHAO);
		}
		
		
		//build where 
		wheresql.append(" create_date >= '" + sdf.format(exportFormRequest.getStartDate())+"'");
		wheresql.append(" and create_date <= '" + sdf.format(exportFormRequest.getEndDate())+"'");
		if(StringUtils.isNotBlank(exportFormRequest.getGeogId()))wheresql.append(" and  dg.id = " + exportFormRequest.getGeogId());
		if(StringUtils.isNotBlank(exportFormRequest.getTypeId()))wheresql.append(" and dtype.id = " + exportFormRequest.getTypeId());
		if(StringUtils.isNotBlank(exportFormRequest.getWorkShopId()))wheresql.append(" and dw.id = " + exportFormRequest.getWorkShopId());

		//build group by
		if(exportFormRequest.getGroupby().equals(YEAR)){ groupBysql.append("dt.year");selectsql.append("dt.year");  }
		if(exportFormRequest.getGroupby().equals(MONTH)){ groupBysql.append("dt.month");selectsql.append("dt.month");  }
		if(exportFormRequest.getGroupby().equals(DAY)){ groupBysql.append("dt.day");selectsql.append("dt.day");    }
		if(exportFormRequest.getGroupby().equals(HOUR)){ groupBysql.append("dt.hour");selectsql.append("dt.hour");   }
		if(exportFormRequest.getGroupby().equals(DIMGEOG)){selectsql.append("dg.id");groupBysql.append("dg.id"); }
		if(exportFormRequest.getGroupby().equals(DIMTYPE)){selectsql.append("dt.id");groupBysql.append("dt.id");}
		if(exportFormRequest.getGroupby().equals(DIMWORKSHOP)){selectsql.append("dw,id");groupBysql.append("dw.id");}



		return selectsql.toString() + fromsql.toString() + wheresql.toString() + groupBysql.toString();
	}
}
