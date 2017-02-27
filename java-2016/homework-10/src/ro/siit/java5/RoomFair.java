package ro.siit.java5;

/**
 * This class stores the value for a room fair.
 *
 * @see Season
 * <p>
 * Created by Gabriel Ciurdas on 2/20/2017.
 */
public class RoomFair {
    private int id;
    private double value;
    private Season season;

    /**
     * A default constructor for a RoomFair object.
     */
    public RoomFair() {
        id = 0;
        value = 0;
        season = Season.SPRING;
    }

    /**
     * A constructor with two parameters for a RoomFair object.
     *
     * @param value  is the room price.
     * @param season is the corresponding season for the room price.
     */
    public RoomFair(double value, Season season) {
        this.value = value;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season.valueOf(season);
    }
}
