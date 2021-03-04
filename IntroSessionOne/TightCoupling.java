package com.example.SpringSessionOne;

interface Job {
    public void display();
}

class Doctor implements Job {

    @Override
    public void display() {
        System.out.println("\n This is Doctor");
    }
}

class Engineer implements Job {

    @Override
    public void display() {
        System.out.println("\nThis is Engineer");
    }

}

public class TightCoupling {

    Doctor doctor;
    Engineer engineer;

    public TightCoupling(Doctor doctor, Engineer engineer) {
        this.doctor = doctor;
        this.engineer = engineer;
    }
    public void display() {
        doctor.display();
        engineer.display();
    }

    public static void main(String[] args) {

        Engineer eng = new Engineer();
        Doctor doc = new Doctor();

        TightCoupling tightCoupling = new TightCoupling(doc,eng );
        tightCoupling.display();
    }
}
