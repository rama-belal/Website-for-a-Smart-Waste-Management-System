package org.SmartWaste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.SmartWaste")

public class SpringTest {
    public static void main(String[] args)
    {

        FirebaseInitializer.initialize();
        SpringApplication.run(SpringTest.class, args);

        System.out.println("Application Started!");
    }
}
