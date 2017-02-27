package ro.siit.java5;

/**
 * Created by Gabi on 2/20/2017.
 */
public class RoomFair {
    private int id;
    private double value;
    private Season season;

    public RoomFair() {
        id = 0;
        value = 0;
        season = Season.SPRING;
    }

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
