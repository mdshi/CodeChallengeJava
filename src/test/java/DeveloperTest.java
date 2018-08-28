import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DeveloperTest {

    @Test
    public void getAllocation() {
        Developer objectToTest = new Developer ();
        BigDecimal expectedAlloc = new BigDecimal ( 1000 );
        Assert.assertNotNull ( objectToTest );
        Assert.assertThat ( objectToTest.getAllocation () , Is.is ( expectedAlloc ) );
    }
}