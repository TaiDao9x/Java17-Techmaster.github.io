package homework_02.handle;

import homework_02.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceManagement {
    private static List<Service> services = new ArrayList<>();

    public List<Service> allServices() {
        return services;
    }

    public void addNewCustomer(Service newService) {
        services.add(newService);
    }

    public Service findServiceId(int id) {
        for (Service sv : services) {
            if (sv.getId() == id) return sv;
        }
        return null;
    }
}
