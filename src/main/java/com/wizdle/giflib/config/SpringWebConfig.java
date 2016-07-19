package com.wizdle.giflib.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * Spring configuration class
 * @author cmoten
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.wizdle.giflib.web")
@PropertySource("classpath:app.properties")
@Import({ThymeLeafConfig.class, DataSourceConfig.class})
public class SpringWebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{
    
    private ApplicationContext appContext;
    
    @Override
    public void setApplicationContext(ApplicationContext appContext){
        this.appContext = appContext;
    }
    
    /**
     * Add a handler to serve static resources (css, js, images)
     * @param registry 
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
