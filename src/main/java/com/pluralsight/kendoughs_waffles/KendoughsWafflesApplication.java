package com.pluralsight.kendoughs_waffles;

import com.pluralsight.kendoughs_waffles.controllers.AppController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KendoughsWafflesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KendoughsWafflesApplication.class, args);
        AppController appController = new AppController();
        appController.run();
	}

}
