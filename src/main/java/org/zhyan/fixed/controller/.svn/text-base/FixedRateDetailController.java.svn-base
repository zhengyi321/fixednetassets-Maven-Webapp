package org.zhyan.fixed.controller;

import java.text.ParseException;
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
import org.zhyan.fixed.bean.Fixed_net_asset;
import org.zhyan.fixed.bean.Fixed_rate_detail;
import org.zhyan.fixed.common.AssetAllRate;
import org.zhyan.fixed.service.Fixed_net_assetService;
import org.zhyan.fixed.service.Fixed_rate_detailService;
import org.zhyan.fixed.util.MD5;
import org.zhyan.fixed.util.TimeUtil;


@RequestMapping(value = "fixedratedetail")
@Controller
public class FixedRateDetailController {

	private Map<String,Object> parameMap;
	@Autowired
	private Fixed_net_assetService fixednetassetService;
	
	@Autowired
	private Fixed_rate_detailService fixedratedetailService;
	
	@RequestMapping(value = "select")
	@ResponseBody
	public ModelAndView select(HttpServletRequest request,Map<String,Object> resultMap,HttpSession session) throws ParseException{
		String guid = request.getParameter("guid");
		String logintime = session.getAttribute("logintime").toString();
		String year = session.getAttribute("year").toString();
		String[] tempTime = logintime.split("-");
		int maxDay = TimeUtil.yearMonthReturnDays(tempTime[0]+"-"+tempTime[1]);
		int yearInt = Integer.parseInt(year);
		int tempYearInt = Integer.parseInt(tempTime[0]);
		
		parameMap = new HashMap<String,Object>();
		parameMap.put("year", year);
		if(tempYearInt > yearInt){
			parameMap.put("month", 13);
		}else{
			if(tempTime[2].equals(""+maxDay)){
				parameMap.put("month", tempTime[1]+1);
			}else{
				parameMap.put("month", tempTime[1]);
			}
		}
		parameMap.put("guid", guid);
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Fixed_net_asset fixednetasset = fixednetassetService.selectByPrimaryKey(guid);
				resultMap.put("fixednetasset", fixednetasset);
				session.setAttribute("guid", guid);
				List<Fixed_rate_detail> fixedDetailList = fixedratedetailService.selectByLowerMonth(parameMap);
				resultMap.put("fixedDetailList", fixedDetailList);
			} else {
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		return new ModelAndView("/fixedratedetail/fixedratedetailselect");
	}
	
	
	@RequestMapping(value = "add")
	@ResponseBody
	public ModelAndView add(HttpServletRequest request,Map<String,Object> resultMap,HttpSession session){
		
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				
			} else {
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		return new ModelAndView("/fixedratedetail/add");
	}
	@RequestMapping(value = "addsubmit")
	@ResponseBody
	public ModelAndView addSubmit(HttpServletRequest request,Map<String,Object> resultMap,HttpSession session) throws ParseException{
		String guid = session.getAttribute("guid").toString();
		String remark = request.getParameter("remark");
		String fixedBalanceNum = request.getParameter("fixedBalanceNum");
		String fixedBalancePrice = request.getParameter("fixedBalancePrice");
//		String sumDepreciationCurrentmonth = request.getParameter("sumDepreciationCurrentmonth");
		String sumDepreciationTotal = request.getParameter("sumDepreciationTotal");
//		String fixedNetWorth = request.getParameter("fixedNetWorth");
		String feeType = request.getParameter("feetype");
		String year = session.getAttribute("year").toString();
		String logintime = session.getAttribute("logintime").toString();
		String[] tempTime = logintime.split("-");
		int maxDay = TimeUtil.yearMonthReturnDays(tempTime[0]+"-"+tempTime[1]);
		int yearInt = Integer.parseInt(year);
		int tempYearInt = Integer.parseInt(tempTime[0]);
		
		parameMap = new HashMap<String,Object>();
		parameMap.put("year", year);
		if(tempYearInt > yearInt){
			parameMap.put("month", 13);
		}else{
			if(tempTime[2].equals(""+maxDay)){
				parameMap.put("month", tempTime[1]+1);
			}else{
				parameMap.put("month", tempTime[1]);
			}
		}
		parameMap.put("guid", guid);
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Fixed_net_asset fixednetasset = fixednetassetService.selectByPrimaryKey(guid);
				String[] timeTemp = TimeUtil.dateToStringWithDay(fixednetasset.getCreateTime()).split("-");
				int yearTemp = Integer.parseInt(timeTemp[0]);
				int monthTemp = Integer.parseInt(timeTemp[1]);
				resultMap.put("fixednetasset", fixednetasset);
				List<Fixed_rate_detail>  fixedratedetailList = fixedratedetailService.selectByPid(guid);
				if(fixedratedetailList.size() == 0){
					Fixed_rate_detail fixedratedetail = new Fixed_rate_detail();
					fixedratedetail.setGuid(MD5.getGuid());
					fixedratedetail.setPid(guid);
					fixedratedetail.setRemark(remark);
					fixedratedetail.setYear(year);
					fixedratedetail.setName(fixednetasset.getName());
					fixedratedetail.setFlag(0);
					if(MD5.isNumber(fixedBalanceNum)){
						fixedratedetail.setFixedBalanceNum(Long.parseLong(fixedBalanceNum));
					}
					Double tempSalvage = 0.0;
					Double tempBalancePrice = 0.0;
					if(MD5.isPointNumber(fixedBalancePrice)){
						fixedratedetail.setFixedBalancePrice(Double.parseDouble(fixedBalancePrice));
						tempSalvage = Double.parseDouble(fixedBalancePrice)*(0.05);
						tempBalancePrice = Double.parseDouble(fixedBalancePrice);
					}
				//	if(MD5.isPointNumber(fixednetasset.getMonth())){
					fixedratedetail.setSumDepreciationCurrentmonth(fixednetasset.getMonth());
			//		}
					Double tempRate = 0.0;
					if(MD5.isPointNumber(sumDepreciationTotal)){
						fixedratedetail.setSumDepreciationTotal(Double.parseDouble(sumDepreciationTotal));
						
						tempRate = fixednetasset.getMonth();
					}
					
					fixedratedetail.setFixedNetWorth(Double.parseDouble(fixedBalancePrice) - Double.parseDouble(sumDepreciationTotal) );
					
					if(feeType.equals("manage")){
						fixedratedetail.setManageFee(fixednetasset.getMonth());
					}else if(feeType.equals("made")){
						fixedratedetail.setMadeFee(fixednetasset.getMonth());
					}		
					fixedratedetailService.insert(fixedratedetail);
					AssetAllRate.insertAllRateDetail(TimeUtil.dateToStringWithDay(fixednetasset.getCreateTime()), fixednetasset.getLife(), tempBalancePrice, tempRate, tempSalvage, fixedratedetailService, feeType, guid);
					
					
					
					List<Fixed_rate_detail> fixedDetailList = fixedratedetailService.selectByLowerMonth(parameMap);
					resultMap.put("fixedDetailList", fixedDetailList);
				}
				
			} else {
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		return new ModelAndView("/fixedratedetail/fixedratedetailselect");
	}
	@RequestMapping(value = "edit")
	@ResponseBody
	public ModelAndView edit(HttpServletRequest request,HttpSession session,Map<String,Object> resultMap){
		String guid = request.getParameter("guid");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Fixed_rate_detail fixedRateDetail = fixedratedetailService.selectByPrimaryKey(guid);
				resultMap.put("fixedDetail", fixedRateDetail);
			} else {
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		return new ModelAndView("/fixedratedetail/edit");
	}
	
	@RequestMapping(value = "editsubmit")
	@ResponseBody
	public ModelAndView editSubmit(HttpServletRequest request,HttpSession session,Map<String,Object> resultMap) throws ParseException{
		String guid = request.getParameter("guid");
		String remark = request.getParameter("remark");
		String fixedBalanceNum = request.getParameter("fixedBalanceNum");
		String fixedBalancePrice = request.getParameter("fixedBalancePrice");
		String sumDepreciationCurrentmonth = request.getParameter("sumDepreciationCurrentmonth");
		String sumDepreciationTotal = request.getParameter("sumDepreciationTotal");
		String fixedNetWorth = request.getParameter("fixedNetWorth");
		String feeType = request.getParameter("feetype");
		String year = session.getAttribute("year").toString();
		String logintime = session.getAttribute("logintime").toString();
		String[] tempTime = logintime.split("-");
		int maxDay = TimeUtil.yearMonthReturnDays(tempTime[0]+"-"+tempTime[1]);
		int yearInt = Integer.parseInt(year);
		int tempYearInt = Integer.parseInt(tempTime[0]);
		parameMap = new HashMap<String,Object>();
		parameMap.put("year", year);
		if(tempYearInt > yearInt){
			parameMap.put("month", 13);
		}else{
			if(tempTime[2].equals(""+maxDay)){
				parameMap.put("month", tempTime[1]+1);
			}else{
				parameMap.put("month", tempTime[1]);
			}
		}
		parameMap.put("guid", guid);
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Fixed_rate_detail fixedRateDetail = fixedratedetailService.selectByPrimaryKey(guid);
				if(fixedRateDetail != null){
					List<Fixed_rate_detail> fixedRateDetailList = fixedratedetailService.selectByPid(fixedRateDetail.getPid());
					fixedRateDetail.setRemark(remark);
					List<Fixed_rate_detail> fixedDetailList = fixedratedetailService.selectByLowerMonth(parameMap);
					resultMap.put("fixedDetailList", fixedDetailList);				
					
				}
				
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		return new ModelAndView("/fixedratedetail/fixedratedetailselect");
	}
	
	@RequestMapping(value = "cancelrate")
	@ResponseBody
	public boolean cancelRate(HttpServletRequest request){
		String guid = request.getParameter("guid");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				String[] guidArray= guid.split(",");
				for(int i = 0;i < guidArray.length;i++){
					Fixed_rate_detail fixedRateDetail = fixedratedetailService.selectByPrimaryKey(guidArray[i]);
					AssetAllRate.cancelRate(fixedRateDetail, fixedratedetailService);
				}
			}else{
				return false;
			}
		}catch(AuthenticationException e){
			return false;
		}
		return true;
	}
}
