package dp.proxy;

public class Milk extends CoffeeImpl {

  public static Coffee add(final Coffee coffee) {
    return Decorators.decorate(coffee, new Milk(coffee));
  }

  private final Coffee coffee;

  private Milk(Coffee coffee) {
    super("");
    this.coffee = coffee;
  }

  public int price() {
    return coffee.price() + 2;
  }
}
