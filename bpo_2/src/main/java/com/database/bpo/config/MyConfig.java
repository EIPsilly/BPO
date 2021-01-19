package com.database.bpo.config;

import com.database.bpo.component.LoginInterceptor;
import com.database.bpo.component.RoleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("index").setViewName("pages/front/login");
        registry.addViewController("/").setViewName("pages/front/login");
        registry.addViewController("/index.html").setViewName("pages/front/login");
        registry.addViewController("/register.html").setViewName("pages/front/register");
        registry.addViewController("/register").setViewName("pages/front/register");
        registry.addViewController("/listPage").setViewName("pages/front/bpo_main/bpo_list2");
        registry.addViewController("/addNewProject").setViewName("pages/front/bpo_main/PublishProject");
        registry.addViewController("/employer_basis_info").setViewName("pages/front/personal_info/employer_basis_info");
        registry.addViewController("/examineProject").setViewName("pages/back/examineProject");
        registry.addViewController("/viewProject").setViewName("pages/front/bpo_main/ViewProject");
        registry.addViewController("/CompetitiveBidding").setViewName("pages/front/bpo_employee/CompetitiveBidding");
        registry.addViewController("/EmployerProject").setViewName("pages/front/bpo_employer/EmployerProject");
        registry.addViewController("/BiddingScheme").setViewName("pages/front/bpo_employer/BiddingScheme");
        registry.addViewController("/ShowScheme").setViewName("pages/front/bpo_employer/ShowScheme");
        registry.addViewController("/EmployerOrder").setViewName("pages/front/bpo_employer/EmployerOrder");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index","/","/index.html",
                        "/register.html","/register",
                        "/pages/front/login","/pages/front/register",
                        "/static/**");
        registry.addInterceptor(new RoleInterceptor())
                .addPathPatterns("/Desk");
    }
}
