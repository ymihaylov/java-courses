import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DealTest {
    @Nested
    class DealTotalValue {
        private Deal deal = new Deal();

        // Task 1 a)
        @Test
        @DisplayName("Test dealTotalValue with one or more estates")
        public void dealTotalValueOneOrMoreEstates() {
            Estate estate1 = new Estate(new BigDecimal(102.4), Category.Third);
            BigDecimal price1 = new BigDecimal(90000);

            Estate estate2 = new Estate(new BigDecimal(76.2), Category.Second);
            BigDecimal price2 = new BigDecimal(76000);

            deal.putDealPrice(estate1, price1);
            deal.putDealPrice(estate2, price2);

            assertEquals(price1.add(price2), deal.dealTotalValue());
        }

        // Task 1 b)
        @Test
        @DisplayName("Test dealTotalValue with no estates")
        public void dealTotalValueNoEstates() {
            assertEquals(BigDecimal.ZERO, deal.dealTotalValue());
        }
    }

    @Nested
    class HighestPrice {
        private Deal deal = new Deal();

        // Task 1 c)
        @Test
        @DisplayName("Test highestPrice with one or more estates")
        public void highestPriceOneOrMoreEstates() {
            Estate estate1 = new Estate(new BigDecimal(102.4), Category.Third);
            BigDecimal price1 = new BigDecimal(90000);

            Estate estate2 = new Estate(new BigDecimal(76.2), Category.Second);
            BigDecimal price2 = new BigDecimal(76000);

            deal.putDealPrice(estate1, price1);
            deal.putDealPrice(estate2, price2);

            assertEquals(price1, deal.highestPrice());
        }

        // Task 1 d)
        @Test
        @DisplayName("Test highestPrice with no estates")
        public void highestPriceNoEstates() {
            assertEquals(BigDecimal.ZERO, deal.highestPrice());
        }
    }

    @Nested
    class GetEstatePrice {
        private Deal deal = new Deal();

        // Task 1 e)
        @Test
        @DisplayName("Test getEstatePrice with existing estate")
        public void getEstatePriceExistingEstate() {
            Estate estate1 = new Estate(new BigDecimal(102.4), Category.Third);
            BigDecimal price1 = new BigDecimal(90000);

            deal.putDealPrice(estate1, price1);

            assertEquals(price1, deal.getEstatePrice(estate1));
        }

        // Task 1 f)
        @Test
        @DisplayName("Test getEstatePrice with no existing estate")
        public void getEstatePriceNoExistingEstate() {
            Estate estate1 = new Estate(new BigDecimal(102.4), Category.Third);

            assertThrows(NoSuchEstateException.class, () -> deal.getEstatePrice(estate1));
        }
    }

    // Task 1 g)
    @Nested
    class IsBigDeal {
        private Deal deal = new Deal();

        @BeforeEach
        public void init() {
            Estate estate = new Estate(new BigDecimal(102.4), Category.Third);
            BigDecimal price = new BigDecimal(90000);

            deal.putDealPrice(estate, price);
        }

        @Test
        @DisplayName("Test is BigDeal True")
        public void isBigDealTrue() {
            assertTrue(deal.isBigDeal(new BigDecimal(50000)));
        }

        @Test
        @DisplayName("Test isBigDeal False")
        public void isBigDealFalse() {
            assertFalse(deal.isBigDeal(new BigDecimal(100000)));
        }
    }

    // Task 1 i)
    @Test
    @DisplayName("Test increasedPriceList")
    public void increasedPriceList() {
        BigDecimal increasePercent = new BigDecimal(10);
        Estate estate1 = new Estate(new BigDecimal(102.4), Category.Second);
        BigDecimal price1 = new BigDecimal(100);

        Estate estate2 = new Estate(new BigDecimal(102.4), Category.Third);
        BigDecimal price2 = new BigDecimal(200);

        Map<Estate, BigDecimal> priceList = new HashMap<>();
        priceList.put(estate1, price1);
        priceList.put(estate2, price2);

        Deal deal = new Deal(priceList);

        Map<Estate, BigDecimal> increasedPriceList = deal.increasedPriceList(increasePercent);

        increasedPriceList.forEach((Estate estate, BigDecimal price) -> {
            BigDecimal increasedPriceExpected = priceList
                .get(estate)
                .multiply(increasePercent.divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE));;

            assertEquals(increasedPriceExpected, price);
        });
    }
}
