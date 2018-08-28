import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class Developer extends Employee {

    @Override
    public ArrayList <Employee> getEmployees() {
        return super.getEmployees ();
    }

    @Override
    protected BigDecimal getAllocation() {
        BigDecimal DevAllocation = new BigDecimal ( 1000 );
        for (Iterator <Employee> iterator = getEmployees ().iterator (); iterator.hasNext (); ) {
            Employee e = iterator.next ();
            DevAllocation = DevAllocation.add ( e.getAllocation () );
        }
        return DevAllocation;
    }
}
