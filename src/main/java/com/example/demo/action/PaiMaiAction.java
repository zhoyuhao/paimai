package com.example.demo.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.biz.*;
import com.example.demo.pojo.User;

@RestController
@RequestMapping("paimai/api")
public class PaiMaiAction {

	@Autowired
	private UserBiz userBiz;//user biz
	
	
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
}
