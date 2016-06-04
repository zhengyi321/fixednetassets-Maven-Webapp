package org.zhyan.fixed.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.Fixed_rate_total_month;
import org.zhyan.fixed.dao.Fixed_rate_total_monthMapper;
import org.zhyan.fixed.service.Fixed_rate_total_monthService;

@Service
public class Fixed_rate_total_monthServiceImpl implements Fixed_rate_total_monthService{

	@Autowired
	private Fixed_rate_total_monthMapper fixedRateTotalMapper;
	
	public int insert(Fixed_rate_total_month record) {
		// TODO Auto-generated method stub
		return fixedRateTotalMapper.insert(record);
	}

	public int insertSelective(Fixed_rate_total_month record) {
		// TODO Auto-generated method stub
		return fixedRateTotalMapper.insertSelective(record);
	}

	public List<Fixed_rate_total_month> selectByPageAndLoginTime(
			Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return fixedRateTotalMapper.selectByPageAndLoginTime(paramMap);
	}

}
