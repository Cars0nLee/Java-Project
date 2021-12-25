package com.cl.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cl.javaproject.models.CarYear;

public interface YearRepo extends CrudRepository<CarYear, Long>{
	
	List<CarYear> findAll();
	
}
