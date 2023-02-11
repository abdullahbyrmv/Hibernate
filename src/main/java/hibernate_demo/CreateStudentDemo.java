package hibernate_demo;


import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
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
            System.out.println("Creating new Student object...");
            Student student = new Student("Abdullah", "Bayramov", "abayramov14100@ada.edu.az");

            // start a transaction
            session.beginTransaction();

            // save the student
            System.out.println("Saving the Student");
            session.save(student);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {

        }
    }
}
