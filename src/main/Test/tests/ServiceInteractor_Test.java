package tests;

import database.Mock;
import database.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServiceInteractor_Test {

    Mock mockObject;


    @BeforeEach
    void initializeTests() {
        mockObject = new Mock();
    }

    // Booking test: Failed version
    @Test
    public void testBookingFailed() {
        Service service = new Service(10000, "lorem ipsum dolor sit amet", "Location x", 0);
        mock.addService(service);

        boolean result = service.bookSeat(2);

        assertEquals(false, result);
    }

    // Booking test: Successful version
    @Test
    public void testBookingSuccess() {
        Service service = new Service(10000, "lorem ipsum dolor sit amet", "Location y", 5);
        mock.addService(service);

        boolean result = service.bookSeat(2);

        assertEquals(true, result);
    }

    // Booking test: Error version
    @Test
    public void testBookingError() {
        Service service = new Service(10000, "lorem ipsum dolor sit amet", "Location z", 3);
        mock.addService(service);


        service.setSeatCount(-1); // set seatCount to a negative number

        boolean result = service.bookSeat(2);

        assertEquals(false, result);
    }
}
