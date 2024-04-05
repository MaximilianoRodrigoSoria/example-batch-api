package ar.com.laboratory.examplebatchapi.api.clients;

import ar.com.laboratory.examplebatchapi.models.dtos.PriceDollarResponse;
import feign.Headers;
import feign.RequestLine;

public interface PriceDollarClient {

    @RequestLine("GET /v1/dolares/oficial")
    @Headers("Content-Type: application/json")
    PriceDollarResponse getPriceDollar();
}