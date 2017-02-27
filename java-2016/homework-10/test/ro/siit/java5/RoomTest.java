package ro.siit.java5;

import org.junit.Test;
/**
 * Created by Gabi on 2/20/2017.
 */
public class RoomTest {

    @Test
    public void writesAccomodationToDatabase() {
        AccomodationDAO ad = new AccomodationDAO();
        ad.add(new Accomodation(RoomType.SINGLE, BedType.SINGLE, 1, "Lake View"));

        RoomFairDAO rf = new RoomFairDAO();
        rf.add(new RoomFair(100, Season.SPRING));
        rf.add(new RoomFair(140, Season.SUMMER));
        rf.add(new RoomFair(110, Season.AUTUMN));
        rf.add(new RoomFair(80, Season.WINTER));

        AccomodationFairRelationDAO afr = new AccomodationFairRelationDAO();

        int accomodationIndex = ad.getAll().size() - 1;
        int accomodationFairRelationIndex = afr.getAll().size() ;

        afr.add(new AccomodationFairRelation(ad.getAll().get(accomodationIndex).getId(),
                rf.getAll().get(accomodationFairRelationIndex - Season.WINTER.ordinal() + 1).getId()));
        afr.add(new AccomodationFairRelation(ad.getAll().get(accomodationIndex).getId(),
                rf.getAll().get(accomodationFairRelationIndex - Season.AUTUMN.ordinal() + 1).getId()));
        afr.add(new AccomodationFairRelation(ad.getAll().get(accomodationIndex).getId(),
                rf.getAll().get(accomodationFairRelationIndex - Season.SUMMER.ordinal() + 1).getId()));
        afr.add(new AccomodationFairRelation(ad.getAll().get(accomodationIndex).getId(),
                rf.getAll().get(accomodationFairRelationIndex - Season.SPRING.ordinal() + 1).getId()));
    }

    @Test
    public void printsAccomodationsPricesFromDataBase() {
        AccomodationFairRelationDAO afr = new AccomodationFairRelationDAO();
        afr.getAll();
        afr.printAll();
    }
}

