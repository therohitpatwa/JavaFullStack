package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class Driver {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        DbOperation dbOperation=new DbOperation();
        Method method=DbOperation.class.getMethod("readdata");
        if(method.isAnnotationPresent(LogExecutionTime.class))
        {
            long start=System.currentTimeMillis();
            method.invoke(dbOperation);
            long end=System.currentTimeMillis();
            System.out.println("Execution Time "+(end-start));

        }
    }


}

