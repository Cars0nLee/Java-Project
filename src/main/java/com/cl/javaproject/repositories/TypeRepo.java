package com.cl.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cl.javaproject.models.BodyType;

@Repository
public interface TypeRepo extends CrudRepository<BodyType, Long> {
	
	List<BodyType> findAll();
	
}
