package hbv401.cluster5.mockdata;

/**
 * MockObject class to represent a generic Service DB
 * @version 1.0
 * @author Hopur5T
 *
 */
public class MockFlightDB {

    //Flight Mock Data
    private static MockFlight[] mockFlightDB = new MockFlight[3];
    private static MockFlight mockFlightService0 = new MockFlight(9990, "Flight from Reykjavík to Akureyri", "Reykjavik", 10,"0");
    private static MockFlight mockFlightService1 = new MockFlight(5500, "Flight from Akureyri to Reykjavik", "Akureyri", 5,"1");
    private static MockFlight mockFlightService2 = new MockFlight(7560, "Flight from Reykjavík to Akureyri","Akureyri",1,"2");




    /**
     * Method to initialize DB systems with mock data
     */
    public static void init() {
        //Flight DB - Add Data
        mockFlightDB[0] = mockFlightService0;
        mockFlightDB[1] = mockFlightService1;
        mockFlightDB[2] = mockFlightService2;

    }

    public static int getFlightServiceNum() {return mockFlightDB.length;}



    public static String getFlight(int i){
        return  mockFlightDB[i].getServiceDataString();
    }
    public static int getFlightAvailable(int i){
        return  mockFlightDB[i].getAvailableSpace();
    }



    public static void flightBookService(String id){
        // System.out.println("Flight with id: "+id);
        int itemIndex = -1;

        //Find array index of service id
        for (int i = 0; i <  mockFlightDB.length; i++){
            if ( mockFlightDB[i].getId().trim().equalsIgnoreCase(id)){
                itemIndex = i;
                System.out.println("item found");
            }
        }
        // Simulate booking of the service
        if ((itemIndex !=-1) || (itemIndex >  mockFlightDB.length)){
            mockFlightDB[itemIndex].setAvailableSpace( mockFlightDB[itemIndex].getAvailableSpace()-1);;
            //System.out.println(flightServiceDB[itemIndex].getAvailableSpace());
        }
        else  {
            System.out.println("db index not found or invalid");
        }
    }


}
