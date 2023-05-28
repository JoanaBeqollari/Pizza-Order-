package pizzaOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pizzaOrder.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
