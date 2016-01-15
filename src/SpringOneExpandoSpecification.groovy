import org.junit.Test
import static org.junit.Assert.assertEquals;

class SpringOneExpandoTest {
    @Test
    public void testPropertyAccess() {
        def ex = new SpringOneExpando()
        ex.name = 'Tom' //here we are assigning a value to property that doesn't exist
        assertEquals('Tom', ex.name)
    }
    @Test
    public void testMethodAccess(){
        def ex = new SpringOneExpando()
        ex.multiplyNumbers = { x, y ->
            x*y         //here we are assigning value to closure, effectively we are adding a method to this object
        }
        assertEquals(36, ex.multiplyNumbers(4,9))
    }
}
