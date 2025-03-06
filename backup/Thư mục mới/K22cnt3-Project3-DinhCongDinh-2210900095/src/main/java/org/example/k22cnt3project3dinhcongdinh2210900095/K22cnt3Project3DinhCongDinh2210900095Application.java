package org.example.k22cnt3project3dinhcongdinh2210900095;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.k22cnt3project3dinhcongdinh2210900095", "com.k22cnt3project3dinhcongdinh"})
@EnableJpaRepositories(basePackages = "com.k22cnt3project3dinhcongdinh.repository")
@EntityScan(basePackages = "com.k22cnt3project3dinhcongdinh.model")
public class K22cnt3Project3DinhCongDinh2210900095Application {

    public static void main(String[] args) {
        SpringApplication.run(K22cnt3Project3DinhCongDinh2210900095Application.class, args);
    }
}