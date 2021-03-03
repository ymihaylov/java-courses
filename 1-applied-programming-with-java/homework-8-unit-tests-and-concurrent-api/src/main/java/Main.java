import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    // Task 2
    public static void main(String[] args) {

        Estate estate1 = new Estate(BigDecimal.valueOf(500), Category.First);
        Estate estate2 = new Estate(BigDecimal.valueOf(700), Category.First);
        Estate estate3 = new Estate(BigDecimal.valueOf(800), Category.Second);
        Estate estate4 = new Estate(BigDecimal.valueOf(600), Category.Fourth);
        Estate estate5 = new Estate(BigDecimal.valueOf(500), Category.Third);
        Estate estate6 = new Estate(BigDecimal.valueOf(850), Category.Second);
        Estate estate7 = new Estate(BigDecimal.valueOf(680), Category.Fourth);
        Estate estate8 = new Estate(BigDecimal.valueOf(520), Category.Third);

        Deal deal1 = new Deal();

        deal1.putDealPrice(estate1, BigDecimal.valueOf(600));
        deal1.putDealPrice(estate2, BigDecimal.valueOf(1000));

        System.out.println(deal1);
        deal1.dealsPrint();

        Deal deal2 = new Deal();
        deal2.putDealPrice(estate3, BigDecimal.valueOf(500));
        deal2.putDealPrice(estate4, BigDecimal.valueOf(900));
        System.out.println(deal2);

        Deal deal3 = new Deal();
        deal3.putDealPrice(estate5, BigDecimal.valueOf(1000));

        Deal deal4 = new Deal();
        deal3.putDealPrice(estate6, BigDecimal.valueOf(1000));

        Deal deal5 = new Deal();
        deal3.putDealPrice(estate7, BigDecimal.valueOf(1000));

        Deal deal6 = new Deal();
        deal3.putDealPrice(estate8, BigDecimal.valueOf(1000));

        List<MakingDeal> makingDealList = Arrays.asList(new MakingDeal(deal1), new MakingDeal(deal2), new MakingDeal(deal3),
                new MakingDeal(deal4), new MakingDeal(deal5), new MakingDeal(deal6));

        Semaphore semaphore = new Semaphore(2);
        ExecutorService executorService = Executors.newCachedThreadPool();

        makingDealList.stream().forEach(makingDeal -> {

            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            executorService.submit(makingDeal);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
