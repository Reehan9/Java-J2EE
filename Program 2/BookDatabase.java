import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class BookDatabase {
 private List<Book> books;

 public BookDatabase() {
     books = new ArrayList<>();
 }

 public void addBook(Book book) {
     books.add(book);
 }

 public List<Book> getBooks() {
     return books;
 }

 public List<Book> sortByPrice() {
     return books.stream()
             .sorted(Comparator.comparing(Book::getPrice))
             .collect(Collectors.toList());
 }

 public List<Book> findByAuthor(String author) {
     return books.stream()
             .filter(book -> book.getAuthor().equalsIgnoreCase(author))
             .collect(Collectors.toList());
 }

 public List<Book> filterByPrice(double minPrice) {
     return books.stream()
             .filter(book -> book.getPrice() > minPrice)
             .collect(Collectors.toList());
 }

 public List<Book> searchByTitle(String query) {
     return books.stream()
             .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()))
             .collect(Collectors.toList());
 }

 public List<Book> findByPublisher(String publisher) {
     return books.stream()
             .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
             .collect(Collectors.toList());
 }

 public void updatePublisherByTitle(String title, String newPublisher) {
     books.stream()
             .filter(book -> book.getTitle().equalsIgnoreCase(title))
             .forEach(book -> book.setPublisher(newPublisher));
 }
}