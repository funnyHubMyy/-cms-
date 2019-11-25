package com.myy.apps.cms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.myy.apps.cms.dao")
public class MybatisConfig {

}
