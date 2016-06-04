package org.zhyan.fixed.dao;

import org.zhyan.fixed.bean.Fixed_rate_detail;

public interface Fixed_rate_detailMapper {
    int deleteByPrimaryKey(String guid);

    int insert(Fixed_rate_detail record);

    int insertSelective(Fixed_rate_detail record);

    Fixed_rate_detail selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Fixed_rate_detail record);

    int updateByPrimaryKey(Fixed_rate_detail record);
}