package com.database.bpo.config;

import com.database.bpo.component.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("pages/front/login");
        registry.addViewController("/").setViewName("pages/front/login");
        registry.addViewController("/index.html").setViewName("pages/front/login");
        registry.addViewController("/register.html").setViewName("pages/front/register");
        registry.addViewController("/register").setViewName("pages/front/register");
        registry.addViewController("/listPage").setViewName("pages/front/bpo_main/bpo_list2");
        registry.addViewController("/addNewProject").setViewName("pages/front/bpo_main/PublishProject");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index","/","/index.html",
                        "/register.html","/register",
                        "/pages/front/login","/pages/front/register",
                        "/static/**");
    }
}
