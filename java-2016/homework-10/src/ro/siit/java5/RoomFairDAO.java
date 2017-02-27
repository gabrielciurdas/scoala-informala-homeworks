package ro.siit.java5;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is a data accsess object for a RoomFair object.
 *
 * @see RoomFair
 * <p>
 * Created by Gabriel Ciurdas on 2/20/2017.
 */
public class RoomFairDAO {
    /**
     * This method writes a room fair object in the specified database
     * by creating a connection with a PostgreSQL server and using a query.
     *
     * @param roomFair is the room fair to be written in the specified database.
     */
    public void add(RoomFair roomFair) {
        try (
                Connection conn = newConnection("postgresql",
                        "localhost",
                        "5432",
                        "BookingApp",
                        "postgres",
                        "aNewPa55w0rd");
                PreparedStatement stm =
                        conn.prepareStatement("INSERT INTO room_fair(value, season) values(?,?)");
        ) {

            stm.setDouble(1, roomFair.getValue());
            stm.setString(2, roomFair.getSeason().name());

            stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method retrieves a list of room fair objects from the specified database
     * by creating a connection with a PostgreSQL server and using a query.
     *
     * @return the list of room fair objects.
     */
    public List<RoomFair> getAll() {
        List<RoomFair> result = new LinkedList<>();

        try (
                Connection conn = newConnection("postgresql",
                        "localhost",
                        "5432",
                        "BookingApp",
                        "postgres",
                        "aNewPa55w0rd");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("select id, value, season from room_fair");

        ) {

            while (rs.next()) {
                RoomFair roomFair = new RoomFair();

                roomFair.setId(rs.getInt("id"));
                roomFair.setValue(rs.getInt("value"));
                roomFair.setSeason(rs.getString("season"));

                result.add(roomFair);
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
