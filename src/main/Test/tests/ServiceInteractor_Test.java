package tests;

import database.Mock;
import database.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


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
        mockObject.addService(service);

        boolean result = service.book(2);

        assertEquals(false, result);
    }

    // Booking test: Successful version
    @Test
    public void testBookingSuccess() {
        Service service = new Service(10000, "lorem ipsum dolor sit amet", "Location y", 5);
        mockObject.addService(service);

        boolean result = service.book(2);

        assertEquals(true, result);
    }

    // Booking test: Error version
    @Test
    public void testBookingError() {
        Service service = new Service(10000, "lorem ipsum dolor sit amet", "Location z", 3);
        mockObject.addService(service);


        service.setAvailableSpace(-1); // set seatCount to a negative number

        boolean result = service.book(2);

        assertEquals(false, result);
    }

    /**
     * Service was never added, thus should return an error
     */
    @Test
    public void testNoService(){
        assertThrows(IndexOutOfBoundsException.class, () -> mockObject.getSpecificService(0));
    }

    /**
     * One service test
     */
    @Test
    public void testOneService(){
        Service service = new Service(10000, "lorem ipsum dolor sit amet", "Location z", 3);
        mockObject.addService(service);
        assertEquals(service, mockObject.getSpecificService(0));;
    }

    /**
     * Multiple service test
     */

    @Test
    public void testMultipleService(){
        Service service = new Service(10000, "lorem ipsum dolor sit amet", "Location z", 3);
        Service service2 = new Service(10000, "lorem ipsum dolor sit amet", "Location z", 3);
        mockObject.addService(service);
        mockObject.addService(service2);
        assertEquals(service, mockObject.getSpecificService(0));
        assertEquals(service2, mockObject.getSpecificService(1));
    }
}
