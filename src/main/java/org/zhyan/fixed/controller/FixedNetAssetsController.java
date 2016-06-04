package org.zhyan.fixed.controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zhyan.fixed.bean.Fixed_net_asset;
import org.zhyan.fixed.common.GetSelectYearTime;
import org.zhyan.fixed.excelview.FixedNetAssetExcelView;
import org.zhyan.fixed.service.Fixed_net_assetService;
import org.zhyan.fixed.util.MD5;
import org.zhyan.fixed.util.Page;
import org.zhyan.fixed.util.TimeUtil;

@RequestMapping(value = "fixednetassets")
@Controller
public class FixedNetAssetsController {

	private Map<String,Object> commonMap;
	@Autowired
	private Fixed_net_assetService fixednetassetService;
	@RequestMapping(value = "index")
	@ResponseBody
	public ModelAndView index(HttpServletRequest request,Map<String,Object> resultMap,HttpSession session){
		String currentPage = request.getParameter("page");
		String loginTime = session.getAttribute("logintime").toString();
		String yearStr = session.getAttribute("year").toString();
		
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				String[] tempTime = loginTime.split("-");
				int loginMonth = Integer.parseInt(tempTime[1]);
				int yearInt = Integer.parseInt(yearStr);
				int allCounts = fixednetassetService.allCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				
				Page p = new Page(allCounts,Integer.parseInt(currentPage));
				List<Fixed_net_asset> fixednetassetList = fixednetassetService.selectByPage(p);
				if(fixednetassetList.size() > 0){
					for(int i=0;i<fixednetassetList.size();i++){
						int selectYear = GetSelectYearTime.getSelectYear(loginTime, TimeUtil.dateToStringWithDay(fixednetassetList.get(i).getCreateTime()), Integer.parseInt(fixednetassetList.get(i).getLife().toString()), yearInt);
						int selectMonth = GetSelectYearTime.getSelectMonth(loginTime, TimeUtil.dateToStringWithDay(fixednetassetList.get(i).getCreateTime()),  Integer.parseInt(fixednetassetList.get(i).getLife().toString()), yearInt);
						System.out.print("selectYear:"+selectYear);
						System.out.print("selectMonth:"+selectMonth);
						if(selectYear < yearInt){
							fixednetassetList.remove(i);
							allCounts--;
						}else{
							if(loginMonth > selectMonth){
								fixednetassetList.remove(i);
								allCounts--;
							}
						} 
						
					}
					resultMap.put("fixedList", fixednetassetList);
					resultMap.put("nums", allCounts);
					resultMap.put("pages", p);
					
				}else{
					resultMap.put("fixedList",fixednetassetList);
					resultMap.put("nums",0);
					resultMap.put("pages",p);
				}
				resultMap.put("currentpage", "固定资产管理");
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/fixednetassets/allfixednetassets");
	}
	
	@RequestMapping(value = "add")
	@ResponseBody
	public ModelAndView add(HttpServletRequest request){
						
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				
			} else {
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/fixednetassets/add");
	}
	
	@RequestMapping(value = "edit")
	@ResponseBody
	public ModelAndView edit(HttpServletRequest request,Map<String,Object> resultMap){
		String guid = request.getParameter("guid");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Fixed_net_asset fixed = fixednetassetService.selectByPrimaryKey(guid);
				resultMap.put("fixed", fixed);
			} else {
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/fixednetassets/edit");
	}
	
	@RequestMapping(value = "editsubmit")
	@ResponseBody
	public ModelAndView editSubmit(HttpServletRequest request,Map<String,Object> resultMap,HttpSession session){
		String total = request.getParameter("total");
		String page = request.getParameter("page");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String ssize = request.getParameter("ssize");
		String units = request.getParameter("units");
		String life = request.getParameter("life");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String guid = request.getParameter("guid");
		String buytime = request.getParameter("buytime");
		String loginTime = session.getAttribute("logintime").toString();
		String yearStr = session.getAttribute("year").toString();
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Fixed_net_asset fixnetasset = fixednetassetService.selectByPrimaryKey(guid);
				if(fixnetasset != null){
					fixnetasset.setTotal(total);
					fixnetasset.setPage(page);
					fixnetasset.setCode(code);
					fixnetasset.setName(name);
					fixnetasset.setSsize(ssize);
					fixnetasset.setUnits(units);
					if(!buytime.isEmpty()){
						fixnetasset.setCreateTime(TimeUtil.stringToDate(buytime));
					}
					if(MD5.isNumber(life)){
						fixnetasset.setLife(Long.parseLong(life));
					}

					if(MD5.isPointNumber(year)){
						fixnetasset.setYear(Double.parseDouble(year));
					}
					if(MD5.isPointNumber(month)){
						fixnetasset.setMonth(Double.parseDouble(month));
					}
					fixednetassetService.updateByPrimaryKey(fixnetasset);
				}
				
				int allCounts = fixednetassetService.allCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,1);
				List<Fixed_net_asset> fixednetassetList = fixednetassetService.selectByPage(p);
				String[] tempTime = loginTime.split("-");
				int loginMonth = Integer.parseInt(tempTime[1]);
				int yearInt = Integer.parseInt(yearStr);
				if(fixednetassetList.size() > 0){
					for(int i=0;i<fixednetassetList.size();i++){
						int selectYear = GetSelectYearTime.getSelectYear(loginTime, TimeUtil.dateToStringWithDay(fixednetassetList.get(i).getCreateTime()), Integer.parseInt(fixednetassetList.get(i).getLife().toString()), yearInt);
						int selectMonth = GetSelectYearTime.getSelectMonth(loginTime, TimeUtil.dateToStringWithDay(fixednetassetList.get(i).getCreateTime()),  Integer.parseInt(fixednetassetList.get(i).getLife().toString()), yearInt);
						System.out.print("selectYear:"+selectYear);
						System.out.print("selectMonth:"+selectMonth);
						if(selectYear < yearInt){
							fixednetassetList.remove(i);
							allCounts--;
						}else{
							if(loginMonth > selectMonth){
								fixednetassetList.remove(i);
								allCounts--;
							}
						} 
						
					}
					resultMap.put("fixedList", fixednetassetList);
					resultMap.put("nums", allCounts);
					resultMap.put("pages", p);
					
				}else{
					resultMap.put("fixedList",fixednetassetList);
					resultMap.put("nums",0);
					resultMap.put("pages",p);
				}
				resultMap.put("currentpage", "固定资产管理");
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		return new ModelAndView("/fixednetassets/allfixednetassets");
	}
	
	
	@RequestMapping(value = "addsubmit")
	@ResponseBody
	public ModelAndView addSubmit(HttpServletRequest request,Map<String,Object> resultMap,HttpSession session){
		String total = request.getParameter("total");
		String page = request.getParameter("page");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String ssize = request.getParameter("ssize");
		String units = request.getParameter("units");
		String life = request.getParameter("life");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String buytime = request.getParameter("buytime");
		String loginTime = session.getAttribute("logintime").toString();
		String yearStr = session.getAttribute("year").toString();
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Fixed_net_asset fixnetasset = fixednetassetService.selectByCode(code);
				if(fixnetasset == null){
					fixnetasset = new Fixed_net_asset();
					fixnetasset.setGuid(MD5.getGuid());
					fixnetasset.setTotal(total);
					fixnetasset.setPage(page);
					fixnetasset.setCode(code);
					fixnetasset.setName(name);
					fixnetasset.setSsize(ssize);
					fixnetasset.setUnits(units);
					
					if(!buytime.isEmpty()){
						fixnetasset.setCreateTime(TimeUtil.stringToDate(buytime));
					}
					if(MD5.isNumber(life)){
						fixnetasset.setLife(Long.parseLong(life));
					}

					if(MD5.isPointNumber(year)){
						fixnetasset.setYear(Double.parseDouble(year));
					}
					if(MD5.isPointNumber(month)){
						fixnetasset.setMonth(Double.parseDouble(month));
					}
					fixednetassetService.insert(fixnetasset);
				}
				int allCounts = fixednetassetService.allCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,1);
				List<Fixed_net_asset> fixednetassetList = fixednetassetService.selectByPage(p);
				String[] tempTime = loginTime.split("-");
				int loginMonth = Integer.parseInt(tempTime[1]);
				int yearInt = Integer.parseInt(yearStr);
				if(fixednetassetList.size() > 0){
					for(int i=0;i<fixednetassetList.size();i++){
						int selectYear = GetSelectYearTime.getSelectYear(loginTime, TimeUtil.dateToStringWithDay(fixednetassetList.get(i).getCreateTime()), Integer.parseInt(fixednetassetList.get(i).getLife().toString()), yearInt);
						int selectMonth = GetSelectYearTime.getSelectMonth(loginTime, TimeUtil.dateToStringWithDay(fixednetassetList.get(i).getCreateTime()),  Integer.parseInt(fixednetassetList.get(i).getLife().toString()), yearInt);
						System.out.print("selectYear:"+selectYear);
						System.out.print("selectMonth:"+selectMonth);
						if(selectYear < yearInt){
							fixednetassetList.remove(i);
							allCounts--;
						}else{
							if(loginMonth > selectMonth){
								fixednetassetList.remove(i);
								allCounts--;
							}
						} 
						
					}
					resultMap.put("fixedList", fixednetassetList);
					resultMap.put("nums", allCounts);
					resultMap.put("pages", p);
					
				}else{
					resultMap.put("fixedList",fixednetassetList);
					resultMap.put("nums",0);
					resultMap.put("pages",p);
				}
				resultMap.put("currentpage", "固定资产管理");
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/fixednetassets/allfixednetassets");
	}
	
	
	@RequestMapping(value = "export")
	@ResponseBody
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,HttpSession session)     
		    throws Exception {
		String loginTime = session.getAttribute("logintime").toString();
		String yearStr = session.getAttribute("year").toString();
		String fileName = "固定资产管理" + loginTime + ".xls";
		String downloadFileName = new String(fileName.getBytes("gb2312"),"iso8859-1");
		FixedNetAssetExcelView fixedNetAssetExcelView = new FixedNetAssetExcelView();
//		String currentPage = request.getParameter("page");

		
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
		
				String[] tempTime = loginTime.split("-");
				int loginMonth = Integer.parseInt(tempTime[1]);
				int yearInt = Integer.parseInt(yearStr);
				int allCounts = fixednetassetService.allCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
		
		//		Page p = new Page(allCounts,Integer.parseInt(currentPage));
				List<Fixed_net_asset> fixednetassetList = fixednetassetService.selectAllAssets();
				if(fixednetassetList.size() > 0){
					for(int i=0;i<fixednetassetList.size();i++){
						int selectYear = GetSelectYearTime.getSelectYear(loginTime, TimeUtil.dateToStringWithDay(fixednetassetList.get(i).getCreateTime()), Integer.parseInt(fixednetassetList.get(i).getLife().toString()), yearInt);
						int selectMonth = GetSelectYearTime.getSelectMonth(loginTime, TimeUtil.dateToStringWithDay(fixednetassetList.get(i).getCreateTime()),  Integer.parseInt(fixednetassetList.get(i).getLife().toString()), yearInt);
						System.out.print("selectYear:"+selectYear);
						System.out.print("selectMonth:"+selectMonth);
						if(selectYear < yearInt){
							fixednetassetList.remove(i);
							allCounts--;
						}else{
							if(loginMonth > selectMonth){
								fixednetassetList.remove(i);
								allCounts--;
							}
						} 
						
					 }
					
					 HSSFWorkbook wb = fixedNetAssetExcelView.FixedNetAssetsExport(fixednetassetList);  
					 response.setContentType("application/vnd.ms-excel");  
					 response.setHeader("Content-disposition", "attachment;filename="+downloadFileName);  
					 
					 OutputStream ouputStream = response.getOutputStream();  
					 wb.write(ouputStream);  
					 ouputStream.flush();  
					 ouputStream.close(); 
				}
					
			}
			}catch(AuthenticationException e){
				
			}

	}	
	
	
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public boolean delete(HttpServletRequest request){
		String guid = request.getParameter("guid");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				String[] guidArray = guid.split(",");
				for(int i=0;i < guidArray.length;i++){
					fixednetassetService.deleteByPrimaryKey(guidArray[i]);
				}
			} else {
				return false;
			}
				
		}catch(AuthenticationException e){
			return false;
		}
		
		return true;
	}
}
