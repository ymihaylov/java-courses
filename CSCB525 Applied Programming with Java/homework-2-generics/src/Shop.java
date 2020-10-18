public class Shop {
    public <F extends TextileProduct> void sell(F textileProduct) {
        System.out.println("Selling " + textileProduct);
    }
}
