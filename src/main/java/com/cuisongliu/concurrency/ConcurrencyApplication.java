package com.cuisongliu.concurrency;

import com.cuisongliu.concurrency.example.threadlocal.request.HttpFilter;
import com.cuisongliu.concurrency.example.threadlocal.request.HttpInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class ConcurrencyApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyApplication.class, args);
    }


    @Bean
    public FilterRegistrationBean<HttpFilter> httpFilter(){
        //对请求进行预处理
        FilterRegistrationBean<HttpFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new HttpFilter());
        bean.addUrlPatterns("/threadlocal/*");
        return bean;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //拦截器 可对请求处理之后进行再次处理
        super.addInterceptors(registry);
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }
}
