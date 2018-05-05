package com.skilldistillery.jets;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AirField {

	Scanner sc = new Scanner(System.in);
	public Jets[] jets;

	{
		jets = new Jets[20];
		jets[0] = new JetImpl("Basic Jet 100", 500, 6000, 1_500_000);
		jets[1] = new FighterJet("Lockheed SR-71 Blackbird", 2200.2, 2900, 2_000_000_000);
		jets[2] = new FighterJet("Apache", 3000.50, 2000, 1_200_000_000);
		jets[3] = new CargoPlane("Boeing 747", 628, 8400, 200_500_000);
		jets[4] = new CargoPlane("Boeing 848", 800, 10000, 2_500_000);
	}

	public void run() {
		displayMenu();

	}

	public void displayMenu() {
		System.out.println("Welcome to Wilson's Airfield");
		while (true) {
			System.out.println("Menu options:");
			System.out.println("1. List fleet\n" + "2. Fly all jets\n" + "3. View fastest jet\n"
					+ "4. View jet with longest range\n" + "5. Load all Cargo Jets\n" + "6. Dogfight!\n"
					+ "7. Add a jet to the fleet\n" + "8. Quit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				listFleet();
				break;
			case 2:
				Jets.fly(jets);
				break;
			case 3:
				fastestJet();
				break;
			case 4:
				longestRangeJet();
				break;
			case 5:
				loadCargoJets();
				break;
			case 6:
				dogfight();
				break;
			case 7:
				addJet();
				break;
			case 8:
				System.out.println("Exit");
				System.exit(0);
				break;
			default:
				System.out.println("Pick a number. Get it right this time");
			}
		}
	}

	private void loadCargoJets() {
		// TODO Auto-generated method stub

	}

	private void addJet() {
		Jets newJet = null;
		System.out.println("What is the model of the jet\n" + "1. Fighter Jet\n" + "2. Cargo Plane\n" + "3. Basic Jet");
		int jetModel = sc.nextInt();
		System.out.println("What is the speed of the jet");
		double jetSpeed = sc.nextDouble();
		System.out.println("What is the range of the jet");
		int jetRange = sc.nextInt();
		System.out.println("What is the price of the jet");
		long jetPrice = sc.nextLong();

		switch (jetModel) {
		case 1:
			newJet = new FighterJet("Fighter Jet", jetSpeed, jetRange, jetPrice);
			break;
		case 2:
			newJet = new CargoPlane("Cargo Plane", jetSpeed, jetRange, jetPrice);
			break;
		case 3:
			newJet = new JetImpl("Basic Jet", jetSpeed, jetRange, jetPrice);
			break;
		default:
			System.out.println("Pick a number. Get it right this time");
		}

		for (int i = 0; i < jets.length; i++) {
			if (jets[i] == null) {
				jets[i] = newJet;
				System.out.println("You added:" + newJet);
				break;
			}
		}
	}

	private void dogfight() {

	}

	private void longestRangeJet() {
		Jets longestRangeJet = jets[0];
		for (int i = 1; 1 < jets.length; i++) {
			if (jets[i] != null) {
				if (jets[i].getRange() > longestRangeJet.getRange()) {
					longestRangeJet = jets[i];
				}
			} else {
				break;
			}
		}
		System.out.println("The longest range jet is " + longestRangeJet);
	}

	private void fastestJet() {

		System.out.println("Do you want fastest speed in MPH or Mach?\n" + "1. MPH\n" + "2. Mach");
		int fastestJetChoice = sc.nextInt();
		Jets fastestJet = jets[0];
		switch (fastestJetChoice) {
		case 1:
			for (int i = 1; 1 < jets.length; i++) {
				if (jets[i] != null) {
					if (jets[i].getSpeed() > fastestJet.getSpeed()) {
						fastestJet = jets[i];
					}
				} else {
					break;
				}
			}
			System.out.println("The fastest jet is (speed in MPH): " + fastestJet);
			break;
		case 2:
			for (int i = 1; 1 < jets.length; i++) {
				if (jets[i] != null) {
					if (jets[i].getSpeed() > fastestJet.getSpeed()) {
						fastestJet = jets[i];
					}
				} else {
					break;
				}
			}
			System.out.println("The fastest jet is (speed in mach: "

					+ fastestJet.getClass().getSimpleName() + " [Model =" + fastestJet.getModel() + ", Speed()="
					+ speedInMach(fastestJet) + ", Range()=" + fastestJet.getRange() + ", Price()="
					+ fastestJet.getPrice() + "]");
			break;
		}
	}

	private void listFleet() {
		for (int i = 0; i < jets.length; i++) {
			Jets jets2 = jets[i];
			if (jets2 != null) {
				System.out.println(jets2);
			}
		}
	}

	private double speedInMach(Jets speedMach) {
		double speedInMach = speedMach.getSpeed() / 767.269;
		return speedInMach;
	}

}
