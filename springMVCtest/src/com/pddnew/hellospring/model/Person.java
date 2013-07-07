package com.pddnew.hellospring.model;

/**
 * <p>
		Notice: This application were done using the tutorial in the URL:
		<br/> http://outbottle.com/spring-3-web-mvc-friendly-url-using-requestmapping-variable-uri/
		<br/> Last visited: July 07 2013.
	</p>
 * */
public class Person {

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
