package com.ucll.da.dentravak.repository;

import com.ucll.da.dentravak.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}