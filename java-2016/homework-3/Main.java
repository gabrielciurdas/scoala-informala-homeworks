/**
 * The main method for Library Catalog.
 *
 * @author Gabi
 */
public class Main {
    /**
     * The main method in which a new Library Catalog object is created. Books
     * of type Novel and ArtAlbum are also created and added to the list of books.
     * The method to delete books is tested and the list of books is printed.
     * 
     * @param args represents the command line arguments.
     */
    
    public static void main(String args[]) {
        
        LibraryCatalog library = new LibraryCatalog();

        Novel novel = new Novel("Fyodor Dostoyevsky - Brothers Karmazov",
                795, "Drama");
        Novel novel2 = new Novel("Fyodor Dostoyevsky - The Idiot",
                667, "Drama");
       
        ArtAlbum album = new ArtAlbum("Paintings", 260, "High");
        ArtAlbum album2 = new ArtAlbum("Sculpture", 245, "Good");
        
        library.addBook(novel);
        library.addBook(novel2);
        library.addBook(album);
        library.addBook(album2);
        
        library.deleteBook(album2);

        library.listBooks();
    }
}
