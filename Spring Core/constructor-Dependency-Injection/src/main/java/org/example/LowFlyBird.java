package org.example;

public class LowFlyBird  implements Bird{

    @Override
    public int fly() {
        System.out.println("Start fly");
        return 1;
    }
}
