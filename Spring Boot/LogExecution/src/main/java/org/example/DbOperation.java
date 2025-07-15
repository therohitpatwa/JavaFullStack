package org.example;

public class DbOperation {
    @LogExecutionTime
    public void readdata() throws InterruptedException
    {
        Thread.sleep(2000);
        System.out.println("Tesk Completed");
    }

}
