import java.util.*;

public class Student_Management_System {
    static class Person {
        protected int id;
        protected String name;
        Person(int id, String name) { this.id = id; this.name = name; }
        void display() { System.out.println("ID: " + id + ", Name: " + name); }
    }

    static class Student extends Person {
        private String department;
        private double mark;
        Student(int id, String name, String department, double mark) {
            super(id, name); this.department = department; setMark(mark);
        }
        public void setMark(double mark) {
            if (mark >= 0 && mark <= 100) this.mark = mark;
            else throw new IllegalArgumentException("Mark must be between 0 and 100.");
        }
        public double getMark() { return mark; }
        @Override void display() {
            System.out.println("Student ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Department: " + department);
            System.out.println("Mark: " + mark);
            System.out.println("Grade: " + (mark >= 90 ? "A+" : mark >= 80 ? "A" : mark >= 70 ? "B" : mark >= 60 ? "C" : mark >= 50 ? "D" : "F"));
        }
    }

    static class ResearchStudent extends Student {
        private String researchTopic;
        ResearchStudent(int id, String name, String department, double mark, String researchTopic) {
            super(id, name, department, mark); this.researchTopic = researchTopic;
        }
        @Override void display() { super.display(); System.out.println("Research Topic: " + researchTopic); }
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Arun", "Information Technology", 86);
        Person s2 = new ResearchStudent(102, "Priya", "Computer Science", 92, "Artificial Intelligence");
        System.out.println("=== STUDENT MANAGEMENT SYSTEM ===");
        System.out.println("\nStudent 1:"); s1.display();
        System.out.println("\nStudent 2:"); s2.display();
        System.out.println("\nOOP concepts demonstrated:");
        System.out.println("Class, Object, Constructor, Encapsulation, Inheritance and Polymorphism.");
    }
}