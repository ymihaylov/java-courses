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

    public Receipt payForProducts(ProductWithCount[] products) {
        Receipt receipt = new Receipt(this.currentCashier, products);

        return receipt;
    }
}
