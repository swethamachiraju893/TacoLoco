package com.tacoLoco.tacoloco.api.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tacoLoco.tacoloco.entity.Order;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order, Long>{

	Order findTopByOrderByIdDesc();
}
