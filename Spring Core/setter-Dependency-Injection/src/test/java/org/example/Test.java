package org.example;

public class Test{
    public static void main(String[] args) {
        Car car=new Car(new KSeries());
        car.setEngine(new MHawk());
        car.Drive();
    }
}
