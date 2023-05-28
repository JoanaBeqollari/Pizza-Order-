package pizzaOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pizzaOrder.entity.Order;
import pizzaOrder.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(name = "api/v1/pizzaOrder")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/all")
    public ResponseEntity<List<Order>> findAllOrder(){

        return new ResponseEntity<>(orderService.findAllOrder(), HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id){
        Optional<Order> optionalOrder = orderService.findOrderById(id);
        if (optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order updateOrder){
        return ResponseEntity.ok(orderService.updatedOrder(id, updateOrder));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/order")
    public ResponseEntity<Void> createOrder(@RequestBody Order order){ //@RequestBody annotation can be used
        // to automatically map the incoming request body to a Java object
        orderService.saveOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
