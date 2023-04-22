import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookDatabase bookDatabase = new BookDatabase();
        bookDatabase.addBook(new Book("Book 1", "Author 1", "Publisher 1", 20.0));
        bookDatabase.addBook(new Book("Book 2", "Author 2", "Publisher 2", 25.0));
        bookDatabase.addBook(new Book("Book 3", "Author 1", "Publisher 3", 18.0));
        bookDatabase.addBook(new Book("Book 4", "Author 3", "Publisher 1", 30.0));

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nBook Database Menu:");
            System.out.println("1. List books sorted by price");
            System.out.println("2. Find books by author");
            System.out.println("3. Filter books by price");
            System.out.println("4. Search books by title");
            System.out.println("5. Find books by publisher");
            System.out.println("6. Update publisher by book title");
            System.out.println("0. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (option) {
                case 1:
                    List<Book> sortedByPrice = bookDatabase.sortByPrice();
                    System.out.println("Books sorted by price: " + sortedByPrice);
                    break;
                case 2:
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    List<Book> booksByAuthor = bookDatabase.findByAuthor(author);
                    System.out.println("Books by " + author + ": " + booksByAuthor);
                    break;
                case 3:
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    List<Book> booksAbovePrice = bookDatabase.filterByPrice(minPrice);
                    System.out.println("Books above price " + minPrice + ": " + booksAbovePrice);
                    break;
                case 4:
                    System.out.print("Enter title keyword: ");
                    String title = scanner.nextLine();
                    List<Book> booksByTitle = bookDatabase.searchByTitle(title);
                    System.out.println("Books with '" + title + "' in the title: " + booksByTitle);
                    break;
                case 5:
                    System.out.print("Enter publisher name: ");
                    String publisher = scanner.nextLine();
                    List<Book> booksByPublisher = bookDatabase.findByPublisher(publisher);
                    System.out.println("Books published by " + publisher + ": " + booksByPublisher);
                    break;
                case 6:
                    System.out.print("Enter book title to update publisher: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter new publisher: ");
                    String newPublisher = scanner.nextLine();
                    bookDatabase.updatePublisherByTitle(bookTitle, newPublisher);
                    System.out.println("Updated publisher for '" + bookTitle + "'");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }
}
