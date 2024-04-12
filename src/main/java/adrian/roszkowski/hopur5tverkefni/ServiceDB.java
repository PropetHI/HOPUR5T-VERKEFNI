package adrian.roszkowski.hopur5tverkefni;

public class ServiceDB {

    //Day Tour Mock Data
    private static Service[] dTourServiceDB = new Service[3];
    private static Service dTourService0 = new Service(9990, "Guided Bus Ride around the City of Reykjavik", "Reykjavik", 10, "0");
    private static Service dTourService1 = new Service(5500, "Guided Bus Ride around the Town of Reykjavik", "Akureyri", 5,"1");
    private static Service dTourService2 = new Service(7560, "Boat Tour and whale watching","Akureyri",5,"2");



    //Flight Mock Data
    private static Service[] flightServiceDB = new Service[3];
    private static Service flightService0 = new Service(9990, "Flight from Reykjavík to Akureyri", "Reykjavik", 10,"0");
    private static Service flightService1 = new Service(5500, "Flight from Akureyri to Reykjavik", "Akureyri", 5,"1");
    private static Service flightService2 = new Service(7560, "Flight from Reykjavík to Akureyri","Akureyri",1,"2");
    ;


    //Hotel Mock Data
    private static Service[] hotelServiceDB = new Service[3];
    private static Service hotelService0 = new Service(9990, "Reykjavik Hotel - single bed", "Reykjavik", 50,"0");
    private static Service hotelService1 = new Service(5500, "Akureyri Hotel - single bed", "Akureyri", 50,"1");
    private static Service hotelService2 = new Service(7560, "Akureyri Hotel - dual bed","Akureyri",25,"2");

    //private static String[] currentDBItemParts;


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
    public static int getDayTourAvailable(int i){
        return dTourServiceDB[i].getAvailableSpace();
    }


    public static String getFlight(int i){
        return flightServiceDB[i].getServiceDataString();
    }
    public static int getFlightAvailable(int i){
        return flightServiceDB[i].getAvailableSpace();
    }


    public static String getHotel(int i){
        return hotelServiceDB[i].getServiceDataString();
    }
    public static int getHotelAvailable(int i){
        return hotelServiceDB[i].getAvailableSpace();
    }



    public static void dTourBookService(String id){
        //System.out.println("Booking Day Tour with id: "+id);
        int itemIndex = -1;

        //Find array index of service id
        for (int i=0; i < dTourServiceDB.length;i++){
            //currentDBItemParts = dTourServiceDB[i].getSelectionModel().getSelectedItem().split(",");
            if (dTourServiceDB[i].getId().trim().equalsIgnoreCase(id)){
                itemIndex = i;
                System.out.println("item found");
            }
        }
        // Simulate booking of the service
        if ((itemIndex !=-1) || (itemIndex > dTourServiceDB.length)){
            dTourServiceDB[itemIndex].setAvailableSpace(dTourServiceDB[itemIndex].getAvailableSpace()-1);;
            //System.out.println(dTourServiceDB[itemIndex].getAvailableSpace());
        }
        else  {
            System.out.println("db index not found or invalid");
        }
    }

    public static void flightBookService(String id){
       // System.out.println("Flight with id: "+id);
        int itemIndex = -1;

        //Find array index of service id
        for (int i=0; i < dTourServiceDB.length;i++){
            if (flightServiceDB[i].getId().trim().equalsIgnoreCase(id)){
                itemIndex = i;
                System.out.println("item found");
            }
        }
        // Simulate booking of the service
        if ((itemIndex !=-1) || (itemIndex > dTourServiceDB.length)){
            flightServiceDB[itemIndex].setAvailableSpace(flightServiceDB[itemIndex].getAvailableSpace()-1);;
            //System.out.println(flightServiceDB[itemIndex].getAvailableSpace());
        }
        else  {
            System.out.println("db index not found or invalid");
        }
    }

    public static void hotelBookService(String id){
        //System.out.println("Hotel with id: "+id);
        int itemIndex = -1;

        //Find array index of service id
        for (int i=0; i < dTourServiceDB.length;i++){
            if (hotelServiceDB[i].getId().trim().equalsIgnoreCase(id)){
                itemIndex = i;
                System.out.println("item found");
            }
        }
        // Simulate booking of the service
        if ((itemIndex !=-1) || (itemIndex > dTourServiceDB.length)){
            hotelServiceDB[itemIndex].setAvailableSpace(hotelServiceDB[itemIndex].getAvailableSpace()-1);;
            //System.out.println(flightServiceDB[itemIndex].getAvailableSpace());
        }
        else  {
            System.out.println("db index not found or invalid");
        }
    }



}
