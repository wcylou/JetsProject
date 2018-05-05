package com.skilldistillery.jets;

public class Pilots {
	
	private String name;
	private double yearsFlying;

	public Pilots(String name, double yearsFlying) {
		super();
		this.name = name;
		this.yearsFlying = yearsFlying;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getYearsFlying() {
		return yearsFlying;
	}

	public void setYearsFlying(int yearsFlying) {
		this.yearsFlying = yearsFlying;
	}

	@Override
	public String toString() {
		return "Pilots [Name: " + name + ", Years of Flying: " + yearsFlying + "]";
	}

}
