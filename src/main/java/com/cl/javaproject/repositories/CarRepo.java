package com.cl.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cl.javaproject.models.Car;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {
	
	List<Car> findAll();
	
}
