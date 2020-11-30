package ru.sbrf.cu.mainpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.sbrf.cu.mainpackage.configs.YamlProps;


@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class Demo {

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }
}
