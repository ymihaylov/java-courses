import java.util.Random;

public class Sewing<T extends TextileProduct> {
    T textileProduct;

    public Sewing(T product) {
        this.textileProduct = product;
    }

    public void sew() {

        System.out.println("Sewing product details ...");
        for (ProductDetail detail : textileProduct.getDetails()) {
            System.out.println("Sewing detail " + detail);
        }

        System.out.println("Checking for defects ...");
        Random rand = new Random();
        if (rand.nextInt(1000) % 3 == 0) {
            System.out.println("Defect found");
            textileProduct.markAsDefective(20);
        }

        System.out.println("Packaging ...");
        System.out.println("Product sewed!");
    }
}
