package com.in30minutes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        ApplicationContext cont = new ClassPathXmlApplicationContext("spring.xml");
        Laptop lap = (Laptop) cont.getBean("lap");
    }
}
