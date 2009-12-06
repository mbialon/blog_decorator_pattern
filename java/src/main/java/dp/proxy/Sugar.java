package dp.proxy;

public class Sugar extends CoffeeImpl {

    public static Coffee add(Coffee coffee) {
        return Decorators.decorate(coffee, new Sugar(coffee));
    }

    private final Coffee coffee;

    public Sugar(Coffee coffee) {
        super("");
        this.coffee = coffee;
    }

    public int price() {
        return coffee.price() + 1;
    }
}
