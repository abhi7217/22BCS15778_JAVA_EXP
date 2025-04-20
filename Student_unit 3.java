package Unit3.Experiment3.2;

public class Student {
    private Course course;
    public Student(Course course) {
        this.course = course;
    }
    public void displayCourse() {
        System.out.println("Enrolled in: " + course.getName());
    }
}