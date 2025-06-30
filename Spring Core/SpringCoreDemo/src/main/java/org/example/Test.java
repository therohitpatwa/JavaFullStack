package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
  public static void main(String[] args) throws Exception {
    //starting ioc
    ApplicationContext ap = new ClassPathXmlApplicationContext("Beans.xml");
    Car car = ap.getBean(Car.class);
    MHawk bean = ap.getBean(MHawk.class);
    car.drive();
  }
}
