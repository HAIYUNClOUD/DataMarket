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
            //electric_number(电量),gas_number(气量),production_number(产量),sale_number(销售量),temperature(温度),warn_number(热量),water_number(水量)
			int i = 0;
			for(String columnAndFunction:exportFormRequest.getLines()){
				String[] columnAndFunctionArray = columnAndFunction.split("-");
				exportForm.getColumns().add(String.valueOf(oArray[i++]));
	
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
