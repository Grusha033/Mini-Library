package service.librarian;

import model.book.Book;
import model.user.Customer;

public interface LibrarianService
{
    public void returnBookToTheLibrary(Book book, Customer customer);
    public void returnBookToTheLibrary(String bookName, Customer customer);

    public void giveBookToTheCustomer(Book book, Customer customer);
    public void giveBookToTheCustomer(String bookName, Customer customer);

}
