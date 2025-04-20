import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add\n2. Update\n3. Remove\n4. Search\n5. Display All\n6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Salary: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    double salary = sc.nextDouble();
                    employees.add(new Employee(id, name, salary));
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    for (Employee e : employees) {
                        if (e.id == uid) {
                            System.out.print("Enter new Name and Salary: ");
                            e.name = sc.nextLine();
                            e.salary = sc.nextDouble();
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to remove: ");
                    int rid = sc.nextInt();
                    employees.removeIf(e -> e.id == rid);
                    break;

                case 4:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    for (Employee e : employees) {
                        if (e.id == sid) e.display();
                    }
                    break;

                case 5:
                    for (Employee e : employees) e.display();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;
            }

        } while (choice != 6);
    }
}
