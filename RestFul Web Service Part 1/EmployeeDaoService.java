package com.example.restfulWebServices;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {

    private static List<Employee> employeeList = new ArrayList<Employee>();
    private static int empCount = 5;

    static {
        employeeList.add(new Employee(1, "Shubham", 24));
        employeeList.add(new Employee(2, "Vardan", 26));
        employeeList.add(new Employee(3, "Abhay", 25));
        employeeList.add(new Employee(4, "Rishabh", 23));
        employeeList.add(new Employee(5, "Vikas", 25));

    }

    public List<Employee> getAllEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(Employee employee) {
        if(employee.getId() == null)
        {
            employee.setId(++empCount);
        }
        employeeList.add(employee);
        return employee;
    }

    public Employee findOneEmployee(int id)
    {
        for(Employee emp : employeeList)
        {
            if(emp.getId() == id)
            {
                return emp;
            }
        }
        return null;
    }

    public Employee deleteEmployeeById(int id)
    {
        Iterator<Employee> iterator = employeeList.iterator();
        while(iterator.hasNext())
        {
            Employee emp = iterator.next();
            if(emp.getId() == id)
            {
                iterator.remove();
                return emp;
            }
        }

        return null;
    }

    public Employee updateEmployee(Employee employee, int id)
    {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                employeeList.set(employeeList.indexOf(emp), employee);
                return emp;
            }
        }

        return null;
    }



}
