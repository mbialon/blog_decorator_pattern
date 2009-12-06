package dp.cglib;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CglibTest {
    private Coffee decorated;

    @Test
    public void testPriceDecoration() {
        assertEquals(6, decorated.price());
        assertEquals(7, Sugar.add(decorated).price());
    }

    @Test
    public void testNameDecoration() {
        assertEquals("coffee", decorated.name());
    }

    @Before
    public void setUp() throws Exception {
        Coffee coffee = new Coffee("coffee");
        decorated = Milk.add(coffee);
    }
}
