import book.EBook;
import book.PaperBook;
import book.ShowcaseBook;
import service.BookstoreService;
import service.MailService;
import service.ShippingService;
import store.Inventory;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        // Initialize services
        Inventory inventory = new Inventory();
        ShippingService shippingService = new ShippingService();
        MailService mailService = new MailService();
        BookstoreService service = new BookstoreService(inventory, shippingService, mailService);

        // Test adding books
        service.addBook(new PaperBook("001", "Clean Code", "Robert C. Martin", 2008, 400.0, 10, 1.2));
        service.addBook(new EBook("002", "Effective Java", "Joshua Bloch", 2017, 300.0, "PDF"));
        service.addBook(new ShowcaseBook("003", "ahmed osama", "Unknown", 1900, 0.0));
        System.out.println("================================================================");

        // Test purchasing
        try {
            double amount = service.buyBook("001", 2, "user@example.com", "fawry Main St");
            System.out.println("Quantum book store: Paid amount: $" + amount);
            System.out.println("================================================================");

            amount = service.buyBook("002", 1, "user@example.com", "fawry Main St");
            System.out.println("Quantum book store: Paid amount: EGP" + amount);
            System.out.println("================================================================");


            amount = service.buyBook("456", 1, "user@example.com", "fawry Main St");
            System.out.println("Quantum book store: Paid amount: EGP" + amount);
            System.out.println("================================================================");

        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
            System.out.println("================================================================");
        }

        // Test removing outdated books
        service.removeOutdatedBooks(10); // Remove books older than 10 years


    }
}
