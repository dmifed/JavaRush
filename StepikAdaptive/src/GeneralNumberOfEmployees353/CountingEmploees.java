package GeneralNumberOfEmployees353;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by DIMA on 05.07.2018.
 */
public class CountingEmploees {
    public static void main(String[] args) {
        Employee a = new Employee("A", 100L);
        Employee b = new Employee("B", 101L);
        Employee c = new Employee("C", 102L);
        Employee d = new Employee("D", 103L);
        Employee e = new Employee("E", 104L);
        Employee f = new Employee("F", 105L);
        Employee g = new Employee("G", 106L);
        Employee h = new Employee("H", 107L);
        Employee k = new Employee("K", 108L);
        Employee n = new Employee("N", 115L);
        Employee m = new Employee("M", 110L);
        Employee t = new Employee("T", 111L);

        List<Employee> listDepart111 = new ArrayList<>();
        List<Employee> listDepart222 = new ArrayList<>();
        List<Employee> listDepart333 = new ArrayList<>();

        listDepart111.add(a);
        listDepart111.add(b);
        listDepart111.add(c);
        listDepart111.add(d);

        listDepart222.add(e);
        listDepart222.add(f);
        listDepart222.add(g);
        listDepart222.add(h);
        listDepart222.add(k);

        listDepart333.add(n);
        listDepart333.add(m);
        listDepart333.add(t);

        Department d111 = new Department("D1D", "111-ASA", listDepart111);
        Department d222 = new Department("D2D", "111-ASA", listDepart222);
        Department d333 = new Department("D3D", "101-ADA", listDepart333);

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(d111);
        departmentList.add(d222);
        departmentList.add(d333);

        System.out.println(calcNumberOfEmployees(departmentList, 104L));

    }

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold is lower edge of salary
     *
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {

        return departments.stream() //get stream
                .filter(n -> n.getCode().startsWith("111-")) //filter required departments
                .flatMap(n -> n.getEmployees().stream()) //get stream of employees
                .filter(n -> n.getSalary()>=threshold) //filter required employees
                .count(); //count required employees

        //long count = employeeList.filter(n -> n.getSalary()>threshold).count();


        //return count;

    }








}
