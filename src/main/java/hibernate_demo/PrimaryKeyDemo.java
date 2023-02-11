package hibernate_demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        // Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create Session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating 3 Student objects...");
            Student student = new Student("Abdullah", "Bayramov", "abayramov14100@ada.edu.az");
            Student student2 = new Student("Mammad", "Mammadov", "mmammadov14101@ada.edu.az");
            Student student3 = new Student("Turkan", "Hajiyeva", "abayramov14102@ada.edu.az");

            // start a transaction
            session.beginTransaction();

            // save the student
            System.out.println("Saving the Students");
            session.save(student);
            session.save(student2);
            session.save(student3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {

        }
    }
}
