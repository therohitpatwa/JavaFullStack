package org.example;


import java.lang.reflect.Field;

public class Test{
  public static void main(String[] args) throws Exception {
//        Car car=new Car(new KSeries());
//        car.setEngine(new MHawk());
//        car.Drive();
      //this is reflection
      Class<?> cl=Class.forName("org.example.Car");
      Object object=cl.newInstance();
      Car car=(Car) object;

      Field field=cl.getDeclaredField("engine");
      field.setAccessible(true);

      field.set(car,new MHawk());
      car.drive();

  }
}
