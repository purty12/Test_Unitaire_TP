package Bibliothèque;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean isBookAvailable(Book book) {
        return books.contains(book);
    }

    public void borrowBook(Book book, User user) {
        if (isBookAvailable(book)) {
            books.remove(book);
            user.getBorrowedBooks().add(book);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available: " + book.getTitle());
        }
    }
}

