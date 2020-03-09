package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Goodsdetailed;
import com.example.demo.vo.goodsDetailed_vo;

public interface GoodsdetailedMapper extends BaseMapper<Goodsdetailed>{
 
	/**查看详细拍卖记录
	 * 
	 * @param id
	 * @return
	 */
	List<goodsDetailed_vo> queryCount(@Param("id") Integer id);
}