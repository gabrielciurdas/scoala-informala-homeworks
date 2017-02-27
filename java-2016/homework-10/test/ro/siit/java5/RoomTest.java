package ro.siit.java5;

import org.junit.Test;

/**
 * This class is a Test Suite for the Booking application.
 *
 * @see AccomodationDAO
 * @see RoomFairDAO
 * @see AccomodationFairRelationDAO
 * <p>
 * Created by Gabriel Ciurdas on 2/20/2017.
 */
public class RoomTest {

    @Test
    public void writesAccomodationToDatabase() {
        AccomodationDAO ad = new AccomodationDAO();
        ad.add(new Accomodation(RoomType.KING_BEDROOM, BedType.KING_SIZE, 2, "Lake View"));

        RoomFairDAO rf = new RoomFairDAO();
        rf.add(new RoomFair(150, Season.SPRING));
        rf.add(new RoomFair(190, Season.SUMMER));
        rf.add(new RoomFair(160, Season.AUTUMN));
        rf.add(new RoomFair(130, Season.WINTER));

        AccomodationFairRelationDAO afr = new AccomodationFairRelationDAO();

        int accomodationIndex = ad.getAll().size() - 1;
        int accomodationFairRelationIndex = afr.getAll().size() + (Season.values().length -1);

        afr.add(new AccomodationFairRelation(ad.getAll().get(accomodationIndex).getId(),
                rf.getAll().get(accomodationFairRelationIndex - Season.WINTER.ordinal()).getId()));
        afr.add(new AccomodationFairRelation(ad.getAll().get(accomodationIndex).getId(),
                rf.getAll().get(accomodationFairRelationIndex - Season.AUTUMN.ordinal()).getId()));
        afr.add(new AccomodationFairRelation(ad.getAll().get(accomodationIndex).getId(),
                rf.getAll().get(accomodationFairRelationIndex - Season.SUMMER.ordinal()).getId()));
        afr.add(new AccomodationFairRelation(ad.getAll().get(accomodationIndex).getId(),
                rf.getAll().get(accomodationFairRelationIndex - Season.SPRING.ordinal()).getId()));
    }

    @Test
    public void printsAccomodationsPricesFromDataBase() {
        AccomodationFairRelationDAO afr = new AccomodationFairRelationDAO();
        afr.getAll();
        afr.printAll();
    }
}

