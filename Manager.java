package home.myprojects;

import java.util.*;
import java.io.*;


//The class Manager currently has no
public class Manager extends Employee{

	// protected void setFirstName(){
	// 	System.out.println("Enter the First Name of the Manager");
	// 	FirstName = input.nextLine();
	// }

	// protected void setLastName() {
	// 	System.out.println("Enter the Last Name of the Manager");
	// 	LastName = input.nextLine();
	// }

	// protected void setManager() {
	// }

	// protected void setOrg() {
	// 	System.out.println("Enter the Organization of the Manager");
	// 	Org = input.nextLine();
	// }

	// protected void setAge() {
	// 	System.out.println("Enter the Age of the Manager");
	// 	Age = input.nextInt();
	// }

	// // protected void setEmpId() { 
	// // 	System.out.println("Enter the Employee ID of the Manager");
	// // 	EmpId = input.nextInt();
	// // }

	// protected void setLevel() {
	// 	System.out.println("Enter the Level of the Manager");
	// 	Level =input.nextInt();
	// }

	public Manager(){
		// why cant you use super() here?
		firstName = null;
		lastName = null;
		manager = null;
		org = null;
		age = 0;
		level = 0;
	}

	public Manager(String fN, String lN, String mng, String org1, int age1, int lvl ) {
		// why cant you use super() here?
		firstName = fN;
		lastName = lN;
		manager = mng;
		org = org1;
		age = age1;
		level =lvl;
	}

	//Instead of creating a manager list, why dont you use polymorphism?
	// Create a instance variable called isManager & run the loop & then create mark all managers with isManager as true.
	// Also, whats the big advantage of having Manager as a seperate class? why not just have isManager as a instance variable of Employee?
	protected static ArrayList<Manager> createManagerList(ArrayList<Employee> emp){
		ArrayList<Manager> managers = new ArrayList<>();
		ArrayList<String> manager_list = new ArrayList<>();

			for(Employee empl: emp){
					String managerDetails = empl.getManager();
					if(!manager_list.contains(managerDetails)){
						manager_list.add(managerDetails);
					}
				}

				for (Employee empl: emp) {
					if(manager_list.contains(empl.getFirstName())){
						String[] Record = {empl.getFirstName(), empl.getLastName(), Integer.toString(empl.getAge()), Integer.toString(empl.getLevel()), empl.getManager(), empl.getOrg()};
						Manager mng = createManager(Record);
						managers.add(mng);
					}
				}

				return managers;
	}

	protected static Manager createManager (String[] managerRecord){
		// Variable Names!
		String FirstName = managerRecord[0];
		String LastName = managerRecord[1];
		int Age = Integer.parseInt(managerRecord[2]);
		int Level = Integer.parseInt(managerRecord[3]);
		String Manager = managerRecord[4];
		String Org = managerRecord[5];
		

		return new Manager(FirstName, LastName, Manager, Org, Age, Level);
	}

}