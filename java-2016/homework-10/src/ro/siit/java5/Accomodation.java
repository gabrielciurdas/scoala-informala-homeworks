package ro.siit.java5;

/**
 * Created by Gabi on 2/20/2017.
 */
public class Accomodation {
    private int id;
    private RoomType type;
    private BedType bedType;
    private int maxGuests;
    private String description;

    public Accomodation() {
        id = 0;
        type = RoomType.SINGLE;
        bedType = BedType.SINGLE;
        maxGuests = 1;
        description = "";
    }

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
