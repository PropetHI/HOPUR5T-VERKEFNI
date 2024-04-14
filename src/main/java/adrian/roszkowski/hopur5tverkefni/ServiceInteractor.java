package adrian.roszkowski.hopur5tverkefni;


import hbv401.cluster5.mockdata.MockFlightDB;
import hbv401.cluster5.mockdata.MockHotelDB;
import hbv401.cluster5.mockdata.MockDTourDB;
import hbv401.cluster5.mockdata.ServiceDB;

import java.util.ArrayList;
import java.util.List;

public class ServiceInteractor {

    //protected static List<String> serviceListData = new ArrayList<String>();


   public static List<String> getServiceList(String textSearch, String location, String numPeople){
       List<String> serviceListData = new ArrayList<String>();
       serviceListData.clear();

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

