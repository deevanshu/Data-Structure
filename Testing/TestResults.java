package Testing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestResults
{
    public static class Student {
        private String name;
        private int score;
        
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public int getScore() {
            return score;
        }
        
        public String getName() {
            return name;
        }
    }
    
    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
     //   throw new UnsupportedOperationException("Waiting to be implemented.");
        
        List<Student> result = students.filter(s->s.getScore()>=passingScore).collect(Collectors.toList());
        
        result.stream().forEach(System.out::println);
        
        List<String> names = result.stream().map(student -> student.getName()).collect(Collectors.toList());
        
        return names;
    }
    
    public static void main(String[] args) {
        
        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mike", 80));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        
        studentsThatPass(students.stream(), 50).forEach(System.out::println);        
    }
}
