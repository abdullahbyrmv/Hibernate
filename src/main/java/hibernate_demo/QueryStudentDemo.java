package hibernate_demo;


import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create Session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // Query students
            List<Student> students = session.createQuery("from Student").getResultList();

            //display the students
            System.out.println("\n\nDisplaying all Students: ");
            displayStudents(students);

            System.out.println();

            // query students: lastname='Bayramov'
            students = session.createQuery("from Student s where s.lastName='Bayramov'").getResultList();


            //Display students with lastname='Bayramov'
            System.out.println("\n\nDisplaying Students who have last name of Bayramov: ");
            displayStudents(students);

            System.out.println();

            // query students : lastname='Bayramov' or firstname='Abdullah'
            students = session.createQuery("from Student s where s.lastName='Yusifov' or s.firstName='Abdullah'").getResultList();


            // Display students with lastname='Yusifov' or firstname='Abdullah'
            System.out.println("\n\nDisplaying Students who have last name of Yusifov or first name of Abdullah: ");
            displayStudents(students);

            System.out.println();

            // query students where email like '%ada.edu.az'
            students = session.createQuery("from Student s where s.email like '%ada.edu.az'").getResultList();

            // Display students with email like '%ada.edu.az'
            System.out.println("\n\nDisplaying Students who have email like '%ada.edu.az': ");
            displayStudents(students);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("\n\nDone");
        } finally {

        }
    }

    public static void displayStudents(List<Student> students) {
        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }
    }
}
