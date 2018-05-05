package com.skilldistillery.jets;

public class FighterJet extends Jets implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public String toString() {
		return "FighterJet [Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: " + getRange()
				+ ", Price: " + getPrice() + "]";
	}

	@Override
	public void fight() {
		
		
	}
	
	

	
}
