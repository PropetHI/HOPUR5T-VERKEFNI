package is.hi.hotel_booking.controllers;

import is.hi.hotel_booking.entities.Booking;
import is.hi.hotel_booking.entities.Hotel;
import is.hi.hotel_booking.entities.Room;
import is.hi.hotel_booking.entities.User;
import is.hi.hotel_booking.repository.BookingRepository;
import is.hi.hotel_booking.repository.HotelRepository;
import is.hi.hotel_booking.repository.RoomRepository;


import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class HotelController {
    public final BookingRepository bookingRepository;
    public final HotelRepository hotelRepository;
    public final RoomRepository roomRepository;

    private List<Hotel> hotels;
    private List<Booking> bookings;
    private List<Room> rooms;



    public HotelController(Connection connection) {
        bookingRepository = new BookingRepository(connection);
        hotelRepository = new HotelRepository(connection);
        roomRepository = new RoomRepository(connection);
    }

    // Initialization method to fetch data from the database
    public void initialize() {
        // Fetch and load data from the database
        hotels = hotelRepository.getHotels();
        bookings = bookingRepository.getAllBookings();
        rooms = roomRepository.getAllRooms();

        // Connect rooms to hotels
        for (Room room : rooms) {
            for (Hotel hotel : hotels) {
                if (hotel.getName().equals(room.getHotel().getName()) &&
                        hotel.getLocation().equals(room.getHotel().getLocation())) {
                    hotel.addRoom(room);
                    break; // Once connected, break the inner loop
                }
            }
        }
        // Connect bookings to rooms
        for (Booking booking : bookings) {
            for (Room room : rooms) {
                if (room.getRoomNumber() == booking.getRoom().getRoomNumber() &&
                        room.getHotel().getName().equals(booking.getHotel().getName()) &&
                        room.getHotel().getLocation().equals(booking.getHotel().getLocation())) {
                    room.addBooking(booking);
                    break; // Once connected, break the inner loop
                }
            }
        }

        System.out.println("Dagsetning á fyrstu bókun: " + bookings.get(0).getFromDate());

        Room.RoomType roomType = rooms.get(0).getRoomType();

        String result1 = createBooking(hotels.get(0), roomType, new User("kk@netfang.is", "Kristinn"), LocalDate.of(2024,7,20), LocalDate.of(2024,7,27));

        String result2 = createBooking(hotels.get(0), roomType, new User("jonas@hotmail.is", "Jónas"), LocalDate.of(2024,7,22), LocalDate.of(2024,7,25));

        System.out.println(result1);
        System.out.println(result2);
    }

    // Bóka hótel
    public String createBooking(Hotel hotel, Room.RoomType roomType, User user, LocalDate fromDate, LocalDate toDate) {
        System.out.println("valið hótel "+ hotel.getName());
        System.out.println("fjöldi hótela "+ hotels.size());
        System.out.println("fjöldi herb í hóteli: "+hotel.getRooms());
        System.out.println("fjöldi herb í gefnu roomtype"+ hotel.getRoomsByRoomType(roomType).size());
        List<Room> availableRooms = hotel.availableRooms(fromDate, toDate, roomType);
        System.out.println("available rooms "+availableRooms.size());

        if (!availableRooms.isEmpty()) {
            Room nextAvailableRoom = availableRooms.get(0);
            Booking booking = new Booking(nextAvailableRoom, hotel, fromDate, toDate, user);
            bookingRepository.createBooking(booking);
            return "Bókun hefur verið staðfest";

        } else {
            return "Þetta hótel er uppbókað fyrir valdar dagsetningar";
        }
    }

    // Leita eftir nafni eða staðsetningu
    public List<Hotel> search(String name) {
        return hotelRepository.search(name);
    }

    public List<Hotel> getHotels() {
        return hotelRepository.getHotels();
    }

}
