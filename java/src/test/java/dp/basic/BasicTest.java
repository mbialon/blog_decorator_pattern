package dp.basic;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BasicTest {
  private Coffee decorated;

  @Test
  public void testPriceDecoration() {
    assertEquals(6, decorated.price());
  }

  @Test
  public void testNameDecoration() {
    assertEquals("coffee", decorated.name());
  }

  @Test
  public void testMultiLevelDecoration() {
    assertEquals(8, new Milk(decorated).price());
  }

  @Before
  public void setUp() throws Exception {
    decorated = new Milk(new Coffee("coffee"));
  }
}
