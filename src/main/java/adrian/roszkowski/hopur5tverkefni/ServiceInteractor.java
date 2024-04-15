package adrian.roszkowski.hopur5tverkefni;


import hbv401.cluster5.mockdata.MockFlightDB;
import hbv401.cluster5.mockdata.MockHotelDB;
import hbv401.cluster5.mockdata.MockDTourDB;
import hbv401.cluster5.mockdata.ServiceDB;

import is.hi.hotel_booking.*;
import is.hi.hotel_booking.controllers.*;
import is.hi.hotel_booking.database.DatabaseManager;
import is.hi.hotel_booking.entities.Hotel;
import is.hi.hotel_booking.entities.Room;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceInteractor {

    private static String DELIMITER = ";";


   public static List<String> getServiceList(String textSearch, String location, String numPeople)  throws IOException, SQLException {
       List<String> serviceListData = new ArrayList<String>();
       serviceListData.clear();


       //HOTEL TESTING CODE BLOCK
       try {
           System.out.println("-------------hotel test-------------------");

           Connection connection = DatabaseManager.getConnection();
           HotelController hotelController = new HotelController(connection);
           //HotelApplication hotelApplication = new HotelApplication();



           System.out.println(hotelController.search(""));
           List<Hotel> hotelList = hotelController.search("");

           //String hotelRoom = "";
           LocalDate d1 = LocalDate.of(2025,04,01);
           LocalDate d2 = LocalDate.of(2025,04,02);

           Room.RoomType tempRoom;

           for (int i=0;i<hotelList.size();i++) {
               System.out.print("Hotel" +DELIMITER + Room.RoomType.SINGLE.getPrice() + DELIMITER + hotelList.get(i).getLocation() + DELIMITER + hotelList.get(i).getName() +" Single  " + hotelList.get(i).availableRooms(d1, d2, Room.RoomType.SINGLE));
               System.out.print("Hotel" +DELIMITER + Room.RoomType.DOUBLE.getPrice() + DELIMITER + hotelList.get(i).getLocation() + DELIMITER + hotelList.get(i).getName() +" Single  " + hotelList.get(i).availableRooms(d1, d2, Room.RoomType.DOUBLE));
               System.out.print("Hotel" +DELIMITER + Room.RoomType.SUITE.getPrice() + DELIMITER + hotelList.get(i).getLocation() + DELIMITER + hotelList.get(i).getName() +" Single  " + hotelList.get(i).availableRooms(d1, d2, Room.RoomType.SUITE));
               System.out.println(hotelList.get(i).availableRooms(d1, d2, Room.RoomType.SINGLE).size());
               //System.out.println(hotelList.get(i).availableRooms(d1, d2, Room.RoomType.SINGLE).getFirst());
               System.out.println();
               //for (int i=0; hotelList.get(i).getRooms().size())
           }


           //System.out.println(hotelApplication.getHostServices());
           System.out.println("-------------hotel test end---------------");
       }
       catch (Exception e){
           System.out.println(e);
       }



       //HOTEL TESTING CODE BLOCK ENDS

       //if (textSearch.isBlank() && location.isBlank() && numPeople.isBlank()) {
       if (!numPeople.isBlank()) {
           //System.out.print(numPeople);
           int minAvailable = Integer.parseInt(numPeople);

           for (int i = 0; i < MockDTourDB.getDTourServiceNum(); i++) {
               if (MockDTourDB.getDayTourAvailable(i) >= minAvailable) {
                   serviceListData.add("Day Tour; " + MockDTourDB.getDayTour(i));
               }
           }

           for (int i = 0; i < MockFlightDB.getFlightServiceNum(); i++) {
               if (MockFlightDB.getFlightAvailable(i) >= minAvailable) {
                   serviceListData.add("Flight; " + MockFlightDB.getFlight(i));
               }
           }

           for (int i = 0; i < MockHotelDB.getHotelServiceNum(); i++) {
               if (MockHotelDB.getHotelAvailable(i) >= minAvailable) {
                   serviceListData.add("Hotel; " + MockHotelDB.getHotel(i));
               }
           }

       }
       else if (!location.isBlank()){
           //System.out.print(location);
           for (int i = 0; i < MockDTourDB.getDTourServiceNum(); i++) {
               if (location.trim().equalsIgnoreCase(MockDTourDB.getDTourLocation(i))) {
                   serviceListData.add("Day Tour; " + MockDTourDB.getDayTour(i));
               }
           }

           for (int i = 0; i < MockFlightDB.getFlightServiceNum(); i++) {
               if (location.trim().equalsIgnoreCase(MockFlightDB.getFlightLocation(i))) {
                   serviceListData.add("Flight; " + MockFlightDB.getFlight(i));
               }
           }

           for (int i = 0; i < MockHotelDB.getHotelServiceNum(); i++) {
               if (location.trim().equalsIgnoreCase(MockHotelDB.getHotelLocation(i))) {
                   serviceListData.add("Hotel; " + MockHotelDB.getHotel(i));
               }
           }
       }
       else if (!textSearch.isBlank()){
           //System.out.print(textSearch);
           for (int i = 0; i < MockDTourDB.getDTourServiceNum(); i++) {
               if (MockDTourDB.getDayTour(i).toLowerCase().contains(textSearch.trim().toLowerCase())) {
                   serviceListData.add("Day Tour; " + MockDTourDB.getDayTour(i));
               }
           }

           for (int i = 0; i < MockFlightDB.getFlightServiceNum(); i++) {
               if (MockFlightDB.getFlight(i).toLowerCase().contains(textSearch.trim().toLowerCase())) {
                   serviceListData.add("Flight; " + MockFlightDB.getFlight(i));
               }
           }

           for (int i = 0; i < MockHotelDB.getHotelServiceNum(); i++) {
               if (MockHotelDB.getHotel(i).toLowerCase().contains(textSearch.trim().toLowerCase())) {
                   serviceListData.add("Hotel; " + MockHotelDB.getHotel(i));
               }
           }
       }
       else {
           for (int i = 0; i < MockDTourDB.getDTourServiceNum(); i++) {
               serviceListData.add("Day Tour; " + MockDTourDB.getDayTour(i));
           }

           for (int i = 0; i < MockFlightDB.getFlightServiceNum(); i++) {
               serviceListData.add("Flight; " + MockFlightDB.getFlight(i));
           }

           for (int i = 0; i < MockHotelDB.getHotelServiceNum(); i++) {
               serviceListData.add("Hotel; " + MockHotelDB.getHotel(i));
           }
       }

       return serviceListData;
    }

    public static int bookService(String type, String id){
        String DAYTOUR = new String ("Day Tour");
        String FLIGHT = new String ( "Flight");
        String HOTEL = new String ( "Hotel");

        int status = 0;

        //System.out.println(DAYTOUR + FLIGHT + HOTEL);
        System.out.println("requesting the booking of service type " + type + " with id: " +id);


       if(type.trim().equalsIgnoreCase(DAYTOUR)){
           MockDTourDB.dTourBookService(id);
       }
       else if(type.trim().equalsIgnoreCase(FLIGHT)){
           MockFlightDB.flightBookService(id);
        }
       else if(type.trim().equalsIgnoreCase(HOTEL)){
           MockHotelDB.hotelBookService(id);
        }
       else {
           System.out.println("Error, type not valid: " + type);
           status = 1;
       }

       return status;
    }




}


