package service.librarian;

import model.book.Book;
import model.user.Customer;
import model.user.User;
import service.library.LibraryService;
import service.logs.LoggerActions;
import service.logs.LoggerService;

public class Librarian extends User implements LibrarianService
{
    private final LibraryService libraryService;
    private final LoggerService loggerService;

    public Librarian(String name, LibraryService libraryService, LoggerService loggerService)
    {
        super(name);
        this.libraryService = libraryService;
        this.loggerService = loggerService;
    }

    @Override
    public void returnBookToTheLibrary(Book book, Customer customer)
    {
        if (book == null || customer == null)
            throw new IllegalArgumentException("[ERROR] book and user cannot be null");

        customer.returnTheBook(book);
        libraryService.addBook(book);

        loggerService.registerAction(LoggerActions.customerReturnBook(customer, this, book));
    }

    @Override
    public void returnBookToTheLibrary(String bookName, Customer customer)
    {
        if (bookName == null || customer == null)
            throw new IllegalArgumentException("[ERROR] book name and user cannot be null");

        returnBookToTheLibrary(findBookByName(bookName), customer);
    }

    @Override
    public void giveBookToTheCustomer(Book book, Customer customer)
    {
        if (book == null || customer == null)
            throw new IllegalArgumentException("[ERROR] book and user cannot be null");

        customer.borrowTheBook(libraryService.takeOutBook(book));

        loggerService.registerAction(LoggerActions.customerTakeBook(customer, this, book));
    }

    @Override
    public void giveBookToTheCustomer(String bookName, Customer customer)
    {
        if (bookName == null || customer == null)
            throw new IllegalArgumentException("[ERROR] book name and user cannot be null");

        Book book = findBookByName(bookName);
        customer.borrowTheBook(libraryService.takeOutBook(book));
        loggerService.registerAction(LoggerActions.customerTakeBook(customer, this, book));
    }

    private Book findBookByName(String bookName)
    {
        Book[] books = libraryService.getBooks().toArray(Book[]::new);
        for (Book book : books)
        {
            if (book.getTitle().equals(bookName))
            {
                return book;
            }
        }

        throw new IllegalArgumentException("[ERROR] Book not found");
    }

    public LibraryService getLibraryService()
    {
        return libraryService;
    }
}
