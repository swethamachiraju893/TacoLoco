package com.tacoLoco.tacoloco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacoLoco.tacoloco.api.jpa.TacoRepository;
import com.tacoLoco.tacoloco.entity.Taco;

@Service
public class TacoService {

	@Autowired
	private TacoRepository tacoRepository;
	
	public List<Taco> getTacos(){
		List<Taco> tacos=tacoRepository.findAll();
		
		return tacos;
	}
	
}
