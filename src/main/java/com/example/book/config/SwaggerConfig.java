package com.example.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
//        ParameterBuilder build = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        build.name("Authorization").modelRef(new ModelRef("string")).parameterType("header").description("token").required(true).build();
//        pars.add(build.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.book"))
                .paths(PathSelectors.any())
//                .paths(PathSelectors.ant("/api/**"))
                .build()
//                .globalOperationParameters(pars)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("topksp@gmail.com","Sky","https://greentracks.app");
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2建構RESTful API")
                .description("rest api")
                .termsOfServiceUrl("http://blog.csdn.net/itguangit")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
