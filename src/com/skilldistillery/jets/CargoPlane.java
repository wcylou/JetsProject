package com.skilldistillery.jets;

public class CargoPlane extends Jets implements CargoCarrier {
	
	public CargoPlane() {
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public String toString() {
		return "CargoJet [Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: " + getRange()
		+ ", Price: " + getPrice() + "]";
	}

	@Override
	public void loadCargo() {
		System.out.println(super.getModel() + " is currently loading up with Cargo");
	}

}
