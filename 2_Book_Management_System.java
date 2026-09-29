import java.util.*;

public class Book_Management_System {
    static class Book {
        private int bookId;
        private String title;
        private String author;
        Book(int bookId, String title, String author) { this.bookId = bookId; this.title = title; this.author = author; }
        int getBookId() { return bookId; }
        void display() { System.out.println(bookId + " | " + title + " | " + author); }
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(101, "Java Programming", "James"));
        books.add(new Book(102, "Data Structures", "Mark"));
        books.add(new Book(103, "Database Systems", "Robert"));

        System.out.println("=== BOOK MANAGEMENT SYSTEM ===");
        System.out.println("\nBooks after CREATE:");
        for (Book book : books) book.display();

        HashMap<Integer, Book> bookMap = new HashMap<>();
        for (Book book : books) bookMap.put(book.getBookId(), book);

        System.out.println("\nREAD: Searching for Book ID 102");
        Book found = bookMap.get(102);
        if (found != null) found.display();

        System.out.println("\nUPDATE: Replacing Book ID 103");
        Book updated = new Book(103, "Advanced Java", "Kathy");
        bookMap.put(103, updated);
        books.set(2, updated);

        System.out.println("DELETE: Removing Book ID 101");
        bookMap.remove(101);
        books.removeIf(book -> book.getBookId() == 101);

        System.out.println("\nFinal book list:");
        for (Book book : books) book.display();
        System.out.println("\nCRUD operations completed using ArrayList and HashMap.");
    }
}