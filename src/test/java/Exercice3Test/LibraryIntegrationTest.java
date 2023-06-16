package Exercice3Test;

import Bibliothèque.Book;
import Bibliothèque.Library;
import Bibliothèque.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibraryIntegrationTest {

    @Test
    public void testBorrowBook() {
        Library library = new Library();

        Book book = new Book("Title 1", "Author 1");
        library.addBook(book);

        User user = new User("John Doe");

        library.borrowBook(book, user);

        Assertions.assertTrue(user.getBorrowedBooks().contains(book));
        Assertions.assertFalse(library.isBookAvailable(book));
    }
}

