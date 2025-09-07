package model.user;

import model.book.Book;

import java.util.ArrayList;

public class Customer extends User
{
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Customer(String name)
    {
        super(name);
    }

    public void borrowTheBook(Book book)
    {
        borrowedBooks.add(book);
    }

    public void returnTheBook(Book book)
    {
        if (borrowedBooks.contains(book))
            borrowedBooks.remove(book);
        else
            throw new IllegalArgumentException("[ERROR] User dont borrowed this book");
    }

    public ArrayList<Book> getBorrowedBooks()
    {
        return borrowedBooks;
    }

    @Override
    public String toString()
    {
        return "Customer{" +
                "borrowedBooks=" + borrowedBooks +
                ", name='" + name + '\'' +
                '}';
    }
}
