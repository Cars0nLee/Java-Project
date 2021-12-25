package com.cl.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cl.javaproject.models.State;

@Repository
public interface StateRepo extends CrudRepository<State, Long> {

	List<State> findAll();
	
}
