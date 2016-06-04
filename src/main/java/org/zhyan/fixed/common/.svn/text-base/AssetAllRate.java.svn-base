package org.zhyan.fixed.common;

import java.text.ParseException;
import java.util.List;

import org.zhyan.fixed.bean.Fixed_rate_detail;
import org.zhyan.fixed.service.Fixed_rate_detailService;
import org.zhyan.fixed.util.MD5;
import org.zhyan.fixed.util.TimeUtil;

public class AssetAllRate {
		
	
	public static void insertAllRateDetail(String buyTime,Long life,Double balancePrice,double rate,double salvage,Fixed_rate_detailService fixedRateDetailService,String feeType,String pid ){
		
		String[] tempBuyTime = buyTime.split("-");
		String tempBuyTimeYear = tempBuyTime[0];
		String tempBuyTimeMonth = tempBuyTime[1];
		String tempBuyTimeDay = tempBuyTime[2];
		Double tempSumRate = rate;
		Double tempFixedNetWorth = balancePrice - tempSumRate;
		int lastYear = Integer.parseInt(tempBuyTimeYear) + Integer.parseInt(life.toString());
		if(balancePrice > salvage){
			for(int i=Integer.parseInt(tempBuyTimeYear);i <= lastYear;i++){
				
				if(i == Integer.parseInt(tempBuyTimeYear)){
					for(int j=Integer.parseInt(tempBuyTimeMonth);j < 13;j++){
						if((tempFixedNetWorth-rate) >= salvage){
							Fixed_rate_detail fixedRateDetail = new Fixed_rate_detail();
							fixedRateDetail.setGuid(MD5.getGuid());
							fixedRateDetail.setRemark("折旧");
							if(feeType.equals("manage"))
							{
								fixedRateDetail.setManageFee(rate);
							}else if(feeType.equals("made")){
								fixedRateDetail.setMadeFee(rate);
							}
							tempSumRate += rate;
							tempFixedNetWorth = balancePrice - tempSumRate;
							fixedRateDetail.setFlag(0);
							fixedRateDetail.setSumDepreciationCurrentmonth(rate);
							fixedRateDetail.setSumDepreciationTotal(tempSumRate);
							fixedRateDetail.setFixedNetWorth(tempFixedNetWorth);
							fixedRateDetail.setPid(pid);
							fixedRateDetail.setYear(""+i);
							fixedRateDetail.setYearproffMonth(j);
							try {
								fixedRateDetail.setYearproffDay(TimeUtil.yearMonthReturnDays(""+i+"-"+j));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							fixedRateDetailService.insert(fixedRateDetail);
						}
					}
				}else if(i == lastYear){
					for(int j=1;j < Integer.parseInt(tempBuyTimeMonth);j++){
						if((tempFixedNetWorth-rate) >= salvage){
							Fixed_rate_detail fixedRateDetail = new Fixed_rate_detail();
							fixedRateDetail.setGuid(MD5.getGuid());
							fixedRateDetail.setRemark("折旧");
							if(feeType.equals("manage"))
							{
								fixedRateDetail.setManageFee(rate);
							}else if(feeType.equals("made")){
								fixedRateDetail.setMadeFee(rate);
							}
							tempSumRate += rate;
							tempFixedNetWorth = balancePrice - tempSumRate;
							fixedRateDetail.setFlag(0);
							fixedRateDetail.setSumDepreciationCurrentmonth(rate);
							fixedRateDetail.setSumDepreciationTotal(tempSumRate);
							fixedRateDetail.setFixedNetWorth(tempFixedNetWorth);
							fixedRateDetail.setPid(pid);
							fixedRateDetail.setYear(""+i);
							fixedRateDetail.setYearproffMonth(j);
							try {
								fixedRateDetail.setYearproffDay(TimeUtil.yearMonthReturnDays(""+i+"-"+j));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							fixedRateDetailService.insert(fixedRateDetail);
						}
					}
				}else{
					for(int j=1;j < 13;j++){
						if((tempFixedNetWorth-rate) >= salvage){
							Fixed_rate_detail fixedRateDetail = new Fixed_rate_detail();
							fixedRateDetail.setGuid(MD5.getGuid());
							fixedRateDetail.setRemark("折旧");
							if(feeType.equals("manage"))
							{
								fixedRateDetail.setManageFee(rate);
							}else if(feeType.equals("made")){
								fixedRateDetail.setMadeFee(rate);
							}
							tempSumRate += rate;
							tempFixedNetWorth = balancePrice - tempSumRate;
							fixedRateDetail.setFlag(0);
							fixedRateDetail.setSumDepreciationCurrentmonth(rate);
							fixedRateDetail.setSumDepreciationTotal(tempSumRate);
							fixedRateDetail.setFixedNetWorth(tempFixedNetWorth);
							fixedRateDetail.setPid(pid);
							fixedRateDetail.setYear(""+i);
							fixedRateDetail.setYearproffMonth(j);
							try {
								fixedRateDetail.setYearproffDay(TimeUtil.yearMonthReturnDays(""+i+"-"+j));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							fixedRateDetailService.insert(fixedRateDetail);
						}
					}
					
					
				}
			}
		}
	}
	public static void updateRateDetail(String pid,Fixed_rate_detail fixedDetail,Fixed_rate_detailService fixedRateDetailService){
		List<Fixed_rate_detail> fixedRateDetailList = fixedRateDetailService.selectByPid(pid);
	}
	
	public static void cancelRate(Fixed_rate_detail fixedRateDetail,Fixed_rate_detailService fixedRateDetailService){
		List<Fixed_rate_detail> fixedRateDetailList = fixedRateDetailService.selectByPid(fixedRateDetail.getPid());
		int selectYearInt = Integer.parseInt(fixedRateDetail.getYear());
		int selectMonthInt = fixedRateDetail.getYearproffMonth();
		int tempYearInt = 0;
		int tempMonthInt = 0;
		for(int i = 0;i < fixedRateDetailList.size();i++){
			if(fixedRateDetailList.get(i).getYearproffMonth() != null){
				tempYearInt = Integer.parseInt(fixedRateDetailList.get(i).getYear());
				tempMonthInt = fixedRateDetailList.get(i).getYearproffMonth();
				if(tempYearInt == selectYearInt){
					if(tempMonthInt == selectMonthInt){
						fixedRateDetailList.get(i).setFlag(1);
					}else if(tempMonthInt > selectMonthInt){
						double tempSumDepreciationTotal = fixedRateDetailList.get(i).getSumDepreciationTotal() - fixedRateDetail.getSumDepreciationCurrentmonth();
						double tempFixedNetWorth = fixedRateDetailList.get(i).getFixedNetWorth() + fixedRateDetail.getSumDepreciationCurrentmonth();
						fixedRateDetailList.get(i).setSumDepreciationTotal(tempSumDepreciationTotal);
						fixedRateDetailList.get(i).setFixedNetWorth(tempFixedNetWorth);
					}
				}else if(tempYearInt > selectYearInt){
					double tempSumDepreciationTotal = fixedRateDetailList.get(i).getSumDepreciationTotal() - fixedRateDetail.getSumDepreciationCurrentmonth();
					double tempFixedNetWorth = fixedRateDetailList.get(i).getFixedNetWorth() + fixedRateDetail.getSumDepreciationCurrentmonth();
					fixedRateDetailList.get(i).setSumDepreciationTotal(tempSumDepreciationTotal);
					fixedRateDetailList.get(i).setFixedNetWorth(tempFixedNetWorth);
					
				}
			}
			fixedRateDetailService.updateByPrimaryKey(fixedRateDetailList.get(i));
		}
	}
}
