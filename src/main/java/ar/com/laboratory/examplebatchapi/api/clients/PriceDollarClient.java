package ar.com.laboratory.examplebatchapi.api.clients;

import ar.com.laboratory.examplebatchapi.models.dtos.PriceDollarResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PriceDollarClient {
    private final WebClient webClient;

    public PriceDollarClient(@Value("${url.price.dollar}") String priceDollarUrl) {
        this.webClient = WebClient.create(priceDollarUrl);
    }
    public PriceDollarResponse getDollarPrice() {
        PriceDollarResponse dollarResponse = webClient.get()
                .uri("/v1/dolares/oficial")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PriceDollarResponse.class)
                .block();

        return dollarResponse;
    }
}
