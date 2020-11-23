import java.util.ArrayList;
import java.util.List;

public class Pants extends TextileProduct {
    ProductDetail leftLeg;
    ProductDetail rightLeg;
    ProductDetail belt;

    public Pants(String name, double creationPrice, double salePrice, ProductDetail leftLeg, ProductDetail rightLeg, ProductDetail belt) {
        super(name, creationPrice, salePrice);

        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
        this.belt = belt;
    }

    @Override
    public ArrayList<ProductDetail> getDetails() {
        return new ArrayList<ProductDetail>(
            List.of(this.leftLeg, this.rightLeg, this.belt)
        );
    }
}
