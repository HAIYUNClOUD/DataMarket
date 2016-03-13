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
			ExportForm exportForm = new ExportForm(String.valueOf(oArray[0]),String.valueOf(oArray[1]),String.valueOf(oArray[2])
					,String.valueOf(oArray[3]),String.valueOf(oArray[4]),String.valueOf(oArray[5]),String.valueOf(oArray[6]));

			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.YEAR))exportForm.setYear(String.valueOf(oArray[7]));
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.MONTH))exportForm.setMonth(String.valueOf(oArray[7]));
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.HOUR))exportForm.setHour(String.valueOf(oArray[7]));
			if(exportFormRequest.getGroupby().equals(ExportFormSqlBuilder.DAY))exportForm.setDay(String.valueOf(oArray[7]));
			exportForm.setId(String.valueOf(oArray[8]));
			listExportForm.add(exportForm);
			
			System.out.println(exportForm.toString());
		}
		return listExportForm;
	}
}
