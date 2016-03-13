/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:46:49
 * @desc 厂房
 */

package org.summer.dp.cms.repository.cloud;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.summer.dp.cms.entity.base.Account;
import org.summer.dp.cms.entity.base.cloud.DimWorkshop;



public interface DimWorkshopRepository extends PagingAndSortingRepository<DimWorkshop, Long>, JpaSpecificationExecutor<DimWorkshop>{
	
}
