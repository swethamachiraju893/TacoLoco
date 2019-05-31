package com.tacoLoco.tacoloco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacoLoco.tacoloco.api.jpa.OrderJpaRepository;
import com.tacoLoco.tacoloco.entity.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderJpaRepository orderRepository;

	public Order finalPrice(Double price,int totalQuantity, Order order ) {
		if(totalQuantity>=4) {
			double newPrice=price-(price*0.2);
			order.setPrice(newPrice);
			order.setQuantity(totalQuantity);
			return order;
		}
		else
		return order;
	}
	
	public Order getOrderById() {
		return orderRepository.findTopByOrderByIdDesc();
	}
	public void postOrder(Order order) {
		Order newOrder=this.finalPrice(order.getPrice(), order.getQuantity(), order);
		 orderRepository.save(newOrder);
	}
	
}
