package adrian.roszkowski.hopur5tverkefni;


import java.util.ArrayList;
import java.util.List;

public class ServiceInteractor {



   //public static String[] getServiceList(){
   public static List<String> getServiceList(){
       List<String> serviceListData = new ArrayList<String>();

       for (int i=0; i < ServiceDB.getDTourServiceNum(); i++){
           serviceListData.add("Day Tour; " + ServiceDB.getDayTour(i));
       }

       for (int i=0; i < ServiceDB.getFlightServiceNum(); i++){
           serviceListData.add("Flight; " + ServiceDB.getFlight(i));
       }

       for (int i=0; i < ServiceDB.getHotelServiceNum(); i++){
           serviceListData.add("Hotel; " + ServiceDB.getHotel(i));
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

}

