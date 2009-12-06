package dp.proxy;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ProxyTest {
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
        decorated = Milk.add(new CoffeeImpl("coffee"));
    }
}
