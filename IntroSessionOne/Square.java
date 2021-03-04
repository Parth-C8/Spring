package com.example.SpringSessionOne;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component  //Inform Spring that it is a bean
@Primary
//Inform Spring to give this bean higher preference because we have other beans also, hence manages conflicts
public class Square implements Shape{

    int side = 5;

    public int getSide(){

        return side;
    }
    @Override
    public void area() {
        System.out.println("\nSquare Area: "+ (side * side));
    }

    @Override
    public void perimeter() {
        System.out.println("\nSquare Perimeter: "+ (4 * side));
    }
}
