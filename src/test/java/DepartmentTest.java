import org.hamcrest.core.Is;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertThat;

public class DepartmentTest {

    @Test
    public void getAllocation() {
        Department moduleToTest = new Department ();
        Manager managerA = new Manager ();
        Developer developer1 = new Developer ();
        QATester tester1 = new QATester ();
        QATester tester2 = new QATester ();
        moduleToTest.addEmployee ( managerA );
        assertThat ( moduleToTest.getAllocation () , Is.is ( BigDecimal.valueOf ( 300 ) ) );
        moduleToTest.addEmployee ( tester1 );
        assertThat ( moduleToTest.getAllocation () , Is.is ( BigDecimal.valueOf ( 800 ) ) );
        moduleToTest.addEmployee ( developer1 );
        assertThat ( moduleToTest.getAllocation () , Is.is ( BigDecimal.valueOf ( 1800 ) ) );
        moduleToTest.addEmployee ( tester2 );
        assertThat ( moduleToTest.getAllocation () , Is.is ( BigDecimal.valueOf ( 2300 ) ) );
        moduleToTest.removeEmployee ( developer1 );
        assertThat ( moduleToTest.getAllocation () , Is.is ( BigDecimal.valueOf ( 1300 ) ) );
        moduleToTest.removeEmployee ( tester1 );
        assertThat ( moduleToTest.getAllocation () , Is.is ( BigDecimal.valueOf ( 800 ) ) );
    }
}