package com.atguigu.guli.service.base.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zjiajia
 * @date 2020/9/1 19:13
 */


@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 后台管理系统的配置
     * @return 配置
     */

    @Bean
    public Docket adminApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();

    }

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("后台管理系统-谷粒学院api文档")
                .description("谷粒学院的接口")
                .version("1.0")
                .contact(new Contact("jiajia","http://www.baidu.com","1551189282@qq.com"))
                .build();
    }


    /**
     * 网站的前台 配置
     * @return  配置
     */
    @Bean
    public Docket webApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();

    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("网站-谷粒学院api文档")
                .description("谷粒学院的接口")
                .version("1.0")
                .contact(new Contact("jiajia","http://www.baidu.com","1551189282@qq.com"))
                .build();
    }



}
