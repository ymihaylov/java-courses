import java.math.BigDecimal;

public class Car implements Runnable {
    private String brand;
    private Color color;
    private BigDecimal price;
    private static BigDecimal minPrice = BigDecimal.valueOf(10_000);

    public Car(String brand, Color color, BigDecimal price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws TooLowPriceException {
        if (price.compareTo(minPrice) > 0) {
            this.price = price;
        } else {
            throw new TooLowPriceException();
        }
    }

    public void checkCar(int numberOfChecks) {
        for (int i = 1; i < numberOfChecks; i++) {
            System.out.println(this.brand + " check " + i);
        }
    }

    @Override
    public void run() {
        System.out.println("Thread name:" + Thread.currentThread().getName());

        checkCar(1);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color=" + color +
                ", price=" + price +
                '}';
    }
}
