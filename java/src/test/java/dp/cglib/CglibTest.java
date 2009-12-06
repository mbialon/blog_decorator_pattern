package dp.cglib;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CglibTest {
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
        assertEquals(8, Milk.add(decorated).price());
    }

    @Before
    public void setUp() throws Exception {
        decorated = Milk.add(new Coffee("coffee"));
    }
}
