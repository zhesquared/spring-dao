package ru.netology.sprongdao.service;

import org.springframework.stereotype.Service;
import ru.netology.sprongdao.dao.OrderRepository;

import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public String getProductByCustomerName(String name){
        return repository.getProductByCustomerName(name).stream()
                .collect(Collectors.joining(", "));
    }
}

