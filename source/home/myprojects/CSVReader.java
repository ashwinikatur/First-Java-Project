package home.myprojects;

import java.io.*;
import java.util.*;
import java.nio.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;

public class CSVReader{

	protected ArrayList<Employee> readCSVFile(String newFile){
		
		ArrayList<Employee> employees = new ArrayList<>();
		Employee employee = new Employee();
		
		Path pathToFile = Paths.get(newFile);

		try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

			String line = br.readLine();

			while (line != null) {

			String[] record= line.split(",");
			
			Employee emp = employee.createEmployee(record);
			
			employees.add(emp);
			
			line = br.readLine();
			}

		}catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} 

			return employees;
		}

}
