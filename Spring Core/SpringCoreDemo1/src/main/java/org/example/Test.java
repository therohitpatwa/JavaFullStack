
package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
  public static void main(String[] args) throws Exception {
    //starting IOC
    ApplicationContext ap = new ClassPathXmlApplicationContext("Beans.xml");   //beans created
    Car car = ap.getBean(Car.class);        //getting beans from heap
    MHawk bean = ap.getBean(MHawk.class);   //getting beans from heap
    car.drive();
  }
}

