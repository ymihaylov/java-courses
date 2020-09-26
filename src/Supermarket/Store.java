package Supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Store {
    public static List<ProductWithCount> currentAvailableProducts = new ArrayList<ProductWithCount>();
    public static List<Cashier> cashiers = new ArrayList<Cashier>();
    public static int receiptIssued = 0;
    public static BigDecimal turnover = new BigDecimal(0);

    static {
        Store.turnover = Store.turnover.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public static void loadStoreWithProduct(ProductWithCount productWithCountToAdd) {
        for (ProductWithCount currentAvailableProduct: Store.currentAvailableProducts) {
            if (currentAvailableProduct.getProduct().getId() == productWithCountToAdd.getProduct().getId()) {
                currentAvailableProduct.increaseCount(productWithCountToAdd.getCount());
                return;
            }
        }

        Store.currentAvailableProducts.add(productWithCountToAdd);
    }

    private static void decreaseAvailabilityOfProduct(ProductWithCount productWithCount) {
        for (ProductWithCount availableProduct: Store.currentAvailableProducts) {
            if (availableProduct.getProduct().getId() != productWithCount.getProduct().getId()) {
                continue;
            }

            availableProduct.decreaseCount(productWithCount.getCount());
        }
    }

    public static Receipt buyProducts(CashDesk cashDesk, ProductWithCount[] products) throws Exception {
        // 1. Check products availability
        for (ProductWithCount productWithCount: products) {
            if (!Store.isProductAvailable(productWithCount)) {
                throw new Exception("Product not available");
            }
        }

        // 2. Issue Receipt
        Receipt receiptIssued = cashDesk.payForProducts(products);

        // 3. Update availability
        for (ProductWithCount productWithCount : products) {
            Store.decreaseAvailabilityOfProduct(productWithCount);
        }

        // 4. Add store turnover
        Store.turnover = Store.turnover.add(receiptIssued.getTotalPrice());

        return receiptIssued;
    }

    private static boolean isProductAvailable(ProductWithCount productWithCount) {
        for (ProductWithCount availableProduct: Store.currentAvailableProducts) {
            if (availableProduct.getProduct().getId() != productWithCount.getProduct().getId()) {
                continue;
            }

            if (availableProduct.getCount() >= productWithCount.getCount()) {
                return true;
            }

            break;
        }

        return false;
    }
}
