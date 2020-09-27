import Supermarket.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
//        Cashier cashier = new Cashier("Ivan Ivanov");

        // --- Init Cashiers
        Cashier cashierIvan = new Cashier("Ivan Ivanov");
        Cashier cashierGeorgi = new Cashier("Georgi Georgiev");
        Cashier cashierKalina = new Cashier("Kalina Kirilova");
        // ---

        // --- Init CashDesks
        CashDesk cashDesk1 = new CashDesk(cashierIvan);
        CashDesk cashDesk2 = new CashDesk(cashierGeorgi);
        CashDesk cashDesk3 = new CashDesk(cashierKalina);
        // ---

        // --- Init products
        Product waffleProduct = new Product("Waffle Borovets", 0.50, new GregorianCalendar(2020, Calendar.DECEMBER, 16).getTime());
        Product breadProduct = new Product("Bread", 1.20, new GregorianCalendar(2020, Calendar.SEPTEMBER, 30).getTime());
        Product instantCoffeeProduct = new Product("Instant Coffee", 0.40, new GregorianCalendar(2021, Calendar.AUGUST, 7).getTime());
        Product milkProduct = new Product("Milk", 2.20, new GregorianCalendar(2020, Calendar.NOVEMBER, 4).getTime());
        Product frozenLasagnaProduct = new Product("Lasagna", 6.40, new GregorianCalendar(2021, Calendar.JULY, 21).getTime());
        // ---

        // --- Load the store
        Store.loadStoreWithProduct(new ProductWithCount(waffleProduct, 50));
        Store.loadStoreWithProduct(new ProductWithCount(breadProduct, 20));
        Store.loadStoreWithProduct(new ProductWithCount(instantCoffeeProduct, 100));
        Store.loadStoreWithProduct(new ProductWithCount(milkProduct, 30));
        Store.loadStoreWithProduct(new ProductWithCount(frozenLasagnaProduct, 15));

        // Add more waffles
        Store.loadStoreWithProduct(new ProductWithCount(waffleProduct, 50));
        // ---

        // --- Buy products
        try {
            Receipt receipt = Store.buyProducts(cashDesk1, new ProductWithCount[]{
                new ProductWithCount(waffleProduct, 2),
                new ProductWithCount(breadProduct, 1),
                new ProductWithCount(instantCoffeeProduct, 5),
                new ProductWithCount(milkProduct, 1),
            });

            receipt.printReceiptFile();

            Receipt receipt2 = Store.buyProducts(cashDesk2, new ProductWithCount[]{
                    new ProductWithCount(waffleProduct, 2),
                    new ProductWithCount(breadProduct, 1),
                    new ProductWithCount(instantCoffeeProduct, 5),
                    new ProductWithCount(milkProduct, 1),
            });

            receipt2.printReceiptFile();
        } catch (ProductNotAvailableException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}