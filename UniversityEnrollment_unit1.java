import java.util.Scanner;

class Student {
    String name;
    int age;
    String course;

    Student(String name, int age, String course) {
        if (age < 17 || age > 30) {
            throw new IllegalArgumentException("Invalid age for university enrollment.");
        }
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.println("Student Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

public class UniversityEnrollment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter course: ");
            String course = sc.nextLine();

            Student s = new Student(name, age, course);
            s.display();
        } catch (Exception e) {
            System.out.println("Enrollment Failed: " + e.getMessage());
        }
    }
}
