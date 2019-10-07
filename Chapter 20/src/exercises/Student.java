package exercises;

import java.util.LinkedList;
import java.util.Queue;

public class Student {

	private String name;
	private double GPA;
	
	public Student(String n, double x) {
		name = n;
		GPA = x;
	}
	
	public String toString() {
		return name +" "+ GPA;
	}
	
	public static Queue<Student> cutAtGPA(Queue<Student> students, double minGPA){
		LinkedList<Student> newHonors = new LinkedList<Student>();
		for(Student s: students) {
			if(s.GPA >= minGPA) {
				newHonors.add(s);
			}
		}
		return newHonors;
	}
	
}
