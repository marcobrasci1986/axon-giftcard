package io.axoniq.demo.giftcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class GcApp {


    public static void main(String[] args) {
        SpringApplication.run(GcApp.class, args);
    }


}
