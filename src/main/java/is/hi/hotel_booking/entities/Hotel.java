package is.hi.hotel_booking.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    private final String name;
    private final String location;
    private List<Room> rooms;

    public Hotel(String name, String location, List<Room> rooms) {
        this.name = name;
        this.location = location;
        this.rooms = rooms;
    }

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
        this.rooms = new ArrayList<>();
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public String getLocation(){
        return location;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public List<Room> getRoomsByRoomType(Room.RoomType roomType){
        List<Room> roomsByType = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType() == roomType) {
                roomsByType.add(room);
            }
        }
        return roomsByType;
    }


    public List<Room> availableRooms(LocalDate d1, LocalDate d2, Room.RoomType roomType) {
        List<Room> availableRooms = new ArrayList<>();

        for (Room room : this.getRoomsByRoomType(roomType)) {
            // Checks if a room is available on start date and the end date
            if (room.isAvailable(d1, d2)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
