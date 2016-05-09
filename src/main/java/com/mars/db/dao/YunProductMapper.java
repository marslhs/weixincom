package com.mars.db.dao;

import com.mars.db.bean.YunProduct;

public interface YunProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(YunProduct record);

    int insertSelective(YunProduct record);

    YunProduct selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(YunProduct record);

    int updateByPrimaryKey(YunProduct record);
}