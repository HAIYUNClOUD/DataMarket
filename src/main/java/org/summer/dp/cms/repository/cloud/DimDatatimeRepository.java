/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:46:47
 * @desc 时间维度
 */

package org.summer.dp.cms.repository.cloud;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.summer.dp.cms.entity.base.Account;
import org.summer.dp.cms.entity.base.cloud.DimDatatime;



public interface DimDatatimeRepository extends PagingAndSortingRepository<DimDatatime, Long>, JpaSpecificationExecutor<Account>{
	
}
