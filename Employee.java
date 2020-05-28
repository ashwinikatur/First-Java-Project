package home.myprojects;

import java.util.*;
import java.io.*;

public class Employee{
	
	protected String firstName;
	protected String lastName;
	protected String manager;
	protected String org;
	protected int age;
	protected int level;

	public Employee(){
		firstName = null;
		lastName = null;
		manager = null;
		org = null;
		age = 0;
		level = 0;
	}

	// why using fN - alwyas use meaningful variable names.
	public Employee(String fN, String lN, String mng, String org1, int age1, int lvl ) {
		firstName = fN;
		lastName = lN;
		manager = mng;
		org = org1;
		age = age1;
		level =lvl;
	}

	// protected void setFirstName(String fN){
	// 	// System.out.println("Enter the First Name of the employee");
	// 	firstName = fN;
	// }

	// protected void setLastName(String lN) {
	// 	// System.out.println("Enter the Last Name of the employee");
	// 	lastName = lN;
	// }

	// protected void setManager(String mng) {
	// 	// System.out.println("Enter the Manager of the employee");
	// 	manager = mng;
	// }

	// protected void setOrg(String org1) {
	// 	// System.out.println("Enter the Organization of the employee");
	// 	org = org1;
	// }

	// protected void setAge(int age1) {
	// 	// System.out.println("Enter the Age of the employee");
	// 	age = age1;
	// }

	// protected void setLevel(int lvl) {
	// 	// System.out.println("Enter the Level of the employee");
	// 	level =lvl;
	// }

	protected String getFirstName(){
		return firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected String getManager() {
		return manager;
	}

	protected String getOrg() {
		return org;
	}

	protected int getAge() {
		return age;
	}

	protected int getLevel() {
		return level;
	}


	public String toString(){
		return " FirstName: " + firstName + " \n LastName: " + lastName + " \n Manager: " + manager + " \n Org: " + org + " \n Age " + age + " \n Level: " + level;
	}

	protected Employee createEmployee (String[] employeeRecord){
		String firstName = employeeRecord[0];
		String lastName = employeeRecord[1];
		int age = Integer.parseInt(employeeRecord[2]);
		int level = Integer.parseInt(employeeRecord[3]);
		String manager = employeeRecord[4];
		String org = employeeRecord[5];

		return new Employee(firstName, lastName, manager, org, age, level);
	}

}