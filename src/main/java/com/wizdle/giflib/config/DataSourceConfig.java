/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizdle.giflib.config;

import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * Configures Hibernate data source
 * @author cmoten
 */
@Configuration
@PropertySource("classpath:app.properties")
public class DataSourceConfig {
    @Autowired
    private Environment env;
    
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setConfigLocation(config);
        sessionFactory.setPackagesToScan(env.getProperty("giflib.entity.package"));
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }
    
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        
        //Set driver class name
        dataSource.setDriverClassName(env.getProperty("giflib.db.driver"));
        dataSource.setUrl(env.getProperty("giflib.db.url"));
        dataSource.setUsername(env.getProperty("giflib.db.username"));
        dataSource.setPassword(env.getProperty("giflib.db.password"));
        
        return dataSource;
    }
}
