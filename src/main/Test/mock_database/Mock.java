package mock_database;

import java.util.ArrayList;

public class Mock {
    ArrayList<Service> service;

    /**
     * Initialize Mock Database
     */
    public Mock() {
        service = new ArrayList<Service>();
    }


    /**
     * For adding services
     * @param service the service to add
     */
    public void addService(Service service) {
        this.service.add(service);
    }


    public ArrayList<Service> getService() {
        return service;
    }

    /**
     * For getting a specific service
     * @param i the index of the service
     * @return The service
     */
    public Service getSpecificService(int i) {
        return service.get(i);
    }
}
