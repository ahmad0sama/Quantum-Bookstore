package service;

import book.PaperBook;

public class ShippingService {
    public static void send(PaperBook book, String address) {
        System.out.println("Quantum book store: Shipping '" + book.getTitle() + "' to " + address);
    }
}
