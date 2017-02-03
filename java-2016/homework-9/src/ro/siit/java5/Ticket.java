package ro.siit.java5;

/**
 * Created by Gabi on 2/3/2017.
 */
public enum Ticket {
    FULL(0),
    FREE(1),
    FULL_VIP(2),
    FREE_PAS(3),
    ONE_DAY(4),
    ONE_DAY_VIP(5);

    int number = 0;

     Ticket(int number) {
        this.number = number;
    }

   /* public String getType() {
        return type;
    }*/

    public int getNumber() {
        return number;
    }
}
