package com.cl.javaproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="carz")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, max=4, message="Car Year is required!")
	private String year;
	
	@NotNull
	@Size(min=1, max=25, message="Car Make is required!")
	private String make;
	
	@NotNull
	@Size(min=1, max=25, message="Car Model is required!")
	private String model;
	
	@NotNull
	@Size(min=1, max=25, message="Car Body Type is required!")
	private String bodyType;
	
	@NotNull
	@Size(min=17, max=17, message="17 digit VIN is requried!")
	private String vin;
	
	@NotNull
	@Min(10)
	@Max(100000000)
	private Integer mileage;
	
	@NotNull
	@Min(100)
	@Max(100000000)
	private Integer price;
	
	@NotNull
	@Size(min=5, max=500, message="Car description is required!")
	private String description;
	
	@NotNull
	@Size(max=50)
	private String city;
	
	@NotNull
	@Size(max=50)
	private String state;
	
	@NotNull
	@Size(min=1, max=25, message="Exterior Color is required!")
	private String color;
	
	@NotNull
	@Size(min=1, max=25, message="Interior Color is required!")
	private String color2;
	
	@NotNull
	@Size(min=1, max=25, message="Transmission is required!")
	private String trans;
	
	///// Many To One
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	///// One To Many
	@OneToMany(mappedBy="car", fetch=FetchType.LAZY)
	private List<CarMake> carMake;
	
	@OneToMany(mappedBy="car", fetch=FetchType.LAZY)
	private List<CarYear> carYear;
	
	@OneToMany(mappedBy="car", fetch=FetchType.LAZY)
	private List<BodyType> type;
	
	@OneToMany(mappedBy="car", fetch=FetchType.LAZY)
	private List<State> states;
	
	///// Constructor
	public Car() {
		
	}
	
	public Car(String color2, String color, String city, String state, Integer mileage, String year, String make, String model, String bodyType, String vin, Integer price, String description) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.bodyType = bodyType;
		this.vin = vin;
		this.price = price;
		this.description = description;
		this.mileage = mileage;
		this.city = city;
		this.state = state;
		this.color = color;
		this.color2 = color2;
	}
	
	///// Getters and Setters
	public Long getId() {
		return id;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}

	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public List<BodyType> getType() {
		return type;
	}

	public void setType(List<BodyType> type) {
		this.type = type;
	}

	public List<CarYear> getCarYear() {
		return carYear;
	}

	public void setCarYear(List<CarYear> carYear) {
		this.carYear = carYear;
	}

	public List<CarMake> getCarMake() {
		return carMake;
	}

	public void setCarMake(List<CarMake> carMake) {
		this.carMake = carMake;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	///// Created at and Updated at
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}

