package book;

import service.ShippingService;

public class PaperBook extends Book implements Shippable {
    private int stock;
    private double weight;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock, double weight) {
        super(isbn, title, author, year, price);
        this.stock = stock;
        this.weight = weight;
    }

    public int getStock() { return stock; }

    public boolean isPurchasable() { return stock > 0; }

    public void reduceStock(int quantity) throws Exception {
        if (stock < quantity) throw new Exception("Not enough stock");
        stock -= quantity;
    }

    public void shipTo(String address) {
        ShippingService.send(this, address);
    }
}
