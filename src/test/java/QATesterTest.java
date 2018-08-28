import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class QATesterTest {

    @Test
    public void getAllocation() {
        Manager objectToTest = new Manager ();
        BigDecimal expectedAlloc = new BigDecimal ( 500 );
        Assert.assertNotNull ( objectToTest );
        Assert.assertThat ( objectToTest.getAllocation () , Is.is ( expectedAlloc ) );
    }
}