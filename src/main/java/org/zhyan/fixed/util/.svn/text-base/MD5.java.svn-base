package org.zhyan.fixed.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;
/*
 * MD5 算法
*/
public class MD5 {
	 public static String appkey = "23289140";
	 public static String secret = "e317d16be2058107246223abbbdc0385";
	 public static String url = "https://eco.taobao.com/router/rest";
	 
	 
	 
    // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    
    public static boolean isNumber(String numberStr) { 
	    	String valid = "0123456789"; 
	    	String temp = ""; 
	    	boolean flag = true; 
	    	if(numberStr == null || numberStr.equals("") || numberStr.equals("null")) { 
	    		flag = false; 
	    	} else {
		    	for(int i = 0; i < numberStr.length(); i++) {
		    	temp = "" + numberStr.substring(i, i + 1);
			    	if(valid.indexOf(temp) == -1) {
			    		flag = false;
			    	} 
		    	} 
	    	} 
	    	return flag;
    	} 
    public static boolean isPointNumber(String numberStr) { 
    	String valid = "0123456789."; 
    	String temp = ""; 
    	boolean flag = true; 
    	if(numberStr == null || numberStr.equals("") || numberStr.equals("null")) { 
    		flag = false; 
    	} else {
	    	for(int i = 0; i < numberStr.length(); i++) {
	    	temp = "" + numberStr.substring(i, i + 1);
		    	if(valid.indexOf(temp) == -1) {
		    		flag = false;
		    	} 
	    	} 
    	} 
    	return flag;
	} 
    //pass to md5 规则
    public static String passToMd5(String pass)
    {
    	String temp = "weiya."+pass+".zhyan";
    	return GetMD5Code(temp);
    }
    //appkey
    public String getAppKey(String content)
    {
    	String appkey = null;
    	if(content != null)
    		appkey = GetMD5Code(content);
    	
    	return appkey;
    }
    
	 public String getRandNum(int charCount) {
	        String charValue = "";
	        for (int i = 0; i < charCount; i++) {
	            char c = (char) (randomInt(0, 10) + '0');
	            charValue += String.valueOf(c);
	        }
	        return charValue;
	    }
	 public int randomInt(int from, int to) {
	        Random r = new Random();
	        return from + r.nextInt(to - from);
	    }
	 
	 public static String getGuid()
	 {
	      // 创建 GUID 对象
	      UUID uuid = UUID.randomUUID();
	      // 得到对象产生的ID
	      String a = uuid.toString();
	      // 转换为大写
	      a = a.toUpperCase();
	      return a;
	 }
 //   public static void main(String[] args) {
 //       MD5 getMD5 = new MD5();
 //       System.out.println(getMD5.GetMD5Code("000000"));
//    }
}