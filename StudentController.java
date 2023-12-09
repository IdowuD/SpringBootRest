package com.hccs.project2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class StudentController {
	
	@GetMapping("/name/{fName}")
	public String searchByName(@PathVariable String fName) throws IOException{
		ArrayList<Student> students = loadStudents();
		
		for(Student student:students) {
			if(student.getFirstName().equalsIgnoreCase(fName)) {
				return student.toString();
			}
		}
		return fName + " cannot be found";
	}
	
	@GetMapping("/student")
	public String searchByGpaAndGender(@RequestParam double gpa, @RequestParam String gender) throws IOException{
		ArrayList<Student> matchResults= new ArrayList<>();
		ArrayList<Student> students = loadStudents();
		
		for(Student student:students) {
			if(student.getGpa() == gpa & student.getGender().equalsIgnoreCase(gender)) {
				matchResults.add(student);
			}
		}
		
		if(matchResults.size() == 0) {
			return "No matches found!";
		}
		return matchResults.toString();
	}
	
	@GetMapping("/gpa")
	public String averageGpa(String name) throws IOException{
		ArrayList<Student> students = loadStudents();
		double gpas = 0;
		
		for(Student student:students) {
			gpas += student.getGpa();
		}
		
		return "The average gpa for this group of students is " + gpas / students.size();
	}
	
	public ArrayList<Student> loadStudents() throws IOException{
		FileReader fileReader = new FileReader("C:/Users/idowu.disu/Documents/student.txt/");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		ArrayList<Student> students = new ArrayList<>();
		
		String data = bufferedReader.readLine();
		data = bufferedReader.readLine();
		
		while(data != null) {
			String[] studentString = data.split(",");
			Student student = new Student(studentString[1], Double.parseDouble(studentString[2]), studentString[3], studentString[4]);
			students.add(student);
			
			data = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		
		return students;
	}
}
