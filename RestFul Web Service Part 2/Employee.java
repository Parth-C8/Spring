package com.example.restfulWebServiceTwo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@ApiModel(description = "Employee Model")
//@JsonFilter("Filter")
public class Employee {

    private Integer id;

    @Positive(message = "Age must be a positive integer")
    @ApiModelProperty(notes = "Age must be a positive integer")
    private Integer age;

    @Size(min = 3, message = "Name should have at least 3 characters")
    @ApiModelProperty(notes = "Name should have at least 3 characters")
    private String name;

    //@JsonIgnore
    private String password;


    public Employee(Integer id, String name, Integer age, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
