package org.example;

public class Sparrow extends  Bird{
    public static void main(String[] args) {
        Sparrow s=new Sparrow();
        s.flyHigh();
    }
    public  void flyHigh()
    {
        int fly=super.fly();  //first need to fly
        if(fly>=1)
        {
            System.out.print("Start fly high");
        }
    }

}


//No need of dangrous function but it has by deafault due to inheritence so it increse load
