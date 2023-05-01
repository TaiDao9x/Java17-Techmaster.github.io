package homework_02.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail {
    private Customer customer;
    private List<Service> services;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        if (services.size() > 5) {
            System.out.println("1 khách hàng chỉ sử dụng được tối đa 5 dịch vụ!");
            return;
        }
        this.services = services;
    }
}
