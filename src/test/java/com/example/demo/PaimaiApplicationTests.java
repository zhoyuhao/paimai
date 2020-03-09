package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.action.PaiMaiAction;
import com.example.demo.biz.*;
import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Goodsdetailed;
import com.example.demo.pojo.User;
import com.example.demo.vo.goodsDetailed_vo;
import com.example.demo.vo.goods_vo;
import com.github.pagehelper.PageInfo;

@SpringBootTest
class PaimaiApplicationTests {
	
	@Autowired
	private PaiMaiAction paimai;
	
	
	@Test
	void contextLoads() {
	}
	
	
	/**登入
	 * 
	 */
	@Test
	public void login() {
		System.out.println(paimai.login("张三", "123123", null));
	}
	
	/***用户添加
	 * 
	 * 
	 */
	@Test
	public void addUser() {
		User user=new User();
		user.setUserid(0);
		user.setPower(0);
		user.setUsername("小小");
		user.setUserpwd("123123");
		System.out.println(paimai.addUser(user));
	}
	
	/**根据名称查看
	 */
	@Test
	public void userByName() {
	System.out.println(paimai.userByName("小小"));
		
	}
	
	/**商品添加
	 * 
	 */
	@Test
	public void goodsAdd() {
		Goods g=new Goods();
		g.setDepict("1111111");
		g.setGoodsid(0);
		g.setGoodsimg(null);
		g.setGoodsname("国宝");
		g.setGoodsprice(1000.f);
		g.setStartdate(new Date());
		System.out.println(paimai.goodsAdd(g));
	}
	
	/**根据id删除商品
	 * 
	 */
	@Test
	public void deleteById() {
		System.out.println(paimai.deleteById(1));
	}
	

	
	
	/**条件分页
	 * 
	 */
	@Test
	public void selesctAll(){
		goods_vo g=new goods_vo();
		g.setPageNum(1);
		g.setPageSize(3);
		paimai.selesctAll(g).getList().forEach(row->{
			System.out.println(row.getGoodsname());
		});
	}
	

	/**修改商品
	 * 
	 */
	@Test
	public void  updateGoods() {
		Goods goods=new Goods();
		goods.setGoodsid(1);
		System.out.println(paimai.updateGoods(goods));
	}
	
	/**根据id查看竞拍商品的竞拍记录
	 * 
	 */
	@Test
	public void queryCount(@PathVariable Integer id) {
		System.out.println(paimai.queryCount(1));
	}
	

	
	
	/**查看已经结束的商品
	 * 
	 */
	@Test
	public void  queryNoStartAndEndDate(){
		paimai.queryNoStartAndEndDate().forEach(row->{
			System.out.println(row.getGoodsimg());
		});
				
	}

	
}
