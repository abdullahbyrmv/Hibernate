package hibernate_demo;


import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
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

            System.out.println("Updating Student...");
            myStudent.setFirstName("Mammad");

            // Commit the transaction
            session.getTransaction().commit();

            //New Code
            session = factory.getCurrentSession();

            session.beginTransaction();

            //Update email for all students
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {

        }
    }
}
