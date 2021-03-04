package com.example.SpringSessionOne;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape {
    int length = 7;
    int breadth = 4;

    public int getLength()
    {
        return length;
    }
    public int getBreadth()
    {
        return breadth;
    }
    @Override
    public void area() {
        System.out.println("\nRectangle Area: "+ (length * breadth));
    }

    @Override
    public void perimeter() {
        System.out.println("\nRectangle Parameter: "+ 2 *(length + breadth));
    }
}
