import java.math.BigDecimal;
import java.util.ArrayList;

public class AllocationAmount extends Employee {


    private Employee employee;

    /**
     * @param employee
     */
    public AllocationAmount(Employee employee) {
        super ();
        this.employee = employee;
    }

    /**
     * @return ALLOCATION
     */
    public BigDecimal getAllocation() {
        return employee.getAllocation ();
    }
}
