import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import static java.math.BigDecimal.ZERO;

public class Manager extends Employee {
    //public Manager() {
    //super ();
    //}

    @Override
    public ArrayList <Employee> getEmployees() {
        return super.getEmployees ();
    }

    @Override
    protected BigDecimal getAllocation() {
        BigDecimal mgrAllocation = new BigDecimal ( 300 );
        for (Employee e : getEmployees ()) {
            mgrAllocation = mgrAllocation.add ( e.getAllocation () );
        }
        return mgrAllocation;
    }
}
