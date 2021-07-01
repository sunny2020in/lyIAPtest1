package test.sample;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


public class DependentMethodsTest {

    @Test
    public void testAdd1(){
        assertEquals(3+1, 5);
    }

    @Test(dependsOnMethods = {"testAdd1"})
    public void testAdd2(){
        assertEquals(3+2, 5);
    }

}
