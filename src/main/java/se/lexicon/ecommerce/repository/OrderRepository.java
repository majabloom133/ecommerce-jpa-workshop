package se.lexicon.ecommerce.repository;

import se.lexicon.ecommerce.model.entity.Order;
import se.lexicon.ecommerce.model.entity.OrderStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // 1. Find all orders belonging to a specific customer ID
   @org.springframework.data.jpa.repository.Query("SElECT o FROM Order o WHERE o.id = :customerId")
   List<Order> findByCustomerId(@org.springframework.data.repository.query.Param("customerId") Long customerId);

    // 2. Find orders by status and avoid N+1 problem using EntityGraph
    @EntityGraph(attributePaths = {"items"})
    List<Order> findByStatus(OrderStatus status);

    // Find a specific order by its unique number
    Optional<Order> findByOrderNumber(String orderNumber);
}