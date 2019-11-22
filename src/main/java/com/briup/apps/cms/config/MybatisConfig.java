package com.briup.apps.cms.config;

import com.briup.apps.cms.dao.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.apps.cms.dao")
public class MybatisConfig {

}
