import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class MakingDeal implements Callable<BigDecimal> {

    private Deal deal;

    public MakingDeal(Deal deal) {
        this.deal = deal;
    }

    @Override
    public BigDecimal call() throws Exception {
        System.out.println("Making the deal " + deal + ":");
        deal.dealsPrint();
        return deal.dealTotalValue();
    }
}
