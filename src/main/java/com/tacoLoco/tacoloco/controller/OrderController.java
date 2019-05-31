package com.tacoLoco.tacoloco.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tacoLoco.tacoloco.entity.Order;
import com.tacoLoco.tacoloco.service.OrderService;


@CrossOrigin()
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
		
	@GetMapping("/order/details")
	public Order getOrder(){
		return orderService.getOrderById();
	}
	
	@PostMapping("/order")
	public void postOrder( @RequestBody Order order) {
		orderService.postOrder(order);
	}
	
}
