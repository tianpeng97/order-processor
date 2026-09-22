package com.gigashad.tpeng.order_service.repositories;

import com.gigashad.tpeng.order_service.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
