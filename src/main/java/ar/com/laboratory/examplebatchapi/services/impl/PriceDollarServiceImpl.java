package ar.com.laboratory.examplebatchapi.services.impl;

import ar.com.laboratory.examplebatchapi.api.clients.PriceDollarClient;
import ar.com.laboratory.examplebatchapi.services.PriceDollarService;
import ar.com.laboratory.examplebatchapi.utils.enums.DollarType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceDollarServiceImpl implements PriceDollarService{

    private final PriceDollarClient priceDollarClient;

    @Override
    public Double getPriceDollar(DollarType dollarType) {
        return priceDollarClient.getPriceDollar().getVenta();
    }
}
