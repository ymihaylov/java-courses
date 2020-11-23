package exercise1;

import java.util.SortedSet;
import java.util.TreeSet;

public class PlasticGoodsManufacturer {
    private String name;
    private TreeSet<PlasticGoods> supportedPlasticGoods;

    public PlasticGoodsManufacturer(String name) {
        this.name = name;
        this.supportedPlasticGoods = new TreeSet<>();
    }

    public PlasticGoodsManufacturer addSupportedPlasticGoods(PlasticGoods plasticGoods) {
        this.supportedPlasticGoods.add(plasticGoods);
        return this;
    }

    private double getAveragePrice() {
        if (supportedPlasticGoods.size() == 0) {
            return 0.0;
        }

        double sum = 0;
        for (PlasticGoods plasticGoods : this.supportedPlasticGoods) {
            sum += plasticGoods.getPrice();
        }

        return sum / this.supportedPlasticGoods.size();
    }

    public PlasticGoods closestToAverage() {
        double average = this.getAveragePrice();

        PlasticGoods tempPlasticGoods = new PlasticGoods("temp", average);

        PlasticGoods floor = this.supportedPlasticGoods.floor(tempPlasticGoods);
        PlasticGoods ceiling = this.supportedPlasticGoods.ceiling(tempPlasticGoods);

        if (average - floor.getPrice() > ceiling.getPrice() - average) {
            return ceiling;
        }

        return floor;
    }

    public SortedSet<PlasticGoods> belowAveragePrice()
    {
        double average = this.getAveragePrice();
        PlasticGoods tempPlasticGoods = new PlasticGoods("temp", average);

        return this.supportedPlasticGoods.headSet(tempPlasticGoods);
    }

    public SortedSet<PlasticGoods> aboveAveragePrice()
    {
        double average = this.getAveragePrice();
        PlasticGoods tempPlasticGoods = new PlasticGoods("temp", average);

        return this.supportedPlasticGoods.tailSet(tempPlasticGoods);
    }
}
