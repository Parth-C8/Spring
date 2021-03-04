package com.example.SpringSessionOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageShape {
    @Autowired
    private Square square;
    private Rectangle rectangle;

    public ManageShape(Square sqr, Rectangle rect) {
        this.square = sqr;
        this.rectangle = rect;
    }
    public void getSquare(){
        int s = square.getSide();
        System.out.println("\nValue of Side of a square is: "+ s);

        square.area();
        square.perimeter();
    }
    public void getRectangle()
    {
        int l = rectangle.getLength();
        System.out.println("\nLength of Rectangle is: "+l);
        int b = rectangle.getBreadth();
        System.out.println("\nBreadth of Rectangle is: "+b);
        rectangle.area();
        rectangle.perimeter();
    }
}
