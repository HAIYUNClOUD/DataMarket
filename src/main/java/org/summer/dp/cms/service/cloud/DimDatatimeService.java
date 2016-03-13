/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:54:24
 * @desc 时间维度
 */

package org.summer.dp.cms.service.cloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.summer.dp.cms.entity.base.cloud.DimDatatime;
import org.summer.dp.cms.repository.cloud.DimDatatimeRepository;
import org.summer.dp.cms.service.BaseService;


@Component
@Transactional
public class DimDatatimeService extends BaseService<DimDatatime> {
	@Autowired
	private DimDatatimeRepository dimDatatimeRepository;
	

}
