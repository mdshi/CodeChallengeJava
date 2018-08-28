import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class Department extends Employee {

    @Override
    public ArrayList <Employee> getEmployees() {
        return super.getEmployees ();
    }

    @Override
    protected BigDecimal getAllocation() {
        BigDecimal allocations = BigDecimal.ZERO;
        for (Employee e : getEmployees ()) {
            allocations = allocations.add ( e.getAllocation () );
        }
        return allocations;
    }
}
