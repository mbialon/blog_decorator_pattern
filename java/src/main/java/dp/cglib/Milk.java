package dp.cglib;

public class Milk extends Coffee {

  public static Coffee add(final Coffee coffee) {
    return Enhancers.enhance(coffee, new Milk(coffee));
  }

  private final Coffee coffee;

  public Milk(Coffee coffee) {
    super("");
    this.coffee = coffee;
  }

  @Override
  public int price() {
    return coffee.price() + 2;
  }
}
