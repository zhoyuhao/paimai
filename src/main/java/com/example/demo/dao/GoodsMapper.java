package com.example.demo.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Goods;
import com.example.demo.vo.goods_vo;

public interface GoodsMapper extends BaseMapper<Goods>{
   
	List<Goods> queryAll();
	
	List<goods_vo> queryStartAndEndDate();
	
	List<goods_vo> queryNoStartAndEndDate();
}