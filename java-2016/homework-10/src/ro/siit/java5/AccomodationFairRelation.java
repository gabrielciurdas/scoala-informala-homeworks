package ro.siit.java5;

/**
 * This class maps an accomodation to a room fair.
 *
 * <p>
 * Created by Gabriel Ciurdas on 2/25/2017.
 */
public class AccomodationFairRelation {
    private int id;
    private int accomodationId;
    private int roomFairId;

    /**
     * A default constructor for an AccomodationFairRelation object.
     */
    public AccomodationFairRelation() {
        id = 0;
        accomodationId = 0;
        roomFairId = 0;
    }

    /**
     * A constructor with two parameters for an AccomodationFairRelation object.
     *
     * @param accomodationId is the id of the accomodation.
     * @param roomFairId     is the id of the room fair.
     */
    public AccomodationFairRelation(int accomodationId, int roomFairId) {
        this.accomodationId = accomodationId;
        this.roomFairId = roomFairId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccomodationId() {
        return accomodationId;
    }

    public void setAccomodationId(int accomodationId) {
        this.accomodationId = accomodationId;
    }

    public int getRoomFairId() {
        return roomFairId;
    }

    public void setRoomFairId(int roomFairId) {
        this.roomFairId = roomFairId;
    }
}
