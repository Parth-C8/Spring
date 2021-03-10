package com.example.restfulWebServiceTwo;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeResource {
    @Autowired
    private EmployeeDaoService employeeDaoService;

    //Get All Employees
    @GetMapping(path = "/all-employee")
    @ApiOperation(value = "Shows List of All Employees")

    public MappingJacksonValue reteriveAllEmployee() {

        List<Employee> emp = employeeDaoService.getAllEmployeeList();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "age");
        FilterProvider filters = new SimpleFilterProvider().addFilter("Filter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(emp);
        mapping.setFilters(filters);
        return mapping;
    }


    //Get One Employee with hateoas
    @GetMapping(path = "/employee/{id}")
   @ApiOperation(value = "Shows One Employee With the Mentioned Id")

    public EntityModel<Employee> reteriveOneEmployee(@PathVariable int id) {
        Employee emp1 = employeeDaoService.findOneEmployee(id);
        if (emp1 == null)
            throw new EmployeeNotFoundException("Employee with id: " + id + " not found !!");

         EntityModel<Employee> resource = EntityModel.of(emp1);
         WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).reteriveAllEmployee());
         resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    //Create a new user
    @PostMapping(path = "/employee")
    @ApiOperation(value = "Creates a new Employee")
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
    @ApiOperation(value = "Deletes an Employee")
    public Employee deleteOneEmployee(@PathVariable int id) {
        Employee emp1 = employeeDaoService.deleteEmployeeById(id);
        if (emp1 == null)
            throw new EmployeeNotFoundException("Employee with id: " + id + " not found !!");
        return emp1;
    }

    //Updates an Employee
    @PutMapping(path = "/employee/{id}")
    @ApiOperation(value = "Updates an Employee with the mentioned id")
    public Employee updateOneEmployee(@RequestBody Employee employee, @PathVariable int id) {
        Employee emp1 = employeeDaoService.updateEmployee(employee, id);
        if (emp1 == null)
            throw new EmployeeNotFoundException("Employee with id: " + id + " not found !!");
        return emp1;
    }

}
