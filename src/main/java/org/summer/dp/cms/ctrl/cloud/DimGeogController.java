/**
 * @author 
 * @version 1.0
 * @since  2016-03-12 14:54:25
 * @desc 地理位置维度
 */

package org.summer.dp.cms.ctrl.cloud;


import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.summer.dp.cms.ctrl.BaseController;
import org.summer.dp.cms.entity.base.cloud.DimGeog;
import org.summer.dp.cms.helper.servlet.Servlets;
import org.summer.dp.cms.service.cloud.DimGeogService;
import org.summer.dp.cms.support.PageRequest;
import org.summer.dp.cms.support.Response;





@RestController
@RequestMapping("/dimGeog")
public class DimGeogController  extends BaseController {
	@Autowired
	private DimGeogService dimGeogService;
	
	@RequestMapping(value = "/find")
	@ResponseBody
	public Response findPage(ServletRequest request,PageRequest pageRequest, Response response,HttpSession session ) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "");
		Page<DimGeog> page = dimGeogService.findPage(pageRequest,searchParams);
		response.setFieldPaths(new String[]{
			""
		});
		response.setData(page);
		return response;
	}
	
	
}
