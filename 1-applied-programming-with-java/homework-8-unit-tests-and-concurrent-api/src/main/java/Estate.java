import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class Estate implements Comparable<Estate> {
    private static AtomicInteger estatesNumber = new AtomicInteger(0);
    private final long estateId;
    private BigDecimal area;
    private Category category;

    public Estate(BigDecimal area, Category category) {
        estateId = estatesNumber.incrementAndGet();
        this.area = area;
        this.category = category;
    }

    public long getEstateId() {
        return estateId;
    }

    public BigDecimal getArea() {
        return area;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estate estate = (Estate) o;

        return estateId == estate.estateId;
    }

    @Override
    public int hashCode() {
        return (int) (estateId ^ (estateId >>> 32));
    }

    @Override
    public String toString() {
        return "main.Estate{" +
                "area=" + area +
                ", category=" + category +
                '}';
    }

    @Override
    public int compareTo(Estate o) {
        return Long.compare(this.estateId, o.estateId);
    }
}
