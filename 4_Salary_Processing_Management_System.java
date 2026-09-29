public class Salary_Processing_Management_System {
    static class Employee {
        private int id; private String name; private double basicSalary;
        Employee(int id, String name, double basicSalary) { this.id=id; this.name=name; this.basicSalary=basicSalary; }
        double calculateHRA() { return basicSalary * 0.20; }
        double calculateDA() { return basicSalary * 0.10; }
        double calculatePF() { return basicSalary * 0.12; }
        double calculateGrossSalary() { return basicSalary + calculateHRA() + calculateDA(); }
        double calculateNetSalary() { return calculateGrossSalary() - calculatePF(); }
        void displaySalary() {
            System.out.println("Employee ID : " + id);
            System.out.println("Name        : " + name);
            System.out.printf("Basic Salary: Rs.%.2f%n", basicSalary);
            System.out.printf("HRA (20%%)   : Rs.%.2f%n", calculateHRA());
            System.out.printf("DA (10%%)    : Rs.%.2f%n", calculateDA());
            System.out.printf("Gross Salary: Rs.%.2f%n", calculateGrossSalary());
            System.out.printf("PF (12%%)    : Rs.%.2f%n", calculatePF());
            System.out.printf("Net Salary  : Rs.%.2f%n", calculateNetSalary());
        }
    }
    public static void main(String[] args) {
        Employee employee = new Employee(501, "Kumar", 30000);
        System.out.println("=== SALARY PROCESSING MANAGEMENT SYSTEM ===");
        employee.displaySalary();
    }
}