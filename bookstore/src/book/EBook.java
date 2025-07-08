package book;

import service.MailService;

public class EBook extends Book implements Emailable {
    private String fileType;

    public EBook(String isbn, String title, String author, int year, double price, String fileType) {
        super(isbn, title, author, year, price);
        this.fileType = fileType;
    }

    public boolean isPurchasable() { return true; }

    public void emailTo(String email) {
        MailService.send(this, email);
    }
}
