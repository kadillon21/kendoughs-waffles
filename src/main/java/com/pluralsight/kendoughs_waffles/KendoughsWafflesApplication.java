package com.pluralsight.kendoughs_waffles;

import com.pluralsight.kendoughs_waffles.controllers.AppController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class KendoughsWafflesApplication {
    public static void main(String[] args) throws IOException {
        var context = SpringApplication.run(KendoughsWafflesApplication.class, args);
        AppController appController = context.getBean(AppController.class);
        appController.run();
    }
}
