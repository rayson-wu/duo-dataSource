package com.rayson.duodatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DuoDataSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DuoDataSourceApplication.class, args);
    }

}
