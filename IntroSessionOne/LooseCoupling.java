package com.example.SpringSessionOne;


interface Job1 {
    public void display();
}

class Lawyer implements Job1 {

    @Override
    public void display() {
        System.out.println("\nThis is Lawyer");
    }
}

class Scientist implements Job1 {

    @Override
    public void display() {
        System.out.println("\nThis is Scientist");
    }

}
public class LooseCoupling {

    Job1 job1;

    public LooseCoupling(Job1 job1) {
        this.job1 = job1;
    }
    public void display() {
        job1.display();
    }

    public static void main(String[] args) {

        Lawyer lawyer = new Lawyer();
        Scientist scientist = new Scientist();
        LooseCoupling looseCoupling = new LooseCoupling(lawyer);
        LooseCoupling looseCoupling1 = new LooseCoupling(scientist);
        looseCoupling.display();
        looseCoupling1.display();

    }
}
