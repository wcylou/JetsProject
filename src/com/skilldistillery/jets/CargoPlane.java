package com.skilldistillery.jets;

public class CargoPlane extends Jets implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public String toString() {
		return "CargoJet [Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: " + getRange()
		+ ", Price: " + getPrice() + "]";
	}

	public void loadCargo() {
		System.out.println("Let's load all the cargo");
		
	}

}
