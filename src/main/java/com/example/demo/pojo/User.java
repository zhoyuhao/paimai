package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@TableName("user")
public class User {
	@TableId(type =IdType.AUTO,value = "userId")
    private Integer userid;

    private String username;

    private String userpwd;

    private Integer power;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}