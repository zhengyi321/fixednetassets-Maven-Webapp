package org.zhyan.fixed.common;

public class GetSelectYearTime {

	public static int getSelectYear(String loginTime,String buyTime,int life,int accountYear){
		String[] loginTimeArray = loginTime.split("-");
		String[] buyTimeArray = buyTime.split("-");
		try{
		int loginYear = Integer.parseInt(loginTimeArray[0]);
		int loginMonth = Integer.parseInt(loginTimeArray[1]);
		int buyTimeYear = Integer.parseInt(buyTimeArray[0]);
		int buyTimeMonth = Integer.parseInt(buyTimeArray[1]);
		int lastYear = buyTimeYear+life;
		if(loginYear >= accountYear){
			if(accountYear > lastYear){
				return -1;
			}else{
				return accountYear;
			}
		}else{
			return -2;
		}
		}catch(Exception e){
			return -99;
		}
	}
	
	public static int getSelectMonth(String loginTime,String buyTime,int life,int accountYear){
		String[] loginTimeArray = loginTime.split("-");
		String[] buyTimeArray = buyTime.split("-");
		try{
		int loginYear = Integer.parseInt(loginTimeArray[0]);
		int loginMonth = Integer.parseInt(loginTimeArray[1]);
		int buyTimeYear = Integer.parseInt(buyTimeArray[0]);
		int buyTimeMonth = Integer.parseInt(buyTimeArray[1]);
		int lastYear = buyTimeYear+life;
		if(loginYear >= accountYear){
			if(accountYear > lastYear){
				return -1;
			}else if(accountYear < lastYear){
				return 13;
			}else {
				if(loginMonth > buyTimeMonth){
					return buyTimeMonth;
				}else{
					return loginMonth;
				}
			}
		}else{
			return -2;
		}
		}catch(Exception e){
			return -99;
		}
	}
}
