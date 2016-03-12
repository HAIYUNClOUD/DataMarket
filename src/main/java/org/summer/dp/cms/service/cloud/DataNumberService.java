/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:54:20
 * @desc 数据表
 */

package org.summer.dp.cms.service.cloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.summer.dp.cms.entity.base.cloud.DataNumber;
import org.summer.dp.cms.repository.cloud.DataNumberRepository;
import org.summer.dp.cms.service.BaseService;


@Component
@Transactional
public class DataNumberService extends BaseService<DataNumber> {
	@Autowired
	private DataNumberRepository dataNumberRepository;
	

}
