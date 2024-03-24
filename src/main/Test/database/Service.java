package database;

public class Service extends BookService {

    private int price;
    private String aboutService;
    private String location;

    /**
     * Constructor Service
     * @param price integer that tells you the cost of the service per person
     * @param aboutService String of text that has information about the service
     * @param location String of text that gives you the service location
     * @param availableSpace integer that sets the availbe space (one space per person) within the service
     */
    public Service(int price, String aboutService, String location, int availableSpace) {
        this.price = price;
        this.location = location;
        this.aboutService = aboutService;
        setAvailableSpace(availableSpace);
    }

    /**
     * Method for booking the service
     * @param customerCount integer number of people that want to book space
     * @return boolean that tells the user if the booking was confirmed or denied
     */
    public boolean book(int customerCount) {
        boolean booking = bookSeat(customerCount);
        if(booking) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Getter for the price of the service per person
     * @return integer number for the amount
     */
    public double getPrice() {
        return price;
    }

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

    public void setSeatCount(int newSeatcount){}
}
