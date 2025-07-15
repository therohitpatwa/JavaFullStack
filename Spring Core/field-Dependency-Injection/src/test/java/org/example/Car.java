package org.example;

public class Car {
    private Engine engine;
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
