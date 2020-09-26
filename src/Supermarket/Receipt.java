package Supermarket;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class Receipt {
    private int number;
    private Cashier cashier;
    private Date dateIssued;
    private ProductWithCount[] products;
    private BigDecimal totalPrice;

    // @TODO Необходимо е да се съхранява общата сума, която се генерира като оборот при издаването.
    // @TODO При издаването на касовата бележка е необходимо нейното съдържание да се показва и да се запазва във файл.
    // @TODO Всяка касова бележка трябва да се пази в отделен файл с име на файла, което да съдържа поредния номер на издадената касова бележка.
    // @TODO Информацията във файла, в който се записва касовата бележка трябва да може да се прочете.

    public Receipt(Cashier cashier, ProductWithCount[] products) {
        if (products.length == 0) {
            // @TODO Create exception
        }

        this.number = ++Store.receiptIssued;
        this.cashier = cashier;
        this.products = products;
        this.dateIssued = new Date();

        this.totalPrice = new BigDecimal(0);
        this.totalPrice = this.totalPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        this.setTotalPrice();

        try {
            this.createReceiptFile();
        } catch (IOException e) {

        }
    }

    private void setTotalPrice() {

        for (ProductWithCount productWithCount : this.products) {
            this.totalPrice = this.totalPrice.add(productWithCount.getTotal());
        }
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    private void createReceiptFile() throws IOException {
        try {
            FileWriter receiptFile = new FileWriter(this.getPathToReceiptFile());
            receiptFile.write("Number: " + this.number + "\n");
            receiptFile.write("Cashier: " + this.cashier.getName() + "\n");
            receiptFile.write("Date issued: " + this.dateIssued.toString() + "\n");
            receiptFile.write("\n");

            receiptFile.write("Products:\n");
            receiptFile.write("Product Name | Product Price | Product Count | Total Product Price\n");

            for (ProductWithCount productWithCount : this.products) {
                receiptFile.write(
                productWithCount.getProduct().getName() + " | " +
                    productWithCount.getProduct().getPrice() + " | " +
                    productWithCount.getCount() + " | " +
                    productWithCount.getTotal() + "\n"
                );
            }

            receiptFile.write("\n");

            receiptFile.write("Total: " + this.totalPrice + " \n");
            receiptFile.close();
        } catch (IOException e) {

        }
    }

    public void printReceiptFile() {
        try {
            FileReader receiptFile = new FileReader(this.getPathToReceiptFile());
            Scanner scanner = new Scanner(receiptFile);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {

        }

    }

    private String getPathToReceiptFile() {
        return "receipts/receipt_"+this.number+".txt";
    }
}
