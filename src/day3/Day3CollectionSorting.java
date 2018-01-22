package day3;

import com.lazada.assets.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day3CollectionSorting {  // COMPARABLE interface - compareTo,  COMPARATOR class - compare

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("D-00001",3, 4f));
        employees.add(new Employee("D-00002",1, 10f));
        employees.add(new Employee("D-00003",2, 0f));

        Collections.sort(employees);
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        employees.forEach(x->{System.out.format("#%d %s %f\n", x.getId(), x.getName(), x.getSalary());});

    }
}
