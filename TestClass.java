package home.myprojects;

import java.io.*;
import java.util.*;
import java.nio.*;
// import java.io.BufferedReader; 
// import java.io.IOException; 
// import java.nio.charset.StandardCharsets; 
// import java.nio.file.Files; 
// import java.nio.file.Path; 
// import java.nio.file.Paths; 
// import java.util.ArrayList; 
// import java.util.List;


public class TestClass{

	public static void main (String... args){
		
		TestClass newEmployee = new TestClass();
		TestHelper helper = new TestHelper();
		CSVReader reader = new CSVReader();
		ArrayList<Employee> employees = reader.readCSVFile("/Users/ashwini/Dropbox/Programs/Data_File.csv");
		Manager manager = new Manager();
		ArrayList<Manager> managers = manager.createManagerList(employees);
		
		int choice =0;
		do{
			// Is there a better way to do write this loop?
			// Is there a difference between giving input 0 and 9?
			choice = newEmployee.displayOptionAndReadUserInput(employees);
			if(choice!=0){
				switch(choice){
					case 1: helper.readEmployeeNameAndDisplayDetails(employees);
							break;
					case 2: helper.readManagerNameAndDisplayReporteeDetails(employees);
							break;
					case 3: helper.readOrgAndDisplayWithinOrgManagerCount(employees);
							break; 
					case 4: helper.readOrgAndDisplayWithinOrgEmployeeCount(employees);
							break;
					case 5: helper.readLevelAndDisplayWithinLevelEmployeeCount(employees);
							break;
					case 6: helper.readNameAndConfirmWhetherAManager(employees);
							break;
					case 7: helper.readLevelAndConfirmWhetherACeo(employees);
							break;
					case 8: helper.displayManagersWithPeersAsReportees(employees,managers);
							break;
					default: System.out.println("You have entered an invalid choice");
				}
			}
			}while(choice!=0);

	}


private static int displayOptionAndReadUserInput(ArrayList<Employee> emp){
		Scanner input = new Scanner(System.in);
		int choice=0;

			System.out.println(" Please choose one of the options below to fetch the details needed or enter 0 to exit :");
			System.out.println(" 1. Enter First/Last name of the employee to get all the details.\n 2. Enter Manager Name to get all reportees.\n 3. Enter Org to get count of all Managers.\n 4. Enter Org to get count of all employees.\n 5. Enter Level to get count of all employees.\n 6. Enter First/Last name to find out if he/she is a manager.\n 7. Enter employee level to see if he/she is a CEO.\n 8. Display managers with peers as a reportee.");
			choice = input.nextInt();

			return choice;
			
		}
}
