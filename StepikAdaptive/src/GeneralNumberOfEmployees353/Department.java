package GeneralNumberOfEmployees353;

import java.util.List;

/**
 * Created by DIMA on 05.07.2018.
 */
public class Department {
    private String name;
    private String code;
    private List<Employee> employees;

    public Department(String name, String code, List<Employee> employees) {
        this.name = name;
        this.code = code;
        this.employees = employees;
    }

    public String getName() {        return name;    }
    public String getCode() {        return code;    }
    public List<Employee> getEmployees() {        return employees;    }
}
