package exercises;

import java.util.LinkedList;
import java.util.Queue;

import exercises.Student;

public class StudentTest {

	public static void main(String args[]) {
		Queue<Student> list = new LinkedList<Student>();
		Student s = new Student("Jared", 1.50); list.add(s);
		s = new Student("Nate", 5.00); list.add(s);
		s = new Student("e", 2.00); list.add(s);
		s = new Student("f", 3.00); list.add(s);
		s = new Student("g", 4.00); list.add(s);
		
		list = Student.cutAtGPA(list, 3.00);
		
		for(Student l : list) {
			System.out.println(l);
		}
	}
}
