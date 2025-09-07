package model.book;

public class Book
{
    private final String title;
    private final String author;
    private final int year;

    private BookStatus status;

    public Book(String title, String author, int year, BookStatus status)
    {
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "model.book.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", status=" + status +
                '}';
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getYear()
    {
        return year;
    }

    public BookStatus getStatus()
    {
        return status;
    }

    public void setStatus(BookStatus status)
    {
        this.status = status;
    }
}
