package com.example.LiveProject.DAO;

import org.springframework.stereotype.Component;

@Component
public class DataaModel {
	private String vehicleNo;
	private int bagscount;
	private String phoneNumber;

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public int getBagscount() {
		return bagscount;
	}

	public void setBagscount(int bagscount) {
		this.bagscount = bagscount;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getVehicleNo()+"-------------------"+getBagscount()+"---------------"+getPhoneNumber();
	}
}
