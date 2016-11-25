/**
 * This class  represents an abstract Book which contains a name and number
 of numberOfPages.
 * 
 * @author Gabriel Ciurdas
 * Date: 10/11/2016
 */
public abstract class Book {

    private String name;
    private int numberOfPages;
    
    /**
     * The constructor for a Book object.
     * 
     * @param name is the name of the Book object.
     * @param numberOfPages is the number of numberOfPages of the Book object.
     */
    public Book(String name, int numberOfPages) {
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    /**
     * Gets the name of the Book object.
     * 
     * @return the name of the Book object.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of pages of the Book object.
     * 
     * @return the number of pages of the Book object.
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }
}
