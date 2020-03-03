package com.example.demo.cfg;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan(basePackages = { "com.example.demo.dao" })
public class BeansConfig {
	

}
