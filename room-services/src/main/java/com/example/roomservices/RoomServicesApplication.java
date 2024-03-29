package com.example.roomservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.emptyList;
import static springfox.documentation.builders.PathSelectors.any;

@EnableSwagger2
@SpringBootApplication
public class RoomServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomServicesApplication.class, args);
    }


    @Bean
    public Docket api() {
        Contact contact = new Contact("Bohdan Korinnyi", null, "bohdan.korinnyi@gmail.com");
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Room")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.roomservices"))
                .paths(any())
                .build()
                .apiInfo(new ApiInfo("Room Services",
                        "A set of services to provide data access to rooms", "1.0.0", null,
                        contact, null, null, emptyList()));
    }

}
