package Unit3.Experiment3.2;

@Configuration
public class AppConfig {
    @Bean
    public Course course() {
        return new Course("Mathematics");
    }

    @Bean
    public Student student() {
        return new Student(course());
    }
}

