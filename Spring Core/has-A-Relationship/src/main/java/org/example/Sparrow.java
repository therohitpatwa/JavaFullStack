package org.example;

public class Sparrow {

    public static void main(String[] args) {
        Sparrow s=new Sparrow();
        s.flyHigh();
    }
    public void flyHigh()
    {
        Bird b=new Bird();
        int fly=b.fly();//first need to fly
        if(fly>=1)
        {
            System.out.print("Start fly high");
        }
    }

}
