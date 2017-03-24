package com.popolong.studio.microservice.smartSerivces.configure;

import com.popolong.studio.microservice.common.CommonParams;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.logging.Logger;

import org.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
@AutoConfigureAfter(DBRepoMyBatisConfiguration.class)
public class MyBatisMapperScannerConfig {
	private Logger logger = Logger.getLogger(MyBatisMapperScannerConfig.class.getName());
	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(CommonParams.BASEACCOUNTPATH_+ File.separator+"db"+File.separator+"dao");
        logger.info("mapperScannerConfigurer created");
        return mapperScannerConfigurer;
    }
}
