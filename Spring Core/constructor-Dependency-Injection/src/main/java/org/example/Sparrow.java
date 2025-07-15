package org.example;

public class Sparrow {
    Bird bird;
    Sparrow(Bird bird)                  //dependency Injection---Objection Insertion
    {
        this.bird=bird;
    }
    public void flyHigh()
    {
        int fly=bird.fly();  //first need to fly
        if(fly>=1)
        {
            System.out.print("Start fly high");
        }
    }

}
