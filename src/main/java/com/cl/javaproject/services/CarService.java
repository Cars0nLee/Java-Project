package com.cl.javaproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cl.javaproject.models.BodyType;
import com.cl.javaproject.models.Car;
import com.cl.javaproject.models.CarMake;
import com.cl.javaproject.models.CarYear;
import com.cl.javaproject.models.State;
import com.cl.javaproject.repositories.CarRepo;
import com.cl.javaproject.repositories.ManuRepo;
import com.cl.javaproject.repositories.StateRepo;
import com.cl.javaproject.repositories.TypeRepo;
import com.cl.javaproject.repositories.YearRepo;

@Service
public class CarService {
	
	private final CarRepo carRepo;
	private final ManuRepo manuRepo;
	private final YearRepo yearRepo;
	private final TypeRepo typeRepo;
	private final StateRepo stateRepo;
	
	public CarService(CarRepo carRepo, ManuRepo manuRepo, YearRepo yearRepo, TypeRepo typeRepo, StateRepo stateRepo) {
		this.carRepo = carRepo;
		this.manuRepo = manuRepo;
		this.yearRepo = yearRepo;
		this.typeRepo = typeRepo;
		this.stateRepo = stateRepo;
	}
	
	///// Add Car
	public Car addCar(Car car) {
		return carRepo.save(car);
	}
	
	///// Edit Car
	public Car editCar(Car car) {
		return carRepo.save(car);
	}
	
	///// Find Car by Id
	public Car findCar(Long id) {
		Optional<Car> car = carRepo.findById(id);
		if(car.isPresent()) {
			return car.get();
		}
		else {
			return null;
		}
	}
	
	///// Delete
	public void delete(Long id) {
		carRepo.deleteById(id);
	}
	
	///// All Cars
	public List<Car> all(){
		return carRepo.findAll();
	}
	
	///// Find Make
	public List<CarMake> make() {
		return manuRepo.findAll();
	}
	
	///// Find Year
	public List<CarYear> year() {
		return yearRepo.findAll();
	}
	
	///// Find Type
	public List<BodyType> type() {
		return typeRepo.findAll();
	}
	
	///// Find State
	public List<State> state() {
		return stateRepo.findAll();
	}
}
