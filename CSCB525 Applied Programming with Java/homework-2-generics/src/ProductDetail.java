public class ProductDetail {
    private String material;
    private String color;

    public ProductDetail(String material, String color) {
        this.material = material;
        this.color = color;
    }

    @Override
    public String toString() {
        return "ProductDetail {" +
                "material=" + this.material +
                ", weight=" + this.color +
                '}';
    }
}
