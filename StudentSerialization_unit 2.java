package Unit2;

import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    float marks;

    public Student(int id, String name, float marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentSerialization {
    public static void main(String[] args) {
        try {
            // Serialization
            Student s1 = new Student(101, "Amit", 89.5f);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"));
            out.writeObject(s1);
            out.close();
            System.out.println("Student serialized.");

            // Deserialization
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"));
            Student s2 = (Student) in.readObject();
            in.close();
            System.out.println("Deserialized Student:");
            s2.display();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
