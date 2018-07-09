package com.augus;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Start Class
 * @author Augus
 * @date 2018/07/06
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class InterfaceManagerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.bannerMode(Banner.Mode.OFF);
        return application.sources(InterfaceManagerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication  app = new SpringApplication(InterfaceManagerApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run();
    }
}
