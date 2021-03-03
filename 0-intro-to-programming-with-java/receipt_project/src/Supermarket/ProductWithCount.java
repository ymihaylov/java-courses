package Supermarket;

import java.math.BigDecimal;

public class ProductWithCount {
    private Product product;
    private int count;

    public ProductWithCount(Product product, int count) {
        if (this.count < 0) {
            throw new IllegalArgumentException("Invalid argument count passed to ProductWithCount constructor.");
        }

        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getCount() {
        return this.count;
    }

    public void increaseCount(int increaseNumber) {
        this.count += increaseNumber;
    }

    public void decreaseCount(int decreaseNumber) {
        this.count -= decreaseNumber;
    }

    public BigDecimal getTotal() {
        return this.getProduct().getPrice().multiply(new BigDecimal(this.getCount()));
    }
}
