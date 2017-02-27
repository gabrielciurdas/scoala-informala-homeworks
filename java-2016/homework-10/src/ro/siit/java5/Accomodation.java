package ro.siit.java5;

/**
 * This class simulates an accomodation.
 *
 * @see RoomType
 * @see BedType
 * <p>
 * Created by Gabriel Ciurdas on 2/20/2017.
 */
public class Accomodation {
    private int id;
    private RoomType type;
    private BedType bedType;
    private int maxGuests;
    private String description;

    /**
     * A default constructor for an Accomodation object.
     */
    public Accomodation() {
        id = 0;
        type = RoomType.SINGLE;
        bedType = BedType.SINGLE;
        maxGuests = 1;
        description = "";
    }

    /**
     * A constructor with four parameters for an Accomodation object.
     *
     * @param type        is the type of the room which is a constant from RoomType enum.
     * @param bedType     is the type of the bed which is a constant from BedType enum.
     * @param maxGuests   is the maximum number of guests allowed this type of room.
     * @param description is a description of the accomodation.
     */
    public Accomodation(RoomType type, BedType bedType, int maxGuests, String description) {
        this.type = type;
        this.bedType = bedType;
        this.maxGuests = maxGuests;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public RoomType getType() {
        return type;
    }

    public BedType getBedType() {
        return bedType;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type.valueOf(type);
    }

    public void setBedType(String bedType) {
        this.bedType.valueOf(bedType);
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
