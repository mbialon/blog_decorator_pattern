package dp.basic;

public class Milk extends Coffee {
    private final Coffee coffee;

    public Milk(Coffee coffee) {
        super("");
        this.coffee = coffee;
    }

    @Override
    public int price() {
        return coffee.price() + 2;
    }

    @Override
    public String name() {
        return coffee.name();
    }
}
