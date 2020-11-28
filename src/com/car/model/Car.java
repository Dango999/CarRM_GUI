package com.car.model;

public class Car {
	private int id;
	private String name;
	private int max_num;
	private String rent;
	private String deposit;
	private String info;
	private int selected_num = 0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMax_num() {
		return max_num;
	}
	public void setMax_num(int max_num) {
		this.max_num = max_num;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public int getSelected_num() {
		return selected_num;
	}
	public void setSelected_num(int selected_num) {
		this.selected_num = selected_num;
	}
	public String toString(){
		return this.name;
	}
}
