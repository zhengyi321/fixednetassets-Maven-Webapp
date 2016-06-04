package org.zhyan.fixed.dao;

import java.util.List;
import java.util.Map;

import org.zhyan.fixed.bean.Fixed_rate_detail;
import org.zhyan.fixed.bean.Fixed_rate_total_month;

public interface Fixed_rate_total_monthMapper {
	
	List<Fixed_rate_total_month> selectByPageAndLoginTime(Map<String,Object> paramMap);
	
    int insert(Fixed_rate_total_month record);

    int insertSelective(Fixed_rate_total_month record);
}