package hbv401.cluster5.mockdata;

public class MockDTourDB {

    //Day Tour Mock Data
    private static MockDTour[] mockDTourDB = new MockDTour[3];
    private static MockDTour dTourService0 = new MockDTour(9990, "Guided Bus Ride around the City of Reykjavik", "Reykjavik", 10, "0");
    private static MockDTour dTourService1 = new MockDTour(5500, "Guided Bus Ride around the Town of Reykjavik", "Akureyri", 5,"1");
    private static MockDTour dTourService2 = new MockDTour(7560, "Boat Tour and whale watching","Akureyri",5,"2");


    /**
     * Method to initialize DB systems with mock data
     */
    public static void init() {
        //Day Tour DB - Add Data
        mockDTourDB[0] = dTourService0;
        mockDTourDB[1] = dTourService1;
        mockDTourDB[2] = dTourService2;
    }

    public static int getDTourServiceNum() {return mockDTourDB.length;}

    public static String getDTourLocation(int i) {return mockDTourDB[i].getLocation();}

    public static String getDayTour(int i){
        return mockDTourDB[i].getServiceDataString();
    }
    public static int getDayTourAvailable(int i){
        return mockDTourDB[i].getAvailableSpace();
    }


    public static void dTourBookService(String id){
        //System.out.println("Booking Day Tour with id: "+id);
        int itemIndex = -1;

        //Find array index of service id
        for (int i=0; i < mockDTourDB.length;i++){
            //currentDBItemParts = dTourServiceDB[i].getSelectionModel().getSelectedItem().split(",");
            if (mockDTourDB[i].getId().trim().equalsIgnoreCase(id)){
                itemIndex = i;
                System.out.println("item found");
            }
        }
        // Simulate booking of the service
        if ((itemIndex !=-1) || (itemIndex > mockDTourDB.length)){
            mockDTourDB[itemIndex].setAvailableSpace(mockDTourDB[itemIndex].getAvailableSpace()-1);;
            //System.out.println(dTourServiceDB[itemIndex].getAvailableSpace());
        }
        else  {
            System.out.println("db index not found or invalid");
        }
    }



}
