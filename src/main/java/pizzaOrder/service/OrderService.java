package pizzaOrder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizzaOrder.entity.Order;
import pizzaOrder.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> findAllOrder(){ return orderRepository.findAll(); }

    public Optional<Order> findOrderById(Integer id){ return orderRepository.findById(id); }

    public Order updatedOrder(Integer id, Order updatedOrder){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found!"));
        order.setDateCreated(updatedOrder.getDateCreated());
        order.setItems(updatedOrder.getItems());
        order.setTotal(updatedOrder.getTotal());
        orderRepository.save(order);
        return order;
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
