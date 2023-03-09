package hibernate_demo;


import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        // Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create Session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 2;

            // Get a new session and start transaction
            session = factory.getCurrentSession();

            session.beginTransaction();

            // Retrieve student based on id: primary key
            System.out.println("Getting Student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Deleting Student...");

            session.delete(myStudent);

            // Commit the transaction
            session.getTransaction().commit();

            // Second way to delete from database
            session = factory.getCurrentSession();

            session.beginTransaction();

            session.createQuery("delete from Student where id = 3").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {

        }
    }
}
