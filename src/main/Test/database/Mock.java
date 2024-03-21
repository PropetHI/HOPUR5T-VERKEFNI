package database;

import java.util.ArrayList;

public class Mock {
    ArrayList<Service> service;

    public Mock() {
        service = new ArrayList<Service>();
    }

    public void addService(Service service) {
        this.service.add(service);
    }

    public ArrayList<Service> getService() {
        return service;
    }

    public void getSpecificService(int i) {
        service.get(i);
    }
}
