package org.example;

public class Car {
    private Engine engine;
    Car(Engine engine)
    {
        System.out.println("Car class Argument Constructor");
        this.engine=engine;
    }


    public void setEngine(Engine engine) {
        System.out.println("Setter Method");
        this.engine = engine;
    }
    public void Drive()
    {
        int start=engine.start();
        if(start>=1)
        {
            System.out.println("Car Running");
        }
        else
        {
            System.out.println("Engine is in trouble");
        }
    }

}
