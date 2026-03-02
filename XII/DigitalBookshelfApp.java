import java.util.*;

class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private boolean isAvailable;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        String status = isAvailable ? "[Available]" : "[Checked Out]";
        return String.format("%-10s | %-20s | %-15s | %s", isbn, title, author, status);
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        System.out.println("\n--- Current Inventory ---");
        System.out.printf("%-10s | %-20s | %-15s | %s%n", "ISBN", "Title", "Author", "Status");
        System.out.println("------------------------------------------------------------------");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void borrowBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (b.isAvailable()) {
                    b.setAvailable(false);
                    System.out.println("Success! You have borrowed '" + b.getTitle() + "'.");
                } else {
                    System.out.println("Sorry, this book is currently checked out.");
                }
                return;
            }
        }
        System.out.println("Error: ISBN " + isbn + " not found in system.");
    }

    public void returnBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                b.setAvailable(true);
                System.out.println("Success! '" + b.getTitle() + "' has been returned.");
                return;
            }
        }
        System.out.println("Error: ISBN not recognized.");
    }
}

public class DigitalBookshelfApp {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        try (Scanner input = new Scanner(System.in)) {
            myLibrary.addBook(new Book("978-01", "The Great Gatsby", "F. Scott Fitzgerald"));
            myLibrary.addBook(new Book("978-02", "1984", "George Orwell"));
            myLibrary.addBook(new Book("978-03", "The Hobbit", "J.R.R. Tolkien"));
            
            boolean exit = false;
            
            System.out.println("Welcome to the Digital Bookshelf System");
            
            while (!exit) {
                System.out.println("\nMain Menu:");
                System.out.println("1. View All Books");
                System.out.println("2. Borrow a Book");
                System.out.println("3. Return a Book");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                
                String choice = input.nextLine();
                
                switch (choice) {
                    case "1" -> myLibrary.displayAllBooks();
                    case "2" -> {
                        System.out.print("Enter ISBN to borrow: ");
                        String bIsbn = input.nextLine();
                        myLibrary.borrowBook(bIsbn);
                    }
                    case "3" -> {
                        System.out.print("Enter ISBN to return: ");
                        String rIsbn = input.nextLine();
                        myLibrary.returnBook(rIsbn);
                    }
                    case "4" -> {
                        System.out.println("System shutting down. Happy reading!");
                        exit = true;
                    }
                    default -> System.out.println("Invalid selection. Please try again.");
                }
            }
        }
    }
}