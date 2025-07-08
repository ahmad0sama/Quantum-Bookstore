package book;

public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, String author, int year, double price) {
        super(isbn, title, author, year, price);
    }

    public boolean isPurchasable() {
        return false;
    }
}
