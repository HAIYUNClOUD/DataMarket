/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:54:20
 * @desc 数据表
 */

package org.summer.dp.cms.ctrl.cloud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.summer.dp.cms.ctrl.BaseController;
import org.summer.dp.cms.service.cloud.DataNumberService;


@RestController
public class DataNumberController extends BaseController {
	@Autowired
	private DataNumberService dataNumberService;
	

}
