package com.tacoLoco.tacoloco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tacoLoco.tacoloco.entity.Taco;
import com.tacoLoco.tacoloco.service.TacoService;

@CrossOrigin()
@RestController
public class TacoController {
	
	@Autowired
	private TacoService tacoService;
	
	@GetMapping("/taco/details")
	public List<Taco> getAllTacos(){
		return tacoService.getTacos();
	}
	
}
