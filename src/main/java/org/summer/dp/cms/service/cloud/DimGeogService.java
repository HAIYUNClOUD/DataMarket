/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:54:25
 * @desc 地理位置维度
 */

package org.summer.dp.cms.service.cloud;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.summer.dp.cms.entity.base.cloud.DimGeog;
import org.summer.dp.cms.repository.cloud.DimGeogRepository;
import org.summer.dp.cms.service.BaseService;
import org.summer.dp.cms.support.persistence.DynamicSpecifications;
import org.summer.dp.cms.support.persistence.SearchFilter;


@Component
@Transactional
public class DimGeogService extends BaseService<DimGeog> {
	@Autowired
	private DimGeogRepository dimGeogRepository;

	public Page<DimGeog> findPage(Pageable pageRequest,Map<String, Object> searchParams){
		Map<String, SearchFilter> filters = SearchFilter.parse2Filter(searchParams);
		Specification<DimGeog> spec = DynamicSpecifications.bySearchFilter(filters.values(), DimGeog.class);
		return dimGeogRepository.findAll(spec,pageRequest);
	}

}
