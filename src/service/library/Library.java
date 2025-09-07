package service.library;

import model.book.Book;
import model.book.BookStatus;

import java.util.ArrayList;

public class Library implements LibraryService
{
    private static int totalBooks = 0;
    private final ArrayList<Book> bookShelf = new ArrayList<>();

    @Override
    public void addBook(Book book)
    {
        if (book != null)
        {
            if (!bookShelf.contains(book))
            {
                bookShelf.add(book);
                totalBooks++;
            }

            book.setStatus(BookStatus.AVAILABLE);
        }
        else
            throw new IllegalArgumentException("[ERROR] Book is null");
    }

    @Override
    public Book takeOutBook(Book book)
    {
        byte nullIndex = -1;

        if (book == null)
            throw new IllegalArgumentException("[ERROR] Book is null");

        int index = bookShelf.indexOf(book);
        if (index == nullIndex)
            throw new IllegalArgumentException("[ERROR] Book not found in library");

        Book foundBook = bookShelf.get(index);
        if (foundBook.getStatus() == BookStatus.BORROWED)
            throw new IllegalStateException("[ERROR] Book is already checked out");

        foundBook.setStatus(BookStatus.BORROWED);
        return foundBook;
    }

    @Override
    public ArrayList<Book> getBooks()
    {
        return new ArrayList<Book>(bookShelf);
    }

    @Override
    public String toString()
    {
        return "Library [Total books: " + totalBooks + "] {" +
                "bookShelf=" + bookShelf +
                '}';
    }
}
