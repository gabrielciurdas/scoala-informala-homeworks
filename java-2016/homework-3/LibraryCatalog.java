import java.util.ArrayList;

/**
 * This class simulates a Library Catalog. It contains a list of books which are
 * of two kinds: novels and albums. It can add books, delete and print books 
 * from the list.
 * 
 * @author Gabriel Ciurdas
 * Date: 10/11/2016
 */
public class LibraryCatalog {

    private ArrayList<Book> books = new ArrayList<>();
    
    /**
     * Adds a Book object to the list of books.
     * 
     * @param book is the book to be added to the list.
     */
    public void addBook(Book book) {
        books.add(book);
    }
    
    /**
     * Removes the Book object from the list of books.
     * 
     * @param book is the book to be deleted from the list.
     */
    public void deleteBook(Book book) {
        books.remove(book);
    }
    
    /**
     * Lists all the books objects the list of books contains.
     */
    public void listBooks() {
        for (Book b : books) {
            System.out.println(b.toString());
        }
    }
}
