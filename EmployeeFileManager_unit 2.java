package Unit2;

import java.io.*;
import java.util.*;

class Emp implements Serializable {
    int id;
    String name, designation;
    double salary;

    Emp(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary);
    }
}

public class EmployeeFileManager {
    static final String FILE_NAME = "employees.dat";

    public static void addEmployee() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID, Name, Designation, Salary: ");
        int id = sc.nextInt();
        sc.nextLine(); // flush newline
        String name = sc.nextLine();
        String designation = sc.nextLine();
        double salary = sc.nextDouble();

        Emp emp = new Emp(id, name, designation, salary);

        FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
        ObjectOutputStream oos;
        if (new File(FILE_NAME).length() == 0) {
            oos = new ObjectOutputStream(fos);
        } else {
            oos = new AppendableObjectOutputStream(fos);
        }
        oos.writeObject(emp);
        oos.close();
    }

    public static void displayAll() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
        while (true) {
            try {
                Emp emp = (Emp) ois.readObject();
                emp.display();
            } catch (EOFException e) {
                break;
            }
        }
        ois.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add an Employee\n2. Display All\n3. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 3);
    }
}

// Needed to avoid writing new headers while appending objects
class AppendableObjectOutputStream extends ObjectOutputStream {
    AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException {
        reset(); // don't write a new header
    }
}
