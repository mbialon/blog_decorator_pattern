package dp.cglib;

public class Sugar extends Coffee {

    public static Coffee add(Coffee coffee) {
        return Enhancers.enhance(coffee, new Sugar(coffee));
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
