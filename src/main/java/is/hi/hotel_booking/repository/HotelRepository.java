package is.hi.hotel_booking.repository;

import is.hi.hotel_booking.entities.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository {
    private final Connection connection;
    private static final String DB_URL = "jdbc:sqlite:src/main/java/is/hi/hotel_booking/database/hotels.db";

    public HotelRepository(Connection connection){
        this.connection = connection;
    }

    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hotels");

            // Process the result set and append to the search result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                hotels.add(new Hotel(name, location));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public List<Hotel> search(String searchText){
        List<Hotel> filteredHotelList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM hotels WHERE name LIKE '" + searchText + "%' OR location LIKE '" + searchText + "%'";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set and append to the filteredHotelList
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                // Assuming Hotel constructor takes name and location parameters
                filteredHotelList.add(new Hotel(name, location));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filteredHotelList;
    }

    public Hotel getHotelByNameAndLocation(String name, String location) {
        Hotel hotel = null;

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Hotels WHERE name = ? AND location = ?")) {
            statement.setString(1, name);
            statement.setString(2, location);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                hotel = new Hotel(name, location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }


}
