package com.skilldistillery.jets;

public class JetImpl extends Jets {

	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public String toString() {
		return "Basic Jet [Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: " + getRange()
		+ ", Price: " + getPrice() + "]";
	}
}
