package com.tacoLoco.tacoloco.api.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tacoLoco.tacoloco.entity.Taco;

@Repository
public interface TacoRepository extends JpaRepository<Taco,Long>{
	
}
