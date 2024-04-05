package ar.com.laboratory.examplebatchapi.services;

import ar.com.laboratory.examplebatchapi.utils.enums.DollarType;

public interface PriceDollarService {

    public Double getPriceDollar(DollarType dollarType);
}
