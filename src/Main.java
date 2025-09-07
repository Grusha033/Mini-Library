import model.book.Book;
import model.book.BookStatus;
import model.user.Customer;
import service.librarian.Librarian;
import service.librarian.LibrarianService;
import service.library.Library;
import service.library.LibraryService;
import service.logs.Logger;
import service.logs.LoggerService;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        LibraryService libraryService = new Library();
        LoggerService loggerService = new Logger();
        LibrarianService librarianService = new Librarian("Max", libraryService, loggerService);

        Customer customerPudge = new Customer("Pudge");

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Heart of the Dragon", "A. Shadowbane", 2001, BookStatus.BORROWED));
        books.add(new Book("Crown of Ashes", "E. Blackthorn", 2004, BookStatus.BORROWED));
        books.add(new Book("Whispers of the Abyss", "L. Darkmoor", 2007, BookStatus.BORROWED));
        books.add(new Book("The Fallen Kingdom", "R. Nightshade", 2010, BookStatus.BORROWED));
        books.add(new Book("Blade of the Forgotten", "K. Bloodraven", 2013, BookStatus.BORROWED));
        books.add(new Book("Shadow over Eldoria", "M. Stormveil", 2015, BookStatus.BORROWED));
        books.add(new Book("Oath of the Damned", "T. Ravenscar", 2017, BookStatus.BORROWED));
        books.add(new Book("The Serpent’s Grimoire", "D. Blackspire", 2018, BookStatus.BORROWED));
        books.add(new Book("Song of Broken Souls", "F. Duskbane", 2020, BookStatus.BORROWED));
        books.add(new Book("Throne of Eternal Night", "V. Graveborn", 2022, BookStatus.BORROWED));

        for (Book book : books)
            libraryService.addBook(book);

        librarianService.giveBookToTheCustomer("Heart of the Dragon", customerPudge);
        librarianService.giveBookToTheCustomer("Whispers of the Abyss", customerPudge);

        System.out.println(customerPudge.toString());
        System.out.println(libraryService.toString());

        librarianService.returnBookToTheLibrary("Heart of the Dragon", customerPudge);

        System.out.println(customerPudge.toString());
        System.out.println(libraryService.toString());

        loggerService.showActions();
    }
}
