package com.car.model;

public class RentalCar {
	private int id;
	private int customer_id;
	private int car_id;
	private String rental_ststus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getRental_ststus() {
		return rental_ststus;
	}
	public void setRental_ststus(String rental_ststus) {
		this.rental_ststus = rental_ststus;
	}
}
