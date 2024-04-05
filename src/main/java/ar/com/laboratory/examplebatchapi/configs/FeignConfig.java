package ar.com.laboratory.examplebatchapi.configs;

import ar.com.laboratory.examplebatchapi.api.clients.PriceDollarClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {


    @Value("url.price.dollar")
    private  String urlCotizacionDolar;
    @Bean
    public PriceDollarClient priceDollarClient() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(PriceDollarClient.class, urlCotizacionDolar);
    }
}