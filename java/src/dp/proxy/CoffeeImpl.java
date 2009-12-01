package dp.proxy;

public class CoffeeImpl implements Coffee {
    private final String name;

    public CoffeeImpl(String name) {
        this.name = name;
    }

    public int price() {
        return 4;
    }

    public String name() {
        return name;
    }
}
