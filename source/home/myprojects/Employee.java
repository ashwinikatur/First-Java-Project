package home.myprojects;

import java.util.*;
import java.io.*;

public class Employee{
	
	protected int empId;
	protected String firstName;
	protected String lastName;
	protected int age;
	protected int level;
	protected String manager;
	protected int managerId;
	protected String org;
	protected boolean isManager;

	public Employee(){
		empId = 0;
		firstName = null;
		lastName = null;
		manager = null;
		org = null;
		age = 0;
		level = 0;
		managerId =0;
		isManager = false;
	}

	// why using fN - alwyas use meaningful variable names.
	public Employee(int empId, String firstName, String lastName, int age, int level, String manager, int managerId, String org ) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = manager;
		this.org = org;
		this.age = age;
		this.level =level;
		this.managerId = managerId;
		this.isManager = false;
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

	protected void setIsManager(){
		this.isManager = true;
	}

	protected int getEmpId() {
		return empId;
	}

	protected String getFirstName(){
		return firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected int getAge() {
		return age;
	}

	protected int getLevel() {
		return level;
	}

	protected String getManager() {
		return manager;
	}

	protected int getManagerId() {
		return managerId;
	}

	protected String getOrg() {
		return org;
	}

	protected boolean getIsManager(){
		return isManager;
	}

	public String toString(){
		return " FirstName: " + firstName + " \n LastName: " + lastName + " \n Manager: " + manager + " \n Org: " + org + " \n Age " + age + " \n Level: " + level;
	}

	protected Employee createEmployee (String[] employeeRecord){
		int empId = Integer.parseInt(employeeRecord[0]);
		String firstName = employeeRecord[1];
		String lastName = employeeRecord[2];
		int age = Integer.parseInt(employeeRecord[3]);
		int level = Integer.parseInt(employeeRecord[4]);
		String manager = employeeRecord[5];
		int managerId = Integer.parseInt(employeeRecord[6]);
		String org = employeeRecord[7];

		return new Employee(empId, firstName, lastName, age, level, manager, managerId, org);
	}

	protected void setManagerFlag(ArrayList<Employee> emp){

		for (Employee empl : emp) {
			int mngId = empl.getManagerId();
			for(Employee employ : emp){
				if(employ.getIsManager() == false && employ.getEmpId() == mngId){
					employ.setIsManager();
				}
			}
		}

	}

}