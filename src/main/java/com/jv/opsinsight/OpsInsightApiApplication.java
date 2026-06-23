package com.jv.opsinsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class OpsInsightApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(OpsInsightApiApplication.class, args);
  }
}
