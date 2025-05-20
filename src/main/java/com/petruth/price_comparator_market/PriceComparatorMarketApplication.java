package com.petruth.price_comparator_market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PriceComparatorMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceComparatorMarketApplication.class, args);
	}

}
