package home.myprojects;

import java.io.*;
import java.util.*;
import java.nio.*;


public class TestClass{
	
	private int count;
	private String userInput;


	private static int displayOptionAndReadUserInput(ArrayList<Employee> emp){
		Scanner input = new Scanner(System.in);
		int choice=0;

			System.out.println(" Please choose one of the options below to fetch the details needed or enter 0 to exit :");
			System.out.println(" 1. Enter First/Last name of the employee to get all the details.\n 2. Enter Manager Name to get all reportees.\n 3. Enter Org to get count of all Managers.\n 4. Enter Org to get count of all employees.\n 5. Enter Level to get count of all employees.\n 6. Enter First/Last name to find out if he/she is a manager.\n 7. Enter employee level to see if he/she is a CEO.\n 8. Display managers with peers as a reportee.");
			choice = input.nextInt();

			return choice;
			
	}



	private static String getUserInput(){
		String userInput;
		Scanner input = new Scanner(System.in);
		userInput = input.next();
		return userInput;
	}

	private void readEmployeeNameAndDisplayDetails(ArrayList<Employee> emp){
		count=0;
		System.out.println("Enter First/Last name of the employee:");
		userInput = getUserInput();

				for (Employee empl: emp) {					

					if(empl.getFirstName().contains(userInput) || empl.getLastName().contains(userInput)){
						System.out.println(empl.toString());
						count++;

					}
				}
				if (count == 0) {
					System.out.println("No employee record found.");
				}

	}

	private void readManagerNameAndDisplayReporteeDetails(ArrayList<Employee> emp){
		
	 	count=0;
		System.out.println("Enter First/Last name of the Manager:");
		userInput = getUserInput();
					
					for (Employee empl: emp) {
						if(empl.getManager().equals(userInput)){
							count++;
							System.out.println("Employee " + count + " with Manager " + userInput + " is: ");
							System.out.println(empl.toString());

						}	
					}
					if(count ==0){
						System.out.println("No reportees found under the entered Manager.");
					}
	}

	private void readOrgAndDisplayWithinOrgManagerCount(ArrayList<Employee> emp){
		HashMap<String,Integer> managerList = new HashMap<String,Integer>();
		System.out.println("Enter the organization of the manager");
		userInput = getUserInput();
		Integer newCount;
					
					for (Employee empl: emp) {
						
						String managerDetails = empl.getManager();

						if(empl.getOrg().equals(userInput)){
							newCount = managerList.get(managerDetails);
							if (newCount == null) {
								managerList.put(managerDetails,1);
							}
							else {
								managerList.put(managerDetails, newCount+1);
							}
							
						}
					}

					if(managerList.size() !=0){
						System.out.println("The count of Managers in org " + userInput + " is: " + managerList.size());
						System.out.println("The Managers and the number of reportees under them in org " + userInput + " is: " + managerList);
					}else{
						System.out.println("No Managers found in org " + userInput);
					}
	}
	

private void readOrgAndDisplayWithinOrgEmployeeCount(ArrayList<Employee> emp){
	count=0;
	System.out.println("Enter the organization of the employee");
	userInput = getUserInput();

					for (Employee empl: emp) {
						if(empl.getOrg().equals(userInput)){
							count++;
						}
					}

					if(count !=0){
						System.out.println("The count of Employees in org " + userInput + " is: " + count);
					}else{
						System.out.println("No Employees found in org " + userInput);
					}
}
					

private void readLevelAndDisplayWithinLevelEmployeeCount(ArrayList<Employee> emp){
	count=0;
	System.out.println("Enter the level of the employee");
	userInput = getUserInput();

					for (Employee empl: emp) {
						if(String.valueOf(empl.getLevel()).equals(userInput)){
							count++;
						}
					}

					if(count !=0){
						System.out.println("The count of Employees under level " + userInput + " is: " + count);
					}else{
						System.out.println("No Employees found undel level " + userInput);
					}
}
	
private void readNameAndConfirmWhetherAManager(ArrayList<Employee> emp){
	count=0;
	System.out.println("Enter the first/last name of the employee");
	userInput = getUserInput();

					for (Employee empl: emp) {
						if(empl.getManager().contains(userInput)){
							count++;
						}
					}

					if(count !=0){
						System.out.println("Yes, the entered employee is a Manager");
					}else{
						System.out.println("No, the entered employee is not a Manager");
					}
}

private void readLevelAndConfirmWhetherACeo(ArrayList<Employee> emp){
	System.out.println("Enter the level of the employee");
	userInput = getUserInput();

					if(!userInput.equals("5")){
						System.out.println("No, the employee with the entered level is not a CEO");
					} else{
						for (Employee empl: emp) {
							if(String.valueOf(empl.getLevel()).equals(userInput)){
								System.out.println("Yes, the employee with the entered level is a CEO");
								System.out.println(empl.toString());
							}
						}
					}

}

// private void displayManagersWithPeersAsReportees(ArrayList<Employee> emp, ArrayList<Manager> mng){

// 	// for(Manager mngr : mng){
// 	// 	System.out.println(mngr.toString());
// 	// }
// 	int level;
// 	String name;
// 	count =0;

// 	for(Manager mngr : mng){
// 		level = mngr.getLevel();
// 		name = mngr.getFirstName();

// 		for(Employee empl: emp) {
// 			if(level == empl.getLevel() && name.contains(empl.getManager()) && (!empl.getFirstName().contains(name))){
// 				System.out.println("\n Manager:" + name);
// 				count++;
// 			}
			
// 		}
// 	}

// 	if(count ==0){
// 		System.out.println("No managers with peers As reportees");
// 	}
	
// }

private void displayManagersWithPeersAsReportees(ArrayList<Employee> emp){

	// for(Manager mngr : mng){
	// 	System.out.println(mngr.toString());
	// }
	int level;
	int id;
	String name;
	ArrayList<String> managerList = new ArrayList<>();
	count =0;

	for(Employee empl: emp){
		if(empl.getIsManager()){
				level = empl.getLevel();
				id = empl.getEmpId();
				name = empl.getFirstName();
			for(Employee employ: emp) {
				if(employ.getLevel() == level && employ.getManagerId() == id && employ.getEmpId() != id) {
				//System.out.println("\n Manager:" + name);
				if(!managerList.contains(name))
				{
					managerList.add(name);
					count++;
				}
			}
			
			}
		}
	}

	if(count ==0){
		System.out.println("No managers with peers As reportees");
	}
	else {
		for(String manager : managerList)
		{
			System.out.println("\n Manager:" + manager);
		}	
	}
	
}

public static void main (String... args){
		
		TestClass newEmployee = new TestClass();
		//TestHelper helper = new TestHelper();
		CSVReader reader = new CSVReader();
		ArrayList<Employee> employees = reader.readCSVFile("/Users/ashwini/Desktop/First-Repo/source/home/myprojects/Data_File.csv");
		// Manager manager = new Manager();
		// ArrayList<Manager> managers = manager.createManagerList(employees);
		Employee employee = new Employee();
		employee.setManagerFlag(employees);
		
				
		int choice =0;
		do{
			// Is there a better way to do write this loop?
			// Is there a difference between giving input 0 and 9? - So i have used 0 as an option 
			// for exiting the program whereas any other number they enter will only show them that its 
			// an invalid choice and ask them to re-enter the option.
			
			choice = newEmployee.displayOptionAndReadUserInput(employees);
			if(choice!=0){
				switch(choice){
					case 1: newEmployee.readEmployeeNameAndDisplayDetails(employees);
							break;
					case 2: newEmployee.readManagerNameAndDisplayReporteeDetails(employees);
							break;
					case 3: newEmployee.readOrgAndDisplayWithinOrgManagerCount(employees);
							break; 
					case 4: newEmployee.readOrgAndDisplayWithinOrgEmployeeCount(employees);
							break;
					case 5: newEmployee.readLevelAndDisplayWithinLevelEmployeeCount(employees);
							break;
					case 6: newEmployee.readNameAndConfirmWhetherAManager(employees);
							break;
					case 7: newEmployee.readLevelAndConfirmWhetherACeo(employees);
							break;
					case 8: newEmployee.displayManagersWithPeersAsReportees(employees);
							break;
					default: System.out.println("You have entered an invalid choice");
				}
			}
			}while(choice!=0);

}

}
