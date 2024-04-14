package is.hi.hotel_booking.repository;
import is.hi.hotel_booking.entities.Booking;
import is.hi.hotel_booking.entities.Hotel;
import is.hi.hotel_booking.entities.Room;
import is.hi.hotel_booking.entities.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    private Connection connection;
    private static final String DB_URL = "jdbc:sqlite:src/main/java/is/hi/hotel_booking/database/hotels.db";
    public BookingRepository(Connection connection) {
        this.connection = connection;
    }
    public static String formatLocalDate(LocalDate date) {
        // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Format the LocalDate object using the formatter
        String formattedDate = date.format(formatter);
        return formattedDate;
    }


    public void createBooking(Booking booking) {
        String query = "INSERT INTO Bookings(fromDate, toDate, roomNumber, userEmail, hotelName, hotelLocation) VALUES (?, ?, ?, ?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            String fromDate = formatLocalDate(booking.getFromDate());
            String toDate = formatLocalDate(booking.getToDate());
            statement.setString(1, fromDate);
            statement.setString(2, toDate);
            statement.setInt(3, booking.getRoom().getRoomNumber());
            statement.setString(4, booking.getUser().getEmail());
            statement.setString(5, booking.getHotel().getName());
            statement.setString(6, booking.getHotel().getLocation());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bookings");

            // Process the result set and append to the search result
            while (resultSet.next()) {
                LocalDate fromDate = LocalDate.parse(resultSet.getString("fromDate"));
                LocalDate toDate = LocalDate.parse(resultSet.getString("toDate"));
                int roomNumber = resultSet.getInt("roomNumber");
                String userEmail = resultSet.getString("userEmail");
                String hotelName = resultSet.getString("hotelName");
                String hotelLocation = resultSet.getString("hotelLocation");

                // Fetch the corresponding Room and Hotel objects
                RoomRepository roomRepository = new RoomRepository(connection);
                HotelRepository hotelRepository = new HotelRepository(connection);
                Room room = roomRepository.getRoomByNumberAndHotel(roomNumber, hotelName, hotelLocation);
                Hotel hotel = hotelRepository.getHotelByNameAndLocation(hotelName, hotelLocation);

                // Fetch the corresponding User object based on the userEmail
                UserRepository userRepository = new UserRepository(connection);
                User user = userRepository.getUserByEmail(userEmail);

                // Create the Booking object and add it to the list
                bookings.add(new Booking(room, hotel, fromDate, toDate, user));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}