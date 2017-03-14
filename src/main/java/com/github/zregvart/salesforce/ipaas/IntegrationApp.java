package com.github.zregvart.salesforce.ipaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrationApp {

    public static void main(final String[] args) {
        System.setProperty("spring.cloud.kubernetes.secrets.paths",
                "/var/run/secrets/salesforce,/var/run/secrets/salesforce-connector");

        SpringApplication.run(IntegrationApp.class, args);
    }

}
