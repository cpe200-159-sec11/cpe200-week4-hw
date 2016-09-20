import cpe200.PList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PListTest {

    private PList names;
    private PList gpas;
    @Before
    public void setUp() throws Exception {
        names = new PList();
        gpas = new PList();

        names.pushToTail("bravo");
        names.pushToTail("charlie");
        names.pushToTail("delta");
        names.pushToTail("echo");
        names.pushToHead("alpha");

        gpas.pushToTail(2.00);
        gpas.pushToTail(3.00);
        gpas.pushToTail(2.75);
        gpas.pushToTail(2.50);
        gpas.pushToHead(3.25);
    }

    @Test
    public void testPopHead() throws Exception {
        assertEquals("alpha",(String)names.popHead());
        assertEquals(3.25,(Double)gpas.popHead(),0);
    }

    @Test
    public void testPopTail() throws Exception {
        assertEquals("echo",(String)names.popTail());
        assertEquals(2.50,(Double)gpas.popTail(),0);
    }

    @Test
    public void testElementAt() throws Exception {
        assertEquals("delta",(String)names.elementAt(3));
        assertEquals(2.75,(double)gpas.elementAt(3),0);
        assertNull((String)names.elementAt(10));
        assertNull((Double)gpas.elementAt(-2));
    }

    @Test
    public void testRemove() throws Exception {
        assertTrue(names.remove("charlie"));
        assertFalse(names.remove("tango"));
        assertTrue(gpas.remove(3.0));
        assertFalse(gpas.remove(3.99));

        assertEquals("echo",(String)names.elementAt(3));
        assertEquals(2.5,(Double)gpas.elementAt(3),0);
    }

    @Test
    public void testFound() throws Exception {
        assertTrue(names.found("bravo"));
        assertTrue(gpas.found(2.00));

        assertFalse(names.found("romeo"));
        assertFalse(gpas.found(4.00));
    }

}