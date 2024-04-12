package adrian.roszkowski.hopur5tverkefni;


import java.util.ArrayList;
import java.util.List;

public class ServiceInteractor {

    //protected static List<String> serviceListData = new ArrayList<String>();


   public static List<String> getServiceList(String textSearch, String location, String numPeople){
       List<String> serviceListData = new ArrayList<String>();
       serviceListData.clear();

       //if (textSearch.isBlank() && location.isBlank() && numPeople.isBlank()) {
       if (!numPeople.isBlank()) {
           System.out.print(numPeople);
           int minAvailable = Integer.parseInt(numPeople);

           for (int i = 0; i < ServiceDB.getDTourServiceNum(); i++) {
               if (ServiceDB.getDayTourAvailable(i) >= minAvailable) {
                   serviceListData.add("Day Tour; " + ServiceDB.getDayTour(i));
               }
           }

           for (int i = 0; i < ServiceDB.getFlightServiceNum(); i++) {
               if (ServiceDB.getFlightAvailable(i) >= minAvailable) {
                   serviceListData.add("Flight; " + ServiceDB.getFlight(i));
               }
           }

           for (int i = 0; i < ServiceDB.getHotelServiceNum(); i++) {
               if (ServiceDB.getHotelAvailable(i) >= minAvailable) {
                   serviceListData.add("Hotel; " + ServiceDB.getHotel(i));
               }
           }

       }
       else if (!location.isBlank()){
           System.out.print(location);
       }
       else {
           for (int i = 0; i < ServiceDB.getDTourServiceNum(); i++) {
               serviceListData.add("Day Tour; " + ServiceDB.getDayTour(i));
           }

           for (int i = 0; i < ServiceDB.getFlightServiceNum(); i++) {
               serviceListData.add("Flight; " + ServiceDB.getFlight(i));
           }

           for (int i = 0; i < ServiceDB.getHotelServiceNum(); i++) {
               serviceListData.add("Hotel; " + ServiceDB.getHotel(i));
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
           ServiceDB.dTourBookService(id);
       }
       else if(type.trim().equalsIgnoreCase(FLIGHT)){
            ServiceDB.flightBookService(id);
        }
       else if(type.trim().equalsIgnoreCase(HOTEL)){
            ServiceDB.hotelBookService(id);
        }
       else {
           System.out.println("Error, type not valid: " + type);
           status = 1;
       }

       return status;
    }

    /*
    public static List<String> queryServiceProviders(){
        int status = 0;
        serviceListData.clear();
        serviceListData.add("TEST;asdf;asdf;ASdfAS;asdf;Asdf;asdf");

        return serviceListData;
     }

     */



}

