package ch.bfh.bti7515.waschfritz.rest.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"ch.bfh.bti7515.waschfritz.rest.controller"})
@ImportResource("classpath*:serviceContext.xml")
public class WaschFritzApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(WaschFritzApplication.class, args);
        // http://localhost:8080/machines

    }

}