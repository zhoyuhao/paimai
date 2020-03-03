package com.example.demo.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.READ_COMMITTED,readOnly = true)
public class UserBiz {
	
	@Autowired
	private UserMapper dao;
	
	/**用戶添加
	 * 
	 * @param user
	 * @return
	 */
	@Transactional(propagation =Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = false)
	public int addUser(User user) {
		return dao.insert(user);
	}
	
	/**用户登入
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User login(String name,String pwd) {
		QueryWrapper<User> qw=Wrappers.query();
		qw.eq("userName",name).eq("userPwd", pwd);
		if(dao.selectList(qw).size()!=0) {
			return dao.selectList(qw).get(0);
		}
		return null;
	}
	
	/**根据名称查看
	 * 
	 * @param name
	 * @return
	 */
	public boolean userByName(String name) {
		QueryWrapper<User> qw=Wrappers.query();
		qw.eq("userName",name);
		if(dao.selectList(qw).size()!=0) {
		return true;
	}
	return false;
	}
}
