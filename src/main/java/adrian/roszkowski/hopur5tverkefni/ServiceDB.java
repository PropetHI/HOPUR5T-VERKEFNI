package adrian.roszkowski.hopur5tverkefni;

public class ServiceDB {

    //Day Tour Mock Data
    private static Service[] dTourServiceDB = new Service[3];
    private static Service dTourService0 = new Service(9990, "Guided Bus Ride around the City of Reykjavik", "Reykjavik", 10, 0);
    private static Service dTourService1 = new Service(5500, "Guided Bus Ride around the Town of Reykjavik", "Akureyri", 5,1);
    private static Service dTourService2 = new Service(7560, "Boat Tour and whale watching","Akureyri",5,2);



    //Flight Mock Data
    private static Service[] flightServiceDB = new Service[3];
    private static Service flightService0 = new Service(9990, "Flight from Reykjavík to Akureyri", "Reykjavik", 10,0);
    private static Service flightService1 = new Service(5500, "Flight from Akureyri to Reykjavik", "Akureyri", 5,1);
    private static Service flightService2 = new Service(7560, "Flight from Reykjavík to Akureyri","Akureyri",1,2);
    ;


    //Hotel Mock Data
    private static Service[] hotelServiceDB = new Service[3];
    private static Service hotelService0 = new Service(9990, "Reykjavik Hotel - single bed", "Reykjavik", 50,0);
    private static Service hotelService1 = new Service(5500, "Akureyri Hotel - single bed", "Akureyri", 50,1);
    private static Service hotelService2 = new Service(7560, "Akureyri Hotel - dual bed","Akureyri",25,2);



    /**
     * Method to initialize DB systems with mock data
     */
    public static void init() {
        //Day Tour DB - Add Data
        dTourServiceDB[0] = dTourService0;
        dTourServiceDB[1] = dTourService1;
        dTourServiceDB[2] = dTourService2;

        //Flight DB - Add Data
        flightServiceDB[0] = flightService0;
        flightServiceDB[1] = flightService1;
        flightServiceDB[2] = flightService2;


        //Hotel DB - Add Data
        hotelServiceDB[0] = hotelService0;
        hotelServiceDB[1] = hotelService1;
        hotelServiceDB[2] = hotelService2;


    }

    public static int getDTourServiceNum() {return dTourServiceDB.length;}
    public static int getFlightServiceNum() {return flightServiceDB.length;}
    public static int getHotelServiceNum() {return hotelServiceDB.length;}



    public static String getDayTour(int i){
        return dTourServiceDB[i].getServiceDataString();
    }

    public static String getFlight(int i){
        return flightServiceDB[i].getServiceDataString();
    }

    public static String getHotel(int i){
        return hotelServiceDB[i].getServiceDataString();
    }


}
