package com.example.restfulWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {
    @Autowired
    private EmployeeDaoService employeeDaoService;

    //Get All Employees
    @GetMapping(path = "/all-employee")
    public List<Employee> reteriveAllEmployee() {
        return employeeDaoService.getAllEmployeeList();
    }

    //Get One Employee
    @GetMapping(path = "/employee/{id}")
    public Employee reteriveOneEmployee(@PathVariable int id) {
        Employee emp1 = employeeDaoService.findOneEmployee(id);
        if (emp1 == null)
            throw new EmployeeNotFoundException("Employee with id: " + id + " not found !!");
        return emp1;
    }

    //Create a new user
    @PostMapping(path = "/employee")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee) {
        Employee employee1 = employeeDaoService.createEmployee(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee1.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    //Delete an Employee
    @DeleteMapping(path = "/employee/{id}")
    public Employee deleteOneEmployee(@PathVariable int id) {
        Employee emp1 = employeeDaoService.deleteEmployeeById(id);
        if (emp1 == null)
            throw new EmployeeNotFoundException("Employee with id: " + id + " not found !!");
        return emp1;
    }

    //Updates an Employee
    @PutMapping(path = "/employee/{id}")
    public Employee updateOneEmployee(@RequestBody Employee employee, @PathVariable int id) {
        Employee emp1 = employeeDaoService.updateEmployee(employee,id);
        if (emp1 == null)
            throw new EmployeeNotFoundException("Employee with id: " + id + " not found !!");
        return emp1;
    }



    /*      //Create a new user
    @PostMapping(path = "/employee")
    public Employee addEmployee(@Valid @RequestBody Employee employee)
    {
        Employee employee1 = employeeDaoService.createEmployee(employee);
        return employee1;
    }
*/
}
