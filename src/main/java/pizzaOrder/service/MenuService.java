package pizzaOrder.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pizzaOrder.entity.OrderItem;
import pizzaOrder.repository.OrderItemRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MenuService {
    private OrderItemRepository orderItemRepository;


    //shfaqja e menuse me emer dhe cmim
    public Map<String, String> showMenu(){
        List<OrderItem> orderItems = orderItemRepository.findAll();
        Map<String, String> response = new HashMap<>();
        orderItems.stream()
                .forEach(orderItemEntity -> response.put(orderItemEntity.getProductName(), String.valueOf(orderItemEntity.getProductPrice())));
        return response;
    }
}
