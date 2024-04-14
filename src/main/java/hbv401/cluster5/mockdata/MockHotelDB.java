package hbv401.cluster5.mockdata;

public class MockHotelDB {

    //Hotel Mock Data
    private static MockHotel[] mockHotelDB = new MockHotel[3];
    private static MockHotel hotelService0 = new MockHotel(9990, "Reykjavik Hotel - single bed", "Reykjavik", 50,"0");
    private static MockHotel hotelService1 = new MockHotel(5500, "Akureyri Hotel - single bed", "Akureyri", 50,"1");
    private static MockHotel hotelService2 = new MockHotel(7560, "Akureyri Hotel - dual bed","Akureyri",25,"2");




    /**
     * Method to initialize DB systems with mock data
     */
    public static void init() {


        //Hotel DB - Add Data
        mockHotelDB[0] = hotelService0;
        mockHotelDB[1] = hotelService1;
        mockHotelDB[2] = hotelService2;


    }


    public static int getHotelServiceNum() {return mockHotelDB.length;}

    public static String getHotelLocation(int i) {return mockHotelDB[i].getLocation();}

    public static String getHotel(int i){
        return mockHotelDB[i].getServiceDataString();
    }
    public static int getHotelAvailable(int i){
        return mockHotelDB[i].getAvailableSpace();
    }






    public static void hotelBookService(String id){
        //System.out.println("Hotel with id: "+id);
        int itemIndex = -1;

        //Find array index of service id
        for (int i=0; i < mockHotelDB.length;i++){
            if (mockHotelDB[i].getId().trim().equalsIgnoreCase(id)){
                itemIndex = i;
                System.out.println("item found");
            }
        }
        // Simulate booking of the service
        if ((itemIndex !=-1) || (itemIndex > mockHotelDB.length)){
            mockHotelDB[itemIndex].setAvailableSpace(mockHotelDB[itemIndex].getAvailableSpace()-1);;
            //System.out.println(flightServiceDB[itemIndex].getAvailableSpace());
        }
        else  {
            System.out.println("db index not found or invalid");
        }
    }

}
