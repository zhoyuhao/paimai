package com.example.demo.dao;

import com.example.demo.pojo.Goodsdetailed;

public interface GoodsdetailedMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Goodsdetailed record);

    int insertSelective(Goodsdetailed record);

    Goodsdetailed selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Goodsdetailed record);

    int updateByPrimaryKey(Goodsdetailed record);
}