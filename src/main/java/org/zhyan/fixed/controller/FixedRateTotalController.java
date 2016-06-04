package org.zhyan.fixed.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zhyan.fixed.bean.Fixed_rate_detail;
import org.zhyan.fixed.bean.Fixed_rate_total_month;
import org.zhyan.fixed.service.Fixed_rate_detailService;
import org.zhyan.fixed.service.Fixed_rate_total_monthService;
import org.zhyan.fixed.util.Page;

@RequestMapping(value = "ratetotal")
@Controller
public class FixedRateTotalController {

	private Map<String,Object> commonMap;
	@Autowired
	private Fixed_rate_detailService fixedRateDetailService;
	
	@Autowired 
	private Fixed_rate_total_monthService fixed_rate_total_monthService;
	@RequestMapping(value = "index")
	@ResponseBody
	public ModelAndView index(HttpServletRequest request,Map<String,Object> resultMap,HttpSession session){
		String logintime = session.getAttribute("logintime").toString();
		String page = request.getParameter("page");
		commonMap = new HashMap<String,Object>();
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				String[] tempTime = logintime.split("-");
				int allCounts = fixedRateDetailService.selectAllCounts();
				Page p = new Page(allCounts,Integer.parseInt(page));
				commonMap.put("year", tempTime[0]);
				commonMap.put("month", tempTime[1]);
				commonMap.put("day", tempTime[2]);
				commonMap.put("startPos", p.getStartPos());
				commonMap.put("pageSize", p.getPageSize());
				List<Fixed_rate_total_month> fixedRateDetailList = fixed_rate_total_monthService.selectByPageAndLoginTime(commonMap);
				if(fixedRateDetailList.size() > 0){
					resultMap.put("fixedList", fixedRateDetailList);
				}
				resultMap.put("currentpage", "固定资产原值及折旧汇总表");
				resultMap.put("currentMonth", tempTime[1]);
				resultMap.put("nums", fixedRateDetailList.size());
				resultMap.put("pages", p);
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/ratetotal/alltotal");
	}
	
}
