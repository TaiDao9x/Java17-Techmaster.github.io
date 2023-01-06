package backend.User.service;

import backend.User.model.Address;
import backend.User.model.Order;
import backend.User.repository.PreOrderRepository;

import java.util.ArrayList;

public class PreOderService {
    ArrayList<Order> ALL_ORDER = allOrder();

    public ArrayList<Order> allOrder() {
        return PreOrderRepository.findAllOrder();
    }

    public void createPreOrder(Order newOrder) {
        ALL_ORDER.add(newOrder);
        PreOrderRepository.updateFile(ALL_ORDER);
    }

    public void changeAddressPreOrder(String email, Address newAddress) {
        for (Order pre : ALL_ORDER) {
            if (pre.getEmail().equalsIgnoreCase(email)) {
                pre.setAddressShip(newAddress);
            }
        }
        PreOrderRepository.updateFile(ALL_ORDER);
    }

    public Order getPreOrder(String email) {
        for (Order pre : ALL_ORDER) {
            if (pre.getEmail().equalsIgnoreCase(email)) {
                return pre;
            }
        }
        return null;
    }

    public void deletePreOrder(String email) {
        ArrayList<Order> toRemove = new ArrayList<>();
        for (Order pre : ALL_ORDER) {
            if (pre.getEmail().equalsIgnoreCase(email)) {
                toRemove.add(pre);
            }
        }
        ALL_ORDER.removeAll(toRemove);
        PreOrderRepository.updateFile(ALL_ORDER);
    }
}
