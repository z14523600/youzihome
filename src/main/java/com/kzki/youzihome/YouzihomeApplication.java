package com.kzki.youzihome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
// 用来指定配置文件的位置
@PropertySource(value={"classpath:dbconfig_mysql.properties"})
public class YouzihomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouzihomeApplication.class, args);
    }

}
