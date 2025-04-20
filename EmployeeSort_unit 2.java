package Unit2;

// Experiment 2.3 - a. Sort Employee List using Lambda
import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    void display() {
        System.out.println(name + " | Age: " + age + " | Salary: " + salary);
    }
}

public class EmployeeSort {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(
            new Employee("John", 28, 50000),
            new Employee("Asha", 32, 65000),
            new Employee("Zack", 25, 48000),
            new Employee("Mira", 30, 60000)
        );

        empList.sort((e1, e2) -> e1.name.compareTo(e2.name)); // sort by name

        System.out.println("Sorted Employees by Name:");
        empList.forEach(Employee::display);
    }
}

// Experiment 2.3 - b. Filter and Sort Students using Stream API
class Student {
    String name;
    double percentage;

    Student(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }
}

class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ravi", 85),
            new Student("Anita", 72),
            new Student("Kiran", 91),
            new Student("Lata", 65),
            new Student("Ajay", 78)
        );

        System.out.println("Students scoring above 75% sorted by marks:");
        students.stream()
                .filter(s -> s.percentage > 75)
                .sorted((s1, s2) -> Double.compare(s2.percentage, s1.percentage))
                .map(s -> s.name + " - " + s.percentage + "%")
                .forEach(System.out::println);
    }
}
