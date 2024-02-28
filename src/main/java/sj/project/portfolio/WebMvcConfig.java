package sj.project.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("**").allowedOrigins("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptorHandler())
                .addPathPatterns("/**")
//                .excludePathPatterns("/css/**", "/js/**", "/font/**", "/img/**", "/lib/**");
                .excludePathPatterns("/**");
//        .excludePathPatterns("/css/**", "/js/**", "/font/**", "/vendors/**", "/img/**", "/login", "/logout", "/lib/**", "/modbus/**", "/openapi/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public InterceptorHandler interceptorHandler() {
        return new InterceptorHandler();
    }
}
