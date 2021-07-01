package test.sample;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


public class DependentGroupsTest {

    @Test(description = "case1",groups={"funtest"})
    public void testAdd1(){
        assertEquals(3+1, 5);
    }

    @Test(groups={"funtest"})
    public void testAdd2(){
        assertEquals(3+2, 5);
    }

    @Test(dependsOnGroups = {"funtest"})
    public void testAdd3(){
        assertEquals(3+2, 5);
    }

}