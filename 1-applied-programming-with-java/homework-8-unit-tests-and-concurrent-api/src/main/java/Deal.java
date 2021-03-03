import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Deal {
    private static AtomicInteger deals = new AtomicInteger(0);
    private final int dealId;
    private Map<Estate, BigDecimal> priceList;

    public Deal() {
        dealId = deals.incrementAndGet();
        this.priceList = new HashMap<>();
    }

    public Deal(Map<Estate, BigDecimal> priceListPerSquareMeter) {
        dealId = deals.incrementAndGet();
        this.priceList = priceListPerSquareMeter;
    }

    public int getDealId() {
        return dealId;
    }

    public void putDealPrice(Estate estate, BigDecimal price) {
        this.priceList.put(estate, price);
    }

    public void dealsPrint() {
        this.priceList.entrySet().stream().forEach(System.out::println);
    }

    public BigDecimal dealTotalValue() {
        return this.priceList.values()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal highestPrice() {
        return this.priceList.values()
                .stream()
                .max(BigDecimal::compareTo).orElse(BigDecimal.ZERO);
    }

    public BigDecimal getEstatePrice(Estate estate) throws NoSuchEstateException {
        if (!this.priceList.containsKey(estate)) {
            throw new NoSuchEstateException(estate.toString());
        }
        return this.priceList.get(estate);
    }

    public boolean isBigDeal(BigDecimal bigDealTarget) {
        return this.dealTotalValue().compareTo(bigDealTarget) > 0;
    }

    public Map<Estate, BigDecimal> increasedPriceList(BigDecimal percentage) {
        Map<Estate, BigDecimal> increasedPriceList = new HashMap<>();
        this.priceList.entrySet().stream().forEach(entry -> {
            increasedPriceList.put(entry.getKey(),
                    entry.getValue().multiply(percentage.divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE)));
        });
        return increasedPriceList;
    }

    @Override
    public String toString() {
        return "main.Deal{" +
                "dealId=" + dealId +
                '}';
    }
}
