import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ManagerTest {
    /**
     * Test for manager's allocation
     */
    @Test
    public void getAllocation() {
        Manager objectToTest = new Manager ();
        BigDecimal expectedAlloc = new BigDecimal ( 300 );
        Assert.assertNotNull ( objectToTest );
        Assert.assertThat ( objectToTest.getAllocation () , Is.is ( expectedAlloc ) );
    }
}