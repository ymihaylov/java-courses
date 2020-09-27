package Supermarket;

public class CashDesk {
    private Cashier currentCashier;

    public CashDesk(Cashier cashier) {
        this.currentCashier = cashier;
    }

    public Cashier getCurrentCashier() {
        return this.currentCashier;
    }

    public void changeCashier(Cashier cashier) {
        this.currentCashier = cashier;
    }

    public synchronized Receipt payForProducts(ProductWithCount[] products) {
        // 2. Issue Receipt
        Receipt receipt = new Receipt(this.currentCashier, products);

        // 3. Update availability
        for (ProductWithCount productWithCount : products) {
            Store.decreaseAvailabilityOfProduct(productWithCount);
        }

        // 4. Add store turnover
        Store.turnover = Store.turnover.add(receipt.getTotalPrice());

        return receipt;
    }
}
