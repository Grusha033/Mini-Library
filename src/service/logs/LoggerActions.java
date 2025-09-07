package service.logs;

import model.book.Book;
import model.user.User;

public class LoggerActions
{
    public static String customerTakeBook(User customer, User librarian, Book book) {
        return "Customer [" + customer.getName() + "] borrowed the book \""
                + book.getTitle() + "\" | Processed by librarian [" + librarian.getName() + "]";
    }

    public static String customerReturnBook(User customer, User librarian, Book book) {
        return "Customer [" + customer.getName() + "] returned the book \""
                + book.getTitle() + "\" | Processed by librarian [" + librarian.getName() + "]";
    }
}
