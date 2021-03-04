package com.example.SpringSessionOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringSessionOneApplication {

    public static void main(String[] args) {

       ApplicationContext applicationContext = SpringApplication.run(SpringSessionOneApplication.class, args);
       ManageShape manageShape = applicationContext.getBean(ManageShape.class);

       manageShape.getSquare(); // display all the properties of square
       manageShape.getRectangle(); //// display all the properties of rectangle

    }

}
