package Unit3.Experiment3.2;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;
    private String name;
    private String department;
    private double marks;
}

public class StudentDAO {
    private SessionFactory sessionFactory;

    public StudentDAO() {
        sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
    }

    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    // Add methods for read, update, delete
}
