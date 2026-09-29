import java.io.*;

public class Student_Record_File_Writer_Reader {
    public static void main(String[] args) {
        String fileName = "student_records.txt";
        System.out.println("=== STUDENT RECORD USING FILE WRITER & FILE READER ===");

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("101, Arun, Information Technology, 86\n");
            writer.write("102, Priya, Computer Science, 92\n");
            writer.write("103, Kumar, Electronics, 78\n");
            System.out.println("Student records written successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing: " + e.getMessage());
            return;
        }

        System.out.println("\nReading student records:");
        try (FileReader reader = new FileReader(fileName)) {
            int character;
            while ((character = reader.read()) != -1) System.out.print((char) character);
        } catch (IOException e) { System.out.println("Error while reading: " + e.getMessage()); }
    }
}