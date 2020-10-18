import java.util.ArrayList;
import java.util.List;

public class Blouse extends TextileProduct {
    private ProductDetail front;
    private ProductDetail back;
    private ProductDetail leftSleeve;
    private ProductDetail rightSleeve;

    public Blouse(
        String name,
        double creationPrice,
        double salePrice,
        ProductDetail front,
        ProductDetail back,
        ProductDetail leftSleeve,
        ProductDetail rightSleeve
    ) {
        super(name, creationPrice, salePrice);

        this.front = front;
        this.back = back;
        this.leftSleeve = leftSleeve;
        this.rightSleeve = rightSleeve;
    }

    @Override
    public ArrayList<ProductDetail> getDetails() {
        return new ArrayList<ProductDetail>(
            List.of(this.front, this.back, this.leftSleeve, this.rightSleeve)
        );
    }
}
