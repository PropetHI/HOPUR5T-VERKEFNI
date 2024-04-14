package is.hi.hotel_booking.repository;

import is.hi.hotel_booking.entities.Hotel;
import is.hi.hotel_booking.entities.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private final Connection connection;

    public RoomRepository(Connection connection){
        this.connection = connection;
    }

    public void createRoom(Room room) throws SQLException {
        String sql = "INSERT INTO Rooms(roomNumber, hotelName, hotelLocation, roomType) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, room.getRoomNumber());
            statement.setString(2, room.getHotel().getName());
            statement.setString(3, room.getHotel().getLocation());
            statement.setString(4, room.getRoomType().toString());
            statement.executeUpdate();
        }
    }

    public Room getRoomByNumberAndHotel(int roomNumber, String hotelName, String hotelLocation) {
        Room room = null;

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Rooms WHERE roomNumber = ? AND hotelName = ? AND hotelLocation = ?")) {
            statement.setInt(1, roomNumber);
            statement.setString(2, hotelName);
            statement.setString(3, hotelLocation);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                HotelRepository hotelRepository = new HotelRepository(connection);
                Room.RoomType roomType = Room.RoomType.valueOf(resultSet.getString("roomType"));
                Hotel hotel = hotelRepository.getHotelByNameAndLocation(hotelName, hotelLocation);
                room = new Room(roomNumber, roomType, hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return room;
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Rooms");

            while (resultSet.next()) {
                int roomNumber = resultSet.getInt("roomNumber");
                String hotelName = resultSet.getString("hotelName");
                String hotelLocation = resultSet.getString("hotelLocation");
                String roomTypeString = resultSet.getString("roomType");
                Room.RoomType roomType;
                switch (roomTypeString) {
                    case "SINGLE":
                        roomType = Room.RoomType.SINGLE;
                        break;
                    case "DOUBLE":
                        roomType = Room.RoomType.DOUBLE;
                        break;
                    case "SUITE":
                        roomType = Room.RoomType.SUITE;
                        break;
                    default:
                        // Handle unknown room types here
                        roomType = null;
                }

                // Assuming you have a method to get Hotel by name and location
                HotelRepository hotelRepository = new HotelRepository(connection);
                Hotel hotel = hotelRepository.getHotelByNameAndLocation(hotelName, hotelLocation);

                Room room = new Room(roomNumber, roomType, hotel);
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }
}

