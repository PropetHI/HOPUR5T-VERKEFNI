package is.hi.hotel_booking.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Room {
    private final int roomNumber;
    private RoomType roomType;
    private Hotel hotel;
    private List<Booking> bookings;


    public Room(int roomNumber, RoomType roomType){
        this.roomNumber = roomNumber;
        this.bookings = new ArrayList<>();
        this.roomType = roomType;
    }

    public Room(int roomNumber, RoomType roomType, Hotel hotel){
        this.roomNumber = roomNumber;
        this.bookings = new ArrayList<>();
        this.roomType = roomType;
        this.hotel = hotel;

        hotel.addRoom(this);
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    public List<Booking> getBookings(){
        return bookings;
    }
    public RoomType getRoomType() {
        return roomType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setHotel(Hotel hotel){
        this.hotel = hotel;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public boolean isAvailable(LocalDate fromDate, LocalDate toDate) {
        for (Booking booking : bookings) {
            if (!(toDate.isBefore(booking.getFromDate()) || fromDate.isAfter(booking.getToDate()))){
                return false;
            }
        }
        return true;
    }

    public enum RoomType {
        // Initialize prices for single, double and suite rooms
        SINGLE(10000),
        DOUBLE(15000),
        SUITE(20000);
        private final double price;

        // Set price
        RoomType(double price) {
            this.price = price;
        }

        // Get price
        public double getPrice() {
            return price;
        }
    }
}
