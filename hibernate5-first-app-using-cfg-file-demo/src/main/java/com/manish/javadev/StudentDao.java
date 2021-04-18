package com.manish.javadev;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

	public void saveStudent(Student student) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Student getStudents() {
		Transaction transaction = null;
		Student student = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// start a transaction
			System.out.println("=========Going to fetch The data===========");
			transaction = session.beginTransaction();
			// save the student object
			student = session.get(Student.class, 1);
			System.out.println("Done");
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}
}
