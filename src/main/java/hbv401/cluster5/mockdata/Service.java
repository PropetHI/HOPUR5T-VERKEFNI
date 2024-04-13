package hbv401.cluster5.mockdata;


/**
 * MockObject class to represent a generic placeholder Service of various types
 * @version 1.0
 * @author Hopur5T
 *
 */
public class Service {


    private String id;
    private int price;
    private String aboutService;
    private String location;
    private int availableSpace;

    /**
    * Constructor Service
     * @param price integer that tells you the cost of the service per person
     * @param aboutService String of text that has information about the service
     * @param location String of text that gives you the service location
     * @param availableSpace integer that sets the available space (one space per person) within the service
     */
    public Service(int price, String aboutService, String location, int availableSpace, String id) {
        this.price = price;
        this.location = location;
        this.aboutService = aboutService;
        this.availableSpace = availableSpace;
        this.id = id;
        //setAvailableSpace(availableSpace);
    }

    /**
     * Getter for the ID of the service
     * @return String with the servcie ID
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for the price of the service per person
     * @return integer number for the amount
     */
    public double getPrice() { return price; }

    /**
     * Getter for information about the service
     * @return String of text about the service
     */
    public String getAboutService() {
        return aboutService;
    }

    /**
     * Getter for the location of the service
     * @return String of text for the service location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter for the Space avalable of the service
     * @return integer number for the amount
     */
    public int getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(int newSpace) {
        this.availableSpace = newSpace;
    }


    /**
     * Getter for the location of the service
     * @return String with Data of service elements
     */
    public String getServiceDataString() {

        return "ID: ;" + id + "; " + "Price: " + price + " ; " + "Location: " + location + " ; " + "Description: " + aboutService + " ; " + "Availbable: " + availableSpace;
    }
}
