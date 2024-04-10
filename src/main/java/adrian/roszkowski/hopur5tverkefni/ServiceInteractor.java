package adrian.roszkowski.hopur5tverkefni;


import java.util.ArrayList;
import java.util.List;

public class ServiceInteractor {

   //public static String[] getServiceList(){
   public static List<String> getServiceList(){
       List<String> serviceListData = new ArrayList<String>();

       for (int i=0; i < ServiceDB.getDTourServiceNum(); i++){
           serviceListData.add("[Day Tour] " + ServiceDB.getDayTour(i));
       }

       for (int i=0; i < ServiceDB.getFlightServiceNum(); i++){
           serviceListData.add("[Flight] " + ServiceDB.getFlight(i));
       }

       for (int i=0; i < ServiceDB.getHotelServiceNum(); i++){
           serviceListData.add("[Hotel] " + ServiceDB.getHotel(i));
       }

       return serviceListData;
    }

}

