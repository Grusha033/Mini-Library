package service.library;

import model.book.Book;

import java.util.ArrayList;

public interface LibraryService
{
    public void addBook(Book book);

    public Book takeOutBook(Book book);

    public ArrayList<Book> getBooks();

    @Override
    public String toString();
}
