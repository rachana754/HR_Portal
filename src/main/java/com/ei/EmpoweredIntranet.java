package com.ei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ei.dao")
public class EmpoweredIntranet {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmpoweredIntranet.class, args);
    }

}
