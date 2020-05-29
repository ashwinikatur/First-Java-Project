// package home.myprojects;

// import java.util.*;
// import java.io.*;


// //The class Manager currently has no
// public class Manager extends Employee{

// 	public Manager(){
// 		super();
// 	}

// 	public Manager(String firstName, String lastName, String manager, String org, int age, int level ) {
// 		super(firstName,lastName,manager,org,age,level);
		
// 	}

// 	//Instead of creating a manager list, why dont you use polymorphism?
// 	// Create a instance variable called isManager & run the loop & then create mark all managers with isManager as true.
// 	// Also, whats the big advantage of having Manager as a seperate class? why not just have isManager as a instance variable of Employee?
// 	protected static ArrayList<Manager> createManagerList(ArrayList<Employee> emp){
// 		ArrayList<Manager> managers = new ArrayList<>();
// 		ArrayList<String> manager_list = new ArrayList<>();

// 			for(Employee empl: emp){
// 					String managerDetails = empl.getManager();
// 					if(!manager_list.contains(managerDetails)){
// 						manager_list.add(managerDetails);
// 					}
// 				}

// 				for (Employee empl: emp) {
// 					if(manager_list.contains(empl.getFirstName())){
// 						String[] Record = {empl.getFirstName(), empl.getLastName(), Integer.toString(empl.getAge()), Integer.toString(empl.getLevel()), empl.getManager(), empl.getOrg()};
// 						Manager mng = createManager(Record);
// 						managers.add(mng);
// 					}
// 				}

// 				return managers;
// 	}

// 	protected static Manager createManager (String[] managerRecord){
// 		// Variable Names!
// 		String firstName = managerRecord[0];
// 		String lastName = managerRecord[1];
// 		int age = Integer.parseInt(managerRecord[2]);
// 		int level = Integer.parseInt(managerRecord[3]);
// 		String manager = managerRecord[4];
// 		String org = managerRecord[5];
		

// 		return new Manager(FirstName, LastName, Manager, Org, Age, Level);
// 	}

// }