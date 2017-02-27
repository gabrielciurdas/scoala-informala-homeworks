package ro.siit.java5;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gabi on 2/25/2017.
 */
public class AccomodationFairRelationDAO {

    public void add(AccomodationFairRelation accomodationFairRelation) {
        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "BookingApp", "postgres", "aNewPa55w0rd");
                PreparedStatement stm =
                        conn.prepareStatement("INSERT INTO accomodation_fair_relation(id_accomodation, id_room_fair) values(?,?)");
        ){

            stm.setInt(1, accomodationFairRelation.getAccomodationId());
            stm.setInt(2, accomodationFairRelation.getRoomFairId());

            stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<AccomodationFairRelation> getAll() {
        List<AccomodationFairRelation> result = new LinkedList<>();

        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "BookingApp", "postgres", "aNewPa55w0rd");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("select id, id_accomodation, id_room_fair from accomodation_fair_relation");
        ){

            while (rs.next()) {
                AccomodationFairRelation afr = new AccomodationFairRelation();

                afr.setId(rs.getInt("id"));
                afr.setAccomodationId(rs.getInt("id_accomodation"));
                afr.setRoomFairId(rs.getInt("id_room_fair"));

                result.add(afr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public List<AccomodationFairRelation> printAll() {
        List<AccomodationFairRelation> result = new LinkedList<>();

        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "BookingApp", "postgres", "aNewPa55w0rd");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM accomodation_fair_relation " +
                                "JOIN accomodation ON accomodation.id = accomodation_fair_relation.id_accomodation " +
                                "JOIN room_fair ON room_fair.id = accomodation_fair_relation.id_room_fair;" );
        ){
            int count =0;

            while (rs.next()) {
                System.out.println("[Room Type] " + rs.getString("type") + ": price for " +
                        rs.getString("season") + " season" + " = " + rs.getInt("value") + " RON");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can't load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }

    }

    private static Connection newConnection(String type, String host, String port, String dbName, String user,
                                            String pw) {

        loadDriver();
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: DB may be
        // busy, good to set a higher
        // timeout
        try {
            String url = new StringBuilder().append("jdbc:").append(type)
                    .append("://").append(host).append(":").append(port).append("/").append(dbName).append("?user=")
                    .append(user).append("&password=").append(pw).toString();
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }

        return null;
    }
}
