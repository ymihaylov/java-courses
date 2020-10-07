package Supermarket;

import java.util.UUID;

public class Cashier {
    private String id;
    private String name;

    public Cashier(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
