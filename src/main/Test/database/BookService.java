package database;

public class BookService {

    private int availableSpace = 0;

    /**
     * Setter for number of available space in service
     * @param availableSpace integer that sets the available space for this specific service
     */
    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }

    /**
     * Getter for number of avaible spaces in service
     * @return integer number for available space
     */
    public int getAvailableSpace() {
        return availableSpace;
    }

    /**
     * Method for booking space for a given number of people in service
     * @param numberOfPeople integer for number of people that are booking a reservation
     * @return boolean that confirms reservation or denies it
     */
    public boolean bookSeat(int numberOfPeople) {
        if (availableSpace <= numberOfPeople) {
            availableSpace -= numberOfPeople;
            return true;
        } else  {
            return false;
        }
    }
}
