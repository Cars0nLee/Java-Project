package com.cl.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cl.javaproject.models.CarMake;

@Repository
public interface ManuRepo extends CrudRepository<CarMake, Long> {
	
	List<CarMake> findAll();
	
}
