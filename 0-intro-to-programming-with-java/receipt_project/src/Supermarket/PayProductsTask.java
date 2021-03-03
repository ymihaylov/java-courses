package Supermarket;

import java.util.concurrent.Callable;

// http://tutorials.jenkov.com/java-util-concurrent/java-callable.html

public class PayProductsTask implements Callable<Receipt> {
    private CashDesk cashDesk;
    private ProductWithCount[] productWithCount;

    public PayProductsTask(CashDesk cashDesk, ProductWithCount[] productWithCount) {
        this.cashDesk = cashDesk;
        this.productWithCount = productWithCount;
    }

    @Override
    public Receipt call() throws Exception {
        return cashDesk.payForProducts(productWithCount);
    }
}
