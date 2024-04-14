package is.hi.hotel_booking.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
    private String serviceName;
    private Double servicePrice;
    private String serviceDescription;
    private final LocalDate fromDate;
    private final LocalDate toDate;
   private final User user;
   private final Room room;
   private final Hotel hotel;

    public Booking(Room room, Hotel hotel, LocalDate fromDate, LocalDate toDate, User user){
        this.room = room;
        this.hotel = hotel;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.user = user;
        this.serviceName = hotel.getName();
        this.serviceDescription = hotel.getLocation();
        this.servicePrice = room.getRoomType().getPrice() * ChronoUnit.DAYS.between(fromDate, toDate);

        // add booking to list
        room.addBooking(this);
    }

    public LocalDate getFromDate() {
        return fromDate;
    }
    public LocalDate getToDate(){
        return toDate;
    }
    public User getUser(){
        return user;
    }
    public Room getRoom(){
        return room;
    }
    public Hotel getHotel() {
        return hotel;
    }

}



