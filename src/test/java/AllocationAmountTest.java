import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class AllocationAmountTest {
    private AllocationAmount calculate;
    private Manager generalManager, assistantManager;
    private static Developer developer1;
    private QATester tester1, tester2;
    private Department department;

    /*
       This method shows a scenario of hierarchy with four employees
        Manager->Manager->Developer->QATester should return 2100
        Example: General Manager and Assistant Manager -> Developer and QATEster
        o Manager A
            ▪ Manager B
                • Developer
                • QA Tester
     */
    @Test
    public void getAllocation_For_Manager_AssistantManager_Developer_QATester() {
        generalManager = new Manager ();
        assistantManager = new Manager ();
        developer1 = new Developer ();
        tester1 = new QATester ();
        assistantManager.addEmployee ( developer1 );
        assistantManager.addEmployee ( tester1 );
        generalManager.addEmployee ( assistantManager );
        calculate = new AllocationAmount ( generalManager );
        Assert.assertNotNull ( calculate );
        Assert.assertThat ( calculate.getAllocation () , Is.is ( BigDecimal.valueOf ( 2100 ) ) );
    }

    /**
     * Department has one Manager and two employees under the manager
     * Department->Manager->Developer and Tester should return 1800
     */
    @Test
    public void getAllocation_For_Manager_One_Developer_And_One_Tester() {
        department = new Department ();
        assistantManager = new Manager ();
        developer1 = new Developer ();
        tester1 = new QATester ();
        assistantManager.addEmployee ( developer1 );
        assistantManager.addEmployee ( tester1 );
        department.addEmployee ( assistantManager );

        calculate = new AllocationAmount ( department );
        Assert.assertNotNull ( calculate );
        Assert.assertThat ( calculate.getAllocation () , Is.is ( BigDecimal.valueOf ( 1800 ) ) );
    }

    /**
     * Two levels deep for Manager composite
     * Manager->Developer->Developer should return 2300
     */
    @Test
    public void getAllociation_For_A_Manager_With_Two_Developers() {
        generalManager = new Manager ();
        generalManager.addEmployee ( new Developer () );
        generalManager.addEmployee ( new Developer () );
        BigDecimal allocation = new BigDecimal ( 2300 );
        calculate = new AllocationAmount ( generalManager );
        Assert.assertNotNull ( calculate );
        Assert.assertThat ( calculate.getAllocation () , Is.is ( allocation ) );
    }

    /*
        Two level deep for two employees. QA Tester in this case
        Manager -> QA Tester -> QA Tester (Manager -> QA Tester and QA Tester)
     */
    @Test
    public void getAllocation_For_A_Manager_And_Two_Testers() {
        generalManager = new Manager ();
        assistantManager = new Manager ();
        generalManager.addEmployee ( new QATester () );
        generalManager.addEmployee ( new QATester () );
        BigDecimal allocation = new BigDecimal ( 1300 );
        calculate = new AllocationAmount ( generalManager );
        Assert.assertNotNull ( calculate );
        Assert.assertThat ( calculate.getAllocation () , Is.is ( allocation ) );
    }

    /**
     * Manager with two testers and one developer should have an allocation of 3300
     * Manager -> QA Tester -> QA Tester -> Developer
     */
    @Test
    public void getAllocation_For_A_Manager_Two_QATester_One_Developers() {
        generalManager = new Manager ();
        tester1 = new QATester ();
        tester2 = new QATester ();
        developer1 = new Developer ();
        department = new Department ();
        department.addEmployee ( generalManager );
        generalManager.addEmployee ( tester1 );
        generalManager.addEmployee ( tester2 );
        generalManager.addEmployee ( developer1 );

        BigDecimal allocation = new BigDecimal ( 2300 );
        calculate = new AllocationAmount ( department );
        Assert.assertThat ( calculate.getAllocation () , Is.is ( allocation ) );

    }

    /**
     * Two managers and two developers should have an allocation of 2600
     * Department-> Manager -> Assistant Manager -> Developers -> Developer
     */
    @Test
    public void getAllocation_For_Two_Managers_And_Two_Developers() {
        department = new Department ();
        generalManager = new Manager ();
        department.addEmployee ( generalManager );
        assistantManager = new Manager ();
        department.addEmployee ( assistantManager );
        assistantManager.addEmployee ( new Developer () );
        assistantManager.addEmployee ( new Developer () );
        BigDecimal allocation = new BigDecimal ( 2600 );

        calculate = new AllocationAmount ( department );
        Assert.assertNotNull ( calculate );
        Assert.assertThat ( calculate.getAllocation () , Is.is ( allocation ) );
    }

    /**
     * Two Managers should have an allocation of 600
     * Department -> Manager -> Manager
     */
    @Test
    public void getAllocation_Two_Managers() {
        department = new Department ();
        generalManager = new Manager ();
        assistantManager = new Manager ();
        department.addEmployee ( generalManager );
        department.addEmployee ( assistantManager );
        BigDecimal allocation = new BigDecimal ( 600 );

        calculate = new AllocationAmount ( department );
        Assert.assertNotNull ( calculate );
        Assert.assertThat ( calculate.getAllocation () , Is.is ( allocation ) );
    }
}