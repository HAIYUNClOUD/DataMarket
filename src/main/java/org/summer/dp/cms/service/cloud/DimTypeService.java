/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:54:26
 * @desc 分类AB
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
import org.summer.dp.cms.entity.base.cloud.DimType;
import org.summer.dp.cms.repository.cloud.DimTypeRepository;
import org.summer.dp.cms.service.BaseService;
import org.summer.dp.cms.support.persistence.DynamicSpecifications;
import org.summer.dp.cms.support.persistence.SearchFilter;


@Component
@Transactional
public class DimTypeService extends BaseService<DimType> {
	@Autowired
	private DimTypeRepository dimTypeRepository;

	public Page<DimType> findPage(Pageable pageRequest,Map<String, Object> searchParams){
		Map<String, SearchFilter> filters = SearchFilter.parse2Filter(searchParams);
		Specification<DimType> spec = DynamicSpecifications.bySearchFilter(filters.values(), DimType.class);
		return dimTypeRepository.findAll(spec,pageRequest);
	}

}
