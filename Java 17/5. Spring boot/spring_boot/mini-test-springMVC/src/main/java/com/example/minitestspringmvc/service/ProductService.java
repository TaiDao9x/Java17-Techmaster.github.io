package com.example.minitestspringmvc.service;

import com.example.minitestspringmvc.entity.Image;
import com.example.minitestspringmvc.entity.Product;
import com.example.minitestspringmvc.exception.NotFoundException;
import com.example.minitestspringmvc.model.request.ProductRequest;
import com.example.minitestspringmvc.model.response.AppointmentResponse;
import com.example.minitestspringmvc.model.response.ImageResponse;
import com.example.minitestspringmvc.model.response.ProductResponse;
import com.example.minitestspringmvc.repository.AppointmentRepository;
import com.example.minitestspringmvc.repository.ImageRepository;
import com.example.minitestspringmvc.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    ObjectMapper objectMapper;
    ProductRepository productRepository;
    AppointmentRepository appointmentRepository;
    ImageRepository imageRepository;

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> objectMapper.convertValue(product, ProductResponse.class))
                .collect(Collectors.toList());
    }

    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product product = objectMapper.convertValue(productRequest, Product.class);
        productRepository.save(product);
        return objectMapper.convertValue(product, ProductResponse.class);
    }

    public ProductResponse updateProduct(Integer id, ProductRequest productRequest) throws NotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found product")
                );

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setImage(productRequest.getImage());
        productRepository.save(product);

        return objectMapper.convertValue(product, ProductResponse.class);
    }

    public List<AppointmentResponse> getAllAppointment() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointment -> objectMapper.convertValue(appointment, AppointmentResponse.class))
                .collect(Collectors.toList());
    }

    public ProductResponse findProductById(Integer id) throws NotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found product"));
        return objectMapper.convertValue(product, ProductResponse.class);

    }

    public ImageResponse saveImage(MultipartFile file) {
        try {
            Image image = Image.builder()
                    .type(file.getContentType())
                    .data(file.getBytes())
                    .build();
            imageRepository.save(image);

            return objectMapper.convertValue(image, ImageResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ImageResponse getImageByProductId(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("not Found"));
        return objectMapper.convertValue(product.getImage(), ImageResponse.class);
    }
}
