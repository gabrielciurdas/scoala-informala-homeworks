/**
 * This class represents an ArtAlbum which has a name, number of pages and quality.
 * 
 * @see Book
 * @author Gabriel Ciurdas
 * <p> Date: 10/11/2016
 */
public class ArtAlbum extends Book {

    private String paperQuality;
    
    /**
     * The constructor for an Album object.
     * 
     * @param name is the name of an Album object.
     * @param numberOfPages is the number of pages of an Album object.
     * @param paperQuality is the paperQuality of the Album.
     */
    public ArtAlbum(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }
    
    /**
     * Gets the quality of an ArtAlbum object.
     * 
     * @return the quality the album.
     */
    public String getPaperQuality() {
        return paperQuality;
    }

    /**
     * Inherited method from Object class which returns an object's fields.
     * 
     * @return the name, number of pages and the quality of the album object.
     */
    @Override
    public String toString() {
        return "Art Album: " + getName() + ", pages = " + getNumberOfPages()
                + ", paper quality = " + getPaperQuality();
    }
}
