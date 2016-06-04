package org.zhyan.fixed.service;

import java.util.List;

import org.zhyan.fixed.bean.Fixed_net_asset;
import org.zhyan.fixed.util.Page;

public interface Fixed_net_assetService {

    int deleteByPrimaryKey(String guid);

    int insert(Fixed_net_asset record);

    int insertSelective(Fixed_net_asset record);

    Fixed_net_asset selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Fixed_net_asset record);

    int updateByPrimaryKey(Fixed_net_asset record);
    
    Fixed_net_asset selectByCode(String code);
    
    int allCounts();
    
    List<Fixed_net_asset> selectByPage(Page p);
    
    List<Fixed_net_asset> selectAllAssets();
}
