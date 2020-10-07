package task;

public class Pen extends Stationery {
    private IncColor incColor;

    public static int maxWeight;

    static {
        Pen.maxWeight = 0;
    }

    public Pen(int inventoryNumber, String manufacturer, double price, IncColor incColor) {
        super(inventoryNumber, manufacturer, price);

        this.incColor = incColor;
    }

    public static void increaseMaxWeight(int increaseNumber) {
        Pen.maxWeight += increaseNumber;
    }

    public void decreaseRedColorPenPrice(int decreasePricePercent) throws IllegalArgumentException {
        if (this.incColor != IncColor.RED) {
            return;
        }

        if (decreasePricePercent <= 0 || decreasePricePercent > 100) {
            throw new IllegalArgumentException("Invalid percent value Pen@decreaseRedColorPenPrice method. Percent should be betwen 1% and 100%");
        }

        double decreasePrice = (this.price / 100) * decreasePricePercent;

        super.price -= decreasePrice;
    }
}
