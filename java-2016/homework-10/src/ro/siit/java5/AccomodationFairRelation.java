package ro.siit.java5;

/**
 * Created by Gabi on 2/25/2017.
 */
public class AccomodationFairRelation {
    private int id;
    private int accomodationId;
    private int roomFairId;

    public AccomodationFairRelation() {
        id = 0;
        accomodationId = 0;
        roomFairId = 0;
    }

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
