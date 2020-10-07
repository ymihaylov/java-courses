package task;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private String name;
    private List<Stationery> stationeries = new ArrayList<Stationery>();

    public static final int MAX_COUNT_STATIONERIES = 3;

    public void addStationery(Stationery stationery) throws BookStoreStationeryLimitReachedException {
        if (this.stationeries.size() == BookStore.MAX_COUNT_STATIONERIES) {
            throw new BookStoreStationeryLimitReachedException("Limit reached");
        }
        stationeries.add(stationery);
    }
}
