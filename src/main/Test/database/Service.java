package database;

import java.util.Date;

public class Service extends BokaPlass {
    private int price;
    private String aboutService;
    private String location;
    private Date date;

    public Service(int price, String aboutService, String location, int setSaetisFjoldi) {
        this.price = price;
        this.location = location;
        this.aboutService = aboutService;
        setSaetisFjoldi(setSaetisFjoldi);
    }

    public boolean book(int customerCount) {
        boolean booking = bookSeat(customerCount);
        if(booking) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getPrice() {
        return price;
    }

    public String getAboutService() {
        return aboutService;
    }

    public String getLocation() {
        return location;
    }
}
