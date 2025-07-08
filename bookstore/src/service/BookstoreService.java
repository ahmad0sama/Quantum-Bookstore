package service;

import book.EBook;
import book.PaperBook;
import store.Inventory;
import book.Book;

import java.util.List;

public class BookstoreService {
    private final Inventory inventory;
    private final ShippingService shippingService;
    private final MailService mailService;

    public BookstoreService(Inventory inventory,
                            ShippingService shippingService,
                            MailService mailService) {
        this.inventory = inventory;
        this.shippingService = shippingService;
        this.mailService = mailService;
    }

    public void addBook(Book book) {
        System.out.println("Quantum book store: Adding book " + book.getTitle());
        inventory.addBook(book);
    }

    public void removeOutdatedBooks(int yearsThreshold) {
        System.out.println("Quantum book store: Removing books older than " + yearsThreshold + " years");
        List<Book> removed = inventory.removeOutdatedBooks(yearsThreshold);

        if (removed.isEmpty()) {
            System.out.println("Quantum book store: No outdated books were removed.");
        } else {
            for (Book book : removed) {
                System.out.printf("Quantum book store: Removed '%s' by %s (Published: %d)%n",
                        book.getTitle(), book.getAuthor(), book.getYear());
            }
        }

    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = inventory.getBook(isbn);
        if (book == null) throw new Exception("Quantum book store: Book not found");
        if (!book.isPurchasable()) throw new Exception("Quantum book store: Book is not for sale");

        double total = book.getPrice() * quantity;

        if (book instanceof PaperBook) {
            PaperBook pb = (PaperBook) book;
            pb.reduceStock(quantity);
            pb.shipTo(address);
        } else if (book instanceof EBook) {
            EBook eb = (EBook) book;
            eb.emailTo(email);
        } else {
            throw new Exception("Quantum book store: Cannot purchase this type of book");
        }

        return total;
    }

}
