abstract class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void displayDetails();
}

class Student extends Person {
    int rollNumber;

    Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }

    void displayDetails() {
        System.out.println("Student Name: " + name + ", Age: " + age + ", Roll No: " + rollNumber);
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayDetails() {
        System.out.println("Teacher Name: " + name + ", Age: " + age + ", Subject: " + subject);
    }
}

public class StudentInfoSystem {
    public static void main(String[] args) {
        Student s = new Student("Riya", 20, 101);
        Teacher t = new Teacher("Dr. Sharma", 45, "Mathematics");

        s.displayDetails();
        t.displayDetails();
    }
}
