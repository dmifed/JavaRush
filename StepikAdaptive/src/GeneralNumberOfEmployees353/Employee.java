package GeneralNumberOfEmployees353;

/**
 * Created by DIMA on 05.07.2018.
 */
public class Employee {
    private String name;
    private Long salary;

    public Employee(String name, Long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {        return name;    }
    public Long getSalary() {        return salary;    }
}
