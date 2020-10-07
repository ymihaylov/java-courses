import task.*;

import java.awt.print.Book;

public class Main {
    public static void main(String[] args) {
        Stationery stationery = new Stationery(12345, "SoftPress", 13.90);
        stationery.writeDataToFile();

        Pen pen = new Pen(123456, "BIC", 1, IncColor.RED);
        pen.decreaseRedColorPenPrice(60); // pen price is 0.4

        Pen.increaseMaxWeight(10);

        BookStore bookStore = new BookStore();
        try {
            bookStore.addStationery(pen);
            bookStore.addStationery(pen);
            bookStore.addStationery(pen);
            bookStore.addStationery(pen);
            bookStore.addStationery(pen);
        } catch (BookStoreStationeryLimitReachedException e) {
            System.out.println(e.getMessage());
        }

    }
}
