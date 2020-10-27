import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String name;

    private double price;

    private BookGenre genre;

    public static Comparator<Book> BookPriceComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            return Double.compare(book1.price, book2.price);
        }
    };

    public static Comparator<Book> BookNameComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.name.compareTo(book2.name);
        }
    };

    public Book(String name, double price, BookGenre genre) {
        this.name = name;
        this.price = price;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + this.name + ", price=" + this.price + ", genre=" + this.genre + '}';
    }

    @Override
    public int compareTo(Book employee) {
        return this.name.compareTo(employee.name);
    }
}
