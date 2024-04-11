package com.example.CurrencyConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@EntityScan("com.example.CurrencyConverter.model")*/
@SpringBootApplication
public class CurrencyConverterApplication {

    public static void main(String[] args) {

        SpringApplication.run(CurrencyConverterApplication.class, args);

        // Volanie endpointu /api/currency/convert s parametrami
/*		WebClient webClient = WebClient.create();
		BigDecimal amount = new BigDecimal("10000");
		String response = webClient.get()
				.uri(uriBuilder -> uriBuilder
						.scheme("http")
						.host("localhost")
						.port(8080)
						.path("/api/currency/convert")
						.queryParam("from", "KRW")
						.queryParam("to", "EUR")
						.queryParam("amount", amount)
						.build())
				.retrieve()
				.bodyToMono(String.class)
				.block();

		System.out.println("Response from endpoint: " + response);*/
    }

}
