package com.spring_SpEL;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
      "com/spring_SpEl/SpELConfig.xml"
    );
    Demo bean1 = context.getBean("demo", Demo.class);
    System.out.println(bean1);
    bean1.des();
    bean1.getX();
    context.close();
  }
}
/*
>> Feature Overview
The expression language supports the following functionality
Literal expressions
Boolean and relational operators
Regular expressions
Class expressions
Accessing properties, arrays, lists, maps
Method invocation
Relational operators
Assignment
Calling constructors
Bean references
Array construction
Inline lists
Ternary operator
Variables
User defined functions
Collection projection
Collection selection
Templated expressions
 */
