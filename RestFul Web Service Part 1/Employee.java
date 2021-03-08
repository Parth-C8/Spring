package com.example.restfulWebServices;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Employee {

    private Integer id;

    @Positive(message = "Age must be a positive integer")
    private Integer age;

    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;

    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
