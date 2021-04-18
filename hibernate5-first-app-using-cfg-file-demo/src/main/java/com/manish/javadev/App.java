package com.manish.javadev;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = new Student("Manish", "Srivastava", "manish@gmail.com");
		studentDao.saveStudent(student);

		Student students = studentDao.getStudents();
		System.out.println(students);
		System.out.println("DOne");
	}
}
