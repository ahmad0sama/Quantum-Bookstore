package store;

import book.Book;

import java.util.*;

public class Inventory {
    private final Map<String, Book> books = new HashMap<>();


    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public List<Book> removeOutdatedBooks(int maxYearsOld) {
        int currentYear = java.time.Year.now().getValue();
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator();
        while (it.hasNext()) {
            Book book = it.next().getValue();
            if (currentYear - book.getYear() > maxYearsOld) {
                removed.add(book);
                it.remove();
            }
        }
        return removed;
    }
}
