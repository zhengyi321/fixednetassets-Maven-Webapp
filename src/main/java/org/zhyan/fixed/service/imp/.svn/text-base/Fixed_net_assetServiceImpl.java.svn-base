package org.zhyan.fixed.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.Fixed_net_asset;
import org.zhyan.fixed.dao.Fixed_net_assetMapper;
import org.zhyan.fixed.service.Fixed_net_assetService;
import org.zhyan.fixed.util.Page;

@Service
public class Fixed_net_assetServiceImpl implements Fixed_net_assetService{

	@Autowired
	private Fixed_net_assetMapper fixed_net_assetMapper;

	public int deleteByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.deleteByPrimaryKey(guid);
	}

	public int insert(Fixed_net_asset record) {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.insert(record);
	}

	public int insertSelective(Fixed_net_asset record) {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.insertSelective(record);
	}

	public Fixed_net_asset selectByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.selectByPrimaryKey(guid);
	}

	public int updateByPrimaryKeySelective(Fixed_net_asset record) {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Fixed_net_asset record) {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.updateByPrimaryKey(record);
	}

	public Fixed_net_asset selectByCode(String code) {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.selectByCode(code);
	}

	public int allCounts() {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.allCounts();
	}

	public List<Fixed_net_asset> selectByPage(Page p) {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.selectByPage(p);
	}

	public List<Fixed_net_asset> selectAllAssets() {
		// TODO Auto-generated method stub
		return fixed_net_assetMapper.selectAllAssets();
	}
}
