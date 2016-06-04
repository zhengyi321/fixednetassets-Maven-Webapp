package org.zhyan.fixed.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {
	public static String BaseImagePath="http://192.168.10.147";
	private static String ImagePathDefault = "H:/website/tongcheng";
	
	public static String savePic(MultipartFile file,String filename)
	{
	    String path = "/"+filename+"/";
	    String picName = getFileNameNew()+".jpg";
	    File destFile=new File(ImagePathDefault+path,picName);    
		if (!destFile.exists()) {
			destFile.mkdirs();
		} 
			
		try {
			file.transferTo(destFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String realpath= path+picName;
		return realpath;
		
	}
	
    /**
     * 
     * <p class="detail">
     * 功能：重新命名文件
     * </p>
     * @author wangsheng
     * @date 2014年9月25日 
     * @return
     */
    public static String getFileNameNew(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return fmt.format(new Date());
    }
}
