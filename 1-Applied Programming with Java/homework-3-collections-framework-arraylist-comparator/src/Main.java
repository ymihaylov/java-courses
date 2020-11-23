public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Agent", 9.90, BookGenre.ROMANCE);
        Book book2 = new Book("B Humor", 5.50, BookGenre.SHORT_NOVEL);
        Book book3 = new Book("A Humor", 5.50, BookGenre.SHORT_NOVEL);
        Book book4 = new Book("Lord of the rings", 100, BookGenre.COLLECTION_OF_POEMS);

        Bookstore orange = new Bookstore("Orange", 460);
        orange.addBook(book1);
        orange.addBook(book2);
        orange.addBook(book3);
        orange.addBook(book4);

//        orange.removeBook(book1);

        orange.displayBookListReversed();
        orange.sortBookListByPrice();
        orange.sortBookListByNameReversed();
        orange.sortBookListByPriceAndByName();

        Book mostExpensiveBookInOrangeStore = orange.getMostExpensiveBookInTheStore();

        Book lastBookFromSortedByName = orange.getLastBookFromSortedByNameList();
    }
}
