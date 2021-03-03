import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("Price set successfully")
    public void setPrice() {
        Car car = new Car("Audi", Color.BLUE, BigDecimal.valueOf(70_000));

        try {
            car.setPrice(BigDecimal.valueOf(65_000));
        } catch (TooLowPriceException e) {
            // Should not reach it
        }

        assertEquals(BigDecimal.valueOf(65_000), car.getPrice());
    }

    @Test()
    @DisplayName("Price is incorrect. Exception thrown")
    public void setPriceThrowsAnException() {
        Car car = new Car("Audi", Color.BLUE, BigDecimal.valueOf(70_000));

        assertThrows(TooLowPriceException.class, () -> car.setPrice(BigDecimal.valueOf(-1)));
    }
}
