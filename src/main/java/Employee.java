import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Employee {

    /**
     * Data member employee
     */
    private ArrayList <Employee> employeeArrayList = new ArrayList <> ();

    // Default constructor
    Employee() {

    }

    /**
     * @return List of employees
     */
    public ArrayList <Employee> getEmployees() {
        return employeeArrayList;
    }

    /**
     * @param employee
     */
    void addEmployee(Employee employee) {
        employeeArrayList.add ( employee );
    }

    /**
     * @param employee
     */
    public void removeEmployee(Employee employee) {
        employeeArrayList.remove ( employee );
    }

    /**
     * @return
     */
    protected abstract BigDecimal getAllocation();
}
