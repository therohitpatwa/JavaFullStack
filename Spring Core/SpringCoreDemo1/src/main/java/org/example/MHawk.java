package org.example;

public class MHawk implements Engine{
    public MHawk() {
        System.out.println("MHawk Con");
    }

    public int start()
    {
        System.out.println("MHawk Engine");
        return 1;
    }

}
