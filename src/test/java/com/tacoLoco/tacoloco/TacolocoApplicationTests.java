package com.tacoLoco.tacoloco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tacoLoco.tacoloco.api.jpa.OrderJpaRepository;
import com.tacoLoco.tacoloco.api.jpa.TacoRepository;
import com.tacoLoco.tacoloco.entity.Order;
import com.tacoLoco.tacoloco.entity.Taco;
import com.tacoLoco.tacoloco.service.OrderService;
import com.tacoLoco.tacoloco.service.TacoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TacolocoApplicationTests {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private TacoService tacoService;
	
	@MockBean
	private OrderJpaRepository orderRepository;
	
	@MockBean
	private TacoRepository tacoRepository;
	
	@Test
	public void getAllTacosTest() {
		when(tacoRepository.findAll()).thenReturn(Stream.of(new Taco((long) 1001,"Veg Taco",2.50),new Taco((long) 1002,"Veg Taco",2.50)).collect(Collectors.toList()));
		assertEquals(2,tacoService.getTacos().size());
	}
	
	@Test
	public void getOrderByIdTest() {
		Long id=(long) 1002;
		when(orderRepository.findOne(id)).thenReturn(new Order((long) 1002,2.50,3));
		assertEquals(1002,orderService.getOrderById());	
	}
	
	@Test
	public void finalPriceTest() {	
		Order order = new Order((long) 1002,12,4);
		assertNotNull(order);
		assertEquals(9.6,orderService.finalPrice(12.00, 4, order).getPrice(),0.0001);
		Order newOrder= new Order((long) 1003, 7.5,3);
		assertEquals(7.5,orderService.finalPrice(7.5, 3, newOrder).getPrice(),0.00001);
	
	}
	
	@Test
	public void postOrderTest() {
		Order order=new Order((long) 1002,10.00,4);
		when(orderRepository.save(order)).thenReturn(order);
	}
	
	@Test
	
	public void contextLoads() {
	}

}
