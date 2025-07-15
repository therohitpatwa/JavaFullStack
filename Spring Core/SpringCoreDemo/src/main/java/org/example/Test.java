//package org.example;


//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.ClassPathResource;
//
//public class Test {
//  public static void main(String[] args) throws Exception {
//    //starting ioc
//   BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("Bean.xml"));
//    BeanFactory beanFactory = new ClassPathXmlApplicationContext("Beans.xml");
               //  Bean factory follow lazy loading
//  }
//}

package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
  public static void main(String[] args) throws Exception {
    //starting ioc
    ApplicationContext ap = new ClassPathXmlApplicationContext("Bean.xml");   //beans created
    Car car = ap.getBean(Car.class);     //getting beans from heap
    MHawk bean = ap.getBean(MHawk.class);   //getting beans from heap
    car.drive();
  }
}

