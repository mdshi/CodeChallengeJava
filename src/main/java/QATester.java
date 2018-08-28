import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class QATester extends Employee {


    @Override
    public ArrayList <Employee> getEmployees() {
        return super.getEmployees ();
    }

    @Override
    protected BigDecimal getAllocation() {
        BigDecimal QaAllocation = new BigDecimal ( 500 );
        Iterator <Employee> iterator = getEmployees ().iterator ();
        while (iterator.hasNext ()) {
            Employee e = iterator.next ();
            QaAllocation = QaAllocation.add ( e.getAllocation () );
        }
        return QaAllocation;
    }
}
