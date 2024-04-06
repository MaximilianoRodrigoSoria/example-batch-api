package ar.com.laboratory.examplebatchapi.batch.processors;


import ar.com.laboratory.examplebatchapi.models.entities.Product;
import ar.com.laboratory.examplebatchapi.services.PriceDollarService;
import ar.com.laboratory.examplebatchapi.utils.enums.DollarType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@AllArgsConstructor
@Slf4j
public class ProductProcessor implements ItemProcessor<Product, Product> {

    private PriceDollarService priceDollarService;

    @Override
    public Product process(Product item) throws Exception {
        log.info("Product price Argentine: {}", item);
        var price = priceDollarService.getPriceDollar(DollarType.OFICIAL);
        item.setPrice(getProductPriceDollar(item, price));
        log.info("Product price Dollar: {}", item);
        return item;
    }

    private static double getProductPriceDollar(Product item, Double price) {
        return item.getPrice() * price;
    }
}

