package com.example.restfulWebServiceTwo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeDaoService {

    private static List<Employee> employeeList = new ArrayList<Employee>();
    private static int empCount = 5;

    static {
        employeeList.add(new Employee(1, "Shubham", 24,"abc"));
        employeeList.add(new Employee(2, "Vardan", 26,"123"));
        employeeList.add(new Employee(3, "Abhay", 25,"pass"));
        employeeList.add(new Employee(4, "Rishabh", 23,"word"));
        employeeList.add(new Employee(5, "Vikas", 25,"hello"));

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
