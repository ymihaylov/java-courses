package exercise2;

public enum SportType {
    FOOTBALL(1,11, 5),
    BASKETBALL(1,5, 3),
    VOLLEYBALL(1, 6, 3);

    private int mainAthletesCount;
    private int reserveAthletesCount;

    SportType(int couchesCount, int mainAthletesCount, int reserveAthletesCount) {
        this.mainAthletesCount = mainAthletesCount;
        this.reserveAthletesCount = reserveAthletesCount;
    }

    public int getMainAthletesCount() {
        return this.mainAthletesCount;
    }

    public int getReserveAthletesCount() {
        return this.reserveAthletesCount;
    }

    public int getTotalAthletesCount() {
        return this.mainAthletesCount + this.reserveAthletesCount;
    }
}
