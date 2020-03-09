package com.example.demo.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.biz.*;
import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Goodsdetailed;
import com.example.demo.pojo.User;
import com.example.demo.vo.goodsDetailed_vo;
import com.example.demo.vo.goods_vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("paimai/api")
public class PaiMaiAction {

	@Autowired
	private UserBiz userBiz;//user biz
	
	@Autowired
	private GoodsBiz goodsBiz;
	
	@Autowired
	private GoodsdetailedBiz deBiz;
	
	/**登入
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	@GetMapping("user/{name}/{pwd}")
	public User login(@PathVariable String name,@PathVariable String pwd,HttpSession session) {
		User user=userBiz.login(name, pwd);
		if(user!=null) {
			session.setAttribute("user",user);
			return user;	
		}
		return new User();
	}
	
	/***用户添加
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("user/add")
	public int addUser(@RequestBody User user) {
		return userBiz.addUser(user);
	}
	
	/**根据名称查看
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("user/{name}")
	public boolean userByName(@PathVariable String name) {
	return userBiz.userByName(name);
	}
	
	/**商品添加
	 * 
	 * @param g
	 * @return
	 */
	@PostMapping("goods/add")
	public int goodsAdd(@RequestBody Goods g) {
		return goodsBiz.goodsAdd(g);
	}
	
	/**根据id删除商品
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("goods/delete")
	public int deleteById(@RequestBody Integer id) {
		return goodsBiz.deleteById(id);
	}
	
	/**根据条件或者查看所有
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param g
	 * @return
	 */
	@GetMapping("goods/{pageNum}/{pageSize}")
	public PageInfo<Goods> selesctAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
		return goodsBiz.selesctAll(pageNum, pageSize);
	}
	
	
	/**条件分页
	 * 
	 * @param g
	 * @return
	 */
	@PostMapping("goods")
	public PageInfo<Goods> selesctAll(@RequestBody goods_vo g){
		return goodsBiz.selesctAll(g);
	}
	
	@PostMapping("goods/queryAll/{pageNum}/{pageSize}")
	public PageInfo<Goods> queryAll(@RequestBody goods_vo g){
		return goodsBiz.queryAll(g);
	}
	/**修改商品
	 * 
	 * @param goods
	 * @return
	 */
	@PutMapping("goods/update")
	public int  updateGoods(@RequestBody Goods goods) {
		return goodsBiz.updateGoods(goods);
	}
	
	/**根据id查看竞拍商品的竞拍记录
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("goods/queryCount/{id}")
	public List<goodsDetailed_vo> queryCount(@PathVariable Integer id) {
		return deBiz.queryCount(id);
	}
	
	@PostMapping("goods/addGoodsDetailed")
	public int addGoodsDetailed(Float price,Integer goodsid,Integer userid) {
		Goodsdetailed g=new Goodsdetailed();
		g.setDprice(price);
		g.setDdate(new Date());
		g.setGoodsid(goodsid);
		g.setUserid(userid);
		g.setDid(0);
		return deBiz.addGoodsDetailed(g);
	}

	/**查看所有已经开始的商品 以及竞拍详细
	 * 
	 * @return
	 */
	@GetMapping("goods/queryStartAndEndDate/{pageNum}/{pageSize}")
	public PageInfo<goods_vo> queryStartAndEndDate(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
		return goodsBiz.queryStartAndEndDate(pageNum, pageSize);
	}
	
	/**查看已经结束的商品
	 * 
	 * @return
	 */
	@GetMapping("goods/queryNoStartAndEndDate")
	public List<goods_vo> queryNoStartAndEndDate(){
		return goodsBiz.queryNoStartAndEndDate();
				
	}
	
}
