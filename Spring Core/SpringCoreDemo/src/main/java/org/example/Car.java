package org.example;

public class Car {
    private Engine engine;
    public Car()
    {
        System.out.println("Car cons");
        this.engine=engine;
    }
    public void setEngine(Engine engine)
    {
        System.out.println("Car Setter Method");
        this.engine=engine;
    }


    public void drive()
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
