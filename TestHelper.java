package home.myprojects;

import java.io.*;
import java.util.*;
import java.nio.*;


public class TestHelper{

	private int count;
	private String userInput;

	private static String getUserInput(){
		String userInput;
		Scanner input = new Scanner(System.in);
		userInput = input.next();
		return userInput;
	}

	// all of These methds are not helper methods. They are the main logic of the progrem.
	// They should probably be in testclass.java.
	protected void readEmployeeNameAndDisplayDetails(ArrayList<Employee> emp){
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

	protected void readManagerNameAndDisplayReporteeDetails(ArrayList<Employee> emp){
		
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

	protected void readOrgAndDisplayWithinOrgManagerCount(ArrayList<Employee> emp){
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
	

protected void readOrgAndDisplayWithinOrgEmployeeCount(ArrayList<Employee> emp){
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
					

protected void readLevelAndDisplayWithinLevelEmployeeCount(ArrayList<Employee> emp){
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
	
protected void readNameAndConfirmWhetherAManager(ArrayList<Employee> emp){
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

protected void readLevelAndConfirmWhetherACeo(ArrayList<Employee> emp){
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

protected void displayManagersWithPeersAsReportees(ArrayList<Employee> emp, ArrayList<Manager> mng){

	// for(Manager mngr : mng){
	// 	System.out.println(mngr.toString());
	// }
	int level;
	String name;
	count =0;

	for(Manager mngr : mng){
		level = mngr.getLevel();
		name = mngr.getFirstName();

		for(Employee empl: emp) {
			if(level == empl.getLevel() && name.contains(empl.getManager()) && (!empl.getFirstName().contains(name))){
				System.out.println("\n Manager:" + name);
				count++;
			}
			
		}
	}

	if(count ==0){
		System.out.println("No managers with peers As reportees");
	}
	
}

}

