package org.zhyan.fixed.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.Fixed_rate_detail;
import org.zhyan.fixed.dao.Fixed_rate_detailMapper;
import org.zhyan.fixed.service.Fixed_rate_detailService;
import org.zhyan.fixed.util.Page;

@Service
public class Fixed_rate_detailServiceImpl implements Fixed_rate_detailService{

	@Autowired
	private Fixed_rate_detailMapper fixedratedetailMapper;
	
	public int selectAllCounts() {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.selectAllCounts();
	}

	public List<Fixed_rate_detail> selectByPage(Page p) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.selectByPage(p);
	}

	public int deleteByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.deleteByPrimaryKey(guid);
	}

	public int insert(Fixed_rate_detail record) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.insert(record);
	}

	public int insertSelective(Fixed_rate_detail record) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.insertSelective(record);
	}

	public Fixed_rate_detail selectByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.selectByPrimaryKey(guid);
	}

	public int updateByPrimaryKeySelective(Fixed_rate_detail record) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Fixed_rate_detail record) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.updateByPrimaryKey(record);
	}

	public Fixed_rate_detail selectByNetWorth(String fixednetworth) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.selectByNetWorth(fixednetworth);
	}

	public List<Fixed_rate_detail>  selectByPid(String pid) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.selectByPid(pid);
	}

	public List<Fixed_rate_detail> selectByLowerMonth(
			Map<String, Object> parameMap) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.selectByLowerMonth(parameMap);
	}

	public List<Fixed_rate_detail> selectByPageAndLoginTime(
			Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return fixedratedetailMapper.selectByPageAndLoginTime(paramMap);
	}

}
