/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:54:24
 * @desc 时间维度
 */

package org.summer.dp.cms.ctrl.cloud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.summer.dp.cms.ctrl.BaseController;
import org.summer.dp.cms.service.cloud.DimDatatimeService;




@RestController
public class DimDatatimeController extends BaseController{
	@Autowired
	private DimDatatimeService dimDatatimeService;
	
	
}
