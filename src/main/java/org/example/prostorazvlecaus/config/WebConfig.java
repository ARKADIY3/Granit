package org.example.prostorazvlecaus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/stone").setViewName("stone/list");
        registry.addViewController("/order").setViewName("order/listOrder");
        registry.addViewController("/service").setViewName("service/listService");
        registry.addViewController("/user").setViewName("user/listUser");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Регистрация обработчиков статических ресурсов
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");
    }
}
