package com.skilldistillery.jets;

public abstract class Jets {

	private String model;
	private double speed;
	private int range;
	private long price;

	public Jets(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public static void fly(Jets[] jets) {
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				double flightTime = jets[i].range / jets[i].speed;
				System.out.println(jets[i]);
				System.out.println(jets[i].getModel() + " can fly for" + flightTime + "hours");
			}
		}
	}

	@Override
	public String toString() {
		return "Jets [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
