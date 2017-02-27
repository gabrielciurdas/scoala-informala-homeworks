package ro.siit.java5;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gabi on 2/20/2017.
 */
public class AccomodationDAO {

    public void add(Accomodation accomodation) {
        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "BookingApp", "postgres", "aNewPa55w0rd");
                PreparedStatement stm =
			conn.prepareStatement("INSERT INTO accomodation(type, bed_type, max_guests, description) values(?,?,?,?)");
			){

			stm.setString(1, accomodation.getType().name());
			stm.setString(2, accomodation.getBedType().name());
			stm.setInt(3, accomodation.getMaxGuests());
			stm.setString(4, accomodation.getDescription());

			stm.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }

    public List<Accomodation> getAll() {
        List<Accomodation> result = new LinkedList<>();

        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "BookingApp", "postgres", "aNewPa55w0rd");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("select id, type, bed_type, max_guests, description from accomodation");

        ){

            while (rs.next()) {
                Accomodation accomodation = new Accomodation();

                accomodation.setId(rs.getInt("id"));
                accomodation.setType(rs.getString("type"));
                accomodation.setBedType(rs.getString("bed_type"));
                accomodation.setMaxGuests(rs.getInt("max_guests"));
                accomodation.setDescription(rs.getString("description"));

                result.add(accomodation);
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
