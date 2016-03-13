/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:46:42
 * @desc 数据表
 */

package org.summer.dp.cms.repository.cloud;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.summer.dp.cms.entity.base.Account;
import org.summer.dp.cms.entity.base.cloud.DataNumber;



public interface DataNumberRepository extends PagingAndSortingRepository<DataNumber, Long>, JpaSpecificationExecutor<Account>{
	
}
