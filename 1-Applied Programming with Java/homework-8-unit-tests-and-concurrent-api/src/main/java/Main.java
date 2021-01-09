import java.math.BigDecimal;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorServiceFixedPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i <= 6; i++) {
            Estate estate1 = new Estate(new BigDecimal(102.4), Category.Third);
            BigDecimal price1 = new BigDecimal(90000);

            Estate estate2 = new Estate(new BigDecimal(76.2), Category.Second);
            BigDecimal price2 = new BigDecimal(76000);

            Deal deal = new Deal();
            deal.putDealPrice(estate1, price1);
            deal.putDealPrice(estate2, price2);

            Future <BigDecimal> future = executorServiceFixedPool.submit(new MakingDeal(deal));
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
