package Supermarket;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private BigDecimal price;
    private Date expiryDate;

    public Product(String name, double price, Date expiryDate) {
        this.id = UUID.randomUUID().toString();

        this.name = name;

        this.price = new BigDecimal(Double.toString(price));
        this.price = this.price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
