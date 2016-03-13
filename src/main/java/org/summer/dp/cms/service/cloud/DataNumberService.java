/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:54:20
 * @desc 数据表
 */

package org.summer.dp.cms.service.cloud;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.summer.dp.cms.entity.base.cloud.DataNumber;
import org.summer.dp.cms.repository.cloud.DataNumberRepository;
import org.summer.dp.cms.service.BaseService;
import org.summer.dp.cms.support.cloud.ExportFormSqlBuilder;
import org.summer.dp.cms.vo.ExportForm;
import org.summer.dp.cms.vo.ExportFormRequest;


@Component
@Transactional
public class DataNumberService extends BaseService<DataNumber> {
	@Autowired
	DataNumberRepository dataNumberRepository;

	@SuppressWarnings("unchecked")
	public List<ExportForm> exportForm(ExportFormRequest exportFormRequest){
		String sqlString = ExportFormSqlBuilder.genSql(exportFormRequest);
		List<ExportForm> listExportForm = new ArrayList<ExportForm>();
		Query query = this.em.createNativeQuery(sqlString);
		List list = query.getResultList();
		for(Object o : list){
			Object[] oArray = (Object[]) o;
			ExportForm exportForm = new ExportForm();
			String[] lineStringArray = exportFormRequest.getLines();
            //electric_number(电量),gas_number(气量),production_number(产量),sale_number(销售量),temperature(温度),warn_number(热量),water_number(水量)
			for(String str : lineStringArray){
				if(str.equals(ExportFormSqlBuilder.electric_column))exportForm.setElectricNumber(String.valueOf(oArray[0]));
				if(str.equals(ExportFormSqlBuilder.gas_number_column))exportForm.setGasNumber(String.valueOf(oArray[1]));
				if(str.equals(ExportFormSqlBuilder.production_number_column))exportForm.setProductionNumber(String.valueOf(oArray[2]));
				if(str.equals(ExportFormSqlBuilder.sale_number_column))exportForm.setSaleNumber(String.valueOf(oArray[3]));
				if(str.equals(ExportFormSqlBuilder.temperature_column))exportForm.setTemperatureNumber(String.valueOf(oArray[4]));
				if(str.equals(ExportFormSqlBuilder.warn_number_column))exportForm.setWarnNumber(String.valueOf(oArray[5]));
				if(str.equals(ExportFormSqlBuilder.water_number_column))exportForm.setWaterNumber(String.valueOf(oArray[6]));
			}
			int lastDown = oArray.length-1;
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.YEAR))exportForm.setYear(String.valueOf(oArray[lastDown]));
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.MONTH))exportForm.setMonth(String.valueOf(oArray[lastDown]));
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.HOUR))exportForm.setHour(String.valueOf(oArray[lastDown]));
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.DAY))exportForm.setDay(String.valueOf(oArray[lastDown]));
			listExportForm.add(exportForm);

			System.out.println(exportForm.toString());
		}
		return listExportForm;
	}
}
