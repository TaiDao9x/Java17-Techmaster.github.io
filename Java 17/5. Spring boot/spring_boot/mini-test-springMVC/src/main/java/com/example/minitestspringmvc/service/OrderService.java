package com.example.minitestspringmvc.service;

import com.example.minitestspringmvc.entity.Order;
import com.example.minitestspringmvc.entity.Product;
import com.example.minitestspringmvc.entity.User;
import com.example.minitestspringmvc.exception.NotFoundException;
import com.example.minitestspringmvc.model.request.OrderRequest;
import com.example.minitestspringmvc.repository.OrderRepository;
import com.example.minitestspringmvc.repository.ProductRepository;
import com.example.minitestspringmvc.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    ObjectMapper objectMapper;
    OrderRepository orderRepository;
    ProductRepository productRepository;
    UserRepository userRepository;

    public void createOrder(Integer productId, OrderRequest orderRequest) throws NotFoundException {
        Order order;
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Not found Product!"));
        User user = userRepository.findByEmail(orderRequest.getEmail());

        if (user == null) {
            User newUser = User.builder()
                    .name(orderRequest.getName())
                    .email(orderRequest.getEmail())
                    .phone(orderRequest.getPhone())
                    .build();
            userRepository.save(newUser);
            order = Order.builder()
                    .user(newUser)
                    .product(product)
                    .build();
            orderRepository.save(order);
        } else {
            order = Order.builder()
                    .user(user)
                    .product(product)
                    .build();
            orderRepository.save(order);
        }
    }
}
