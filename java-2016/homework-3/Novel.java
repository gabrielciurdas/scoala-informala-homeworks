/**
 * This class represents a Novel which has a name, number of pages and a type.
 * 
 * @see Book
 * @author Gabriel Ciurdas
 * Date: 10/11/2016
 */
public class Novel extends Book {

    private String novelType;
    
    /**
     * The constructor for a Novel object.
     * 
     * @param name is the name of a Novel object.
     * @param pages is the number of pages of a Novel object.
     * @param novelType is the Novel's novelType.
     */
    public Novel(String name, int numberOfPages, String novelType) {
        super(name, numberOfPages);
        this.novelType = novelType;
    }

    /**
     * Gets the type of the Novel object.
     * 
     * @return the type of the novel.
     */
    public String getNovelType() {
        return novelType;
    }

    /**
     * Inherited method from Object class which returns an object's fields.
     * 
     * @return the name, number of pages and the type of the novel object.
     */
    @Override
    public String toString() {
        return "Novel: " + getName() + ", pages = " + getNumberOfPages()
                + ", Type = " + getNovelType();
    }
}
