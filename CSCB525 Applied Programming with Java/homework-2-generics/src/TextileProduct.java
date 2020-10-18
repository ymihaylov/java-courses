import java.util.ArrayList;

abstract public class TextileProduct {
    private String name;
    private double creationPrice;
    private double salePrice;

    private boolean isDefective = false;

    public TextileProduct(String name, double creationPrice, double salePrice) {
        this.name = name;
        this.creationPrice = creationPrice;
        this.salePrice = salePrice;
    }

    public void markAsDefective(double decreasePercent) {
        if (decreasePercent < 0 || decreasePercent >= 100) {
            throw new IllegalArgumentException("Invalid percent passed. percent value should be between 0 and 100");
        }

        this.isDefective = true;
        this.salePrice = this.salePrice - ((decreasePercent / 100) * this.salePrice);
    }

    @Override
    public String toString() {
        return "TextileProduct {" +
                "Price=" + this.salePrice +
                ", name=" + this.name +
                '}';
    }

    abstract public ArrayList<ProductDetail> getDetails();
}
