package hibernate_demo;


import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
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

            //Find out the Student's id: Primary key
            System.out.println("id of Saved Student: " + student.getId());

            // Get a new session and start transaction
            session = factory.getCurrentSession();

            session.beginTransaction();

            // Retrieve student based on id: primary key
            System.out.println("Getting Student with id: " + student.getId());

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Get Complete: " + student);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {

        }
    }
}
