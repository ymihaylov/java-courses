import java.util.*;

public class Bookstore {
    private String address;

    private int area;

    private List<Book> bookList;

    public Bookstore(String address, int area) {
        this.address = address;
        this.area = area;
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void removeBook(Book book) {
        if (!this.bookList.contains(book)) {
            System.out.println("This bookstore does not have the book "+ book +" available\n");
            return;
        }

        bookList.remove(book);
    }

    public void displayBookListReversed() {
        if (bookList.isEmpty()) {
            System.out.println("There are no books available in this bookstore!");
            return;
        }

        ListIterator<Book> listIterator = bookList.listIterator(bookList.size());

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous() + " ");
        }
    }

    public Book getMostExpensiveBookInTheStore() {
        return Collections.max(this.bookList, Book.BookPriceComparator);
    }

    public void sortBookListByPrice() {
        Collections.sort(this.bookList, Book.BookPriceComparator);
    }

    public void sortBookListByNameReversed() {
        Collections.sort(this.bookList, Book.BookNameComparator.reversed());
    }

    public void sortBookListByPriceAndByName() {
        Collections.sort(
            this.bookList,
            Book.BookPriceComparator
                .thenComparing(Book.BookNameComparator.reversed())
        );
    }

    public Book getLastBookFromSortedByNameList() {
        List<Book> sortedBookList = new ArrayList<Book>(this.bookList);
        sortedBookList.sort(Book.BookNameComparator.reversed());

        return sortedBookList.get(sortedBookList.size() - 1);
    }
}
