public class Main {
    public static void main(String[] args) {
        // Create Pants object
        ProductDetail leftLeg = new ProductDetail("Denim", "Black");
        ProductDetail rightLeg = new ProductDetail("Denim", "Black");
        ProductDetail belt = new ProductDetail("Leather", "Brown");

        Pants pants = new Pants("Pants Jeans", 10.00, 30.00, leftLeg, rightLeg, belt);

        // Create Blouse
        ProductDetail front = new ProductDetail("Cotton", "White");
        ProductDetail back = new ProductDetail("Cotton", "Light Blue");
        ProductDetail leftSleeve = new ProductDetail("Cotton", "Light Blue");
        ProductDetail rightSleeve = new ProductDetail("Cotton", "Light Blue");

        Blouse blouse = new Blouse("Fashion Blouse", 5.00, 15.00, front, back, leftSleeve, rightSleeve);

        // Sew
        Sewing sewingPants = new Sewing(pants);
        sewingPants.sew();

        Sewing sewingBlouse = new Sewing(pants);
        sewingBlouse.sew();

        // Sell
        Shop shop = new Shop();
        shop.sell(pants);
        shop.sell(blouse);
    }
}
