package org.zhyan.fixed.service;

import java.util.List;
import java.util.Map;

import org.zhyan.fixed.bean.Fixed_rate_detail;
import org.zhyan.fixed.util.Page;

public interface Fixed_rate_detailService {

	int selectAllCounts();
	
	List<Fixed_rate_detail> selectByPage(Page p);
	
	List<Fixed_rate_detail> selectByPageAndLoginTime(Map<String,Object> paramMap);
	
	Fixed_rate_detail selectByNetWorth(String fixednetworth);
	
	List<Fixed_rate_detail> selectByPid(String pid);
	
	List<Fixed_rate_detail> selectByLowerMonth(Map<String,Object> parameMap);
	
    int deleteByPrimaryKey(String guid);

    int insert(Fixed_rate_detail record);

    int insertSelective(Fixed_rate_detail record);

    Fixed_rate_detail selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Fixed_rate_detail record);

    int updateByPrimaryKey(Fixed_rate_detail record);
}
