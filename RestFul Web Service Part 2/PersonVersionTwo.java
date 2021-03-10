package com.example.restfulWebServiceTwo;

public class PersonVersionTwo {
    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public PersonVersionTwo(Name name) {
        this.name = name;
    }
}
