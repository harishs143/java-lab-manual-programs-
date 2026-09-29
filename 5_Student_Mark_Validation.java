import java.util.*;

public class Student_Mark_Validation {
    static void validateMark(double mark) {
        if (mark < 0 || mark > 100) throw new IllegalArgumentException("Invalid mark! Mark must be between 0 and 100.");
        System.out.println("Valid mark: " + mark);
        if (mark >= 90) System.out.println("Grade: A+");
        else if (mark >= 80) System.out.println("Grade: A");
        else if (mark >= 70) System.out.println("Grade: B");
        else if (mark >= 60) System.out.println("Grade: C");
        else if (mark >= 50) System.out.println("Grade: D");
        else System.out.println("Grade: F");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== STUDENT MARK VALIDATION ===");
        System.out.print("Enter student mark (0-100): ");
        try { validateMark(sc.nextDouble()); }
        catch (InputMismatchException e) { System.out.println("Invalid input! Please enter a number."); }
        catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        finally { sc.close(); }
    }
}