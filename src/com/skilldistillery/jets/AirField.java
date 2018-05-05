package com.skilldistillery.jets;

import java.text.DecimalFormat;
import java.util.Random;
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

	public Pilots[] pilots;
	{
		pilots = new Pilots[10];
		pilots[0] = new Pilots("Dan the Man", 15);
		pilots[1] = new Pilots("Smithy Boy", 5);
		pilots[2] = new Pilots("Olive", 1);
		pilots[3] = new Pilots("T", 25);
		pilots[4] = new Pilots("Stringer", 17);
		pilots[5] = new Pilots("Bacon", 12);
		pilots[6] = new Pilots("Pilot100", 10);

		// shuffle pilot order randomly
		Random rd = new Random();
		for (int i = 0; i < countPilots(); i++) {
			if (pilots[i] != null) {
				int randomPos = rd.nextInt(countPilots());
				Pilots temp = pilots[i];
				pilots[i] = pilots[randomPos];
				pilots[randomPos] = temp;
			}
		}
	}

	public void run() {
		displayMenu();

	}

	public void displayMenu() {
		System.out.println("Welcome to Wilson's Airfield");
		while (true) {
			System.out.println("There are currently " + countJets() + " jets and " + countPilots() + " pilots");
			System.out.println("Menu options:");
			System.out.println("1. List fleet and pilots\n" + "2. List jets" + "3. List pilots\n"
					+ "4. Add a jet to the fleet\n" + "5. Add a pilot to the fleet\n" + "6. View fastest jet\n"
					+ "7. View jet with longest range\n" + "8. Fly all jets\n" + "9. Load all Cargo Jets\n"
					+ "10. Dogfight!\n" + "11. Quit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				listFleet();
				break;
			case 2:
				listJets();
				break;
			case 3:
				listPilots();
				break;
			case 4:
				addJet();
				break;
			case 5:
				addPilot();
				break;
			case 6:
				fastestJet();
				break;
			case 7:
				longestRangeJet();
				break;
			case 8:
				Jets.fly(jets);
				break;
			case 9:
				break;
			case 10:
				dogfight();
				break;
			case 11:
				System.out.println("Exit");
				System.exit(0);
				break;
			}
		}
	}

	private int countPilots() {
		int countPilots = 0;
		for (int i = 0; i < pilots.length; i++) {
			if (pilots[i] != null) {
				countPilots++;
			}
		}
		return countPilots;
	}

	private int countJets() {
		int countJets = 0;
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				countJets++;
			}
		}
		return countJets;
	}

	private void listFleet() {
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				System.out.println("\n" + jets[i] + "\n" + pilots[i] + "\n");
			}
		}
	}

	private void listJets() {
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				System.out.println(jets[i]);
			}
		}
	}

	private void listPilots() {
		System.out.println("Current list of pilots");
		for (int i = 0; i < pilots.length; i++) {
			Pilots pilots2 = pilots[i];
			if (pilots2 != null) {
				System.out.println(pilots2);
			}
		}
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
		}
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] == null) {
				jets[i] = newJet;
				System.out.println("You added:" + newJet + "\n");
				break;
			}
		}
		if (countPilots() >= countJets()) {
			System.out.println("Available pilots");
			for (int i = countJets() - 1; i < countPilots(); i++) {
				if (pilots[i] != null) {
					System.out.println(pilots[i]);
				}
			}
			System.out.println("Pick a pilot to assign to the jet");
			int pilotChoice = 0;
			pilotChoice = sc.nextInt();
			int pickPilotAssign = pilotChoice + countJets() - 2;
			System.out.println(pilots[pickPilotAssign] + " has been assigned");
			pilots[countJets() - 1] = pilots[pickPilotAssign];
		} else {
			System.out.println("There are no free pilots, enlist some more!\n");
		}
	}

	private void addPilot() {
		Pilots newPilot = null;
		System.out.println("What is the name of the pilot");
		String pilotName = sc.next();
		System.out.println("How many years experience does the pilot have?");
		double pilotExperience = sc.nextDouble();
		newPilot = new Pilots(pilotName, pilotExperience);
		for (int i = 0; i < pilots.length; i++) {
			if (pilots[i] == null) {
				pilots[i] = newPilot;
				System.out.println("You added:" + newPilot);
				break;
			}
		}
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
			System.out.println("The fastest jet is (speed in MPH) : " + fastestJet);
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
			DecimalFormat df = new DecimalFormat("#.00");
			String numberAsString = df.format(speedInMach(fastestJet));
			System.out.println("The fastest jet is (speed in mach) : " + fastestJet.getClass().getSimpleName()
					+ " [Model: " + fastestJet.getModel() + ", Speed: " + numberAsString + ", Range: "
					+ fastestJet.getRange() + ", Price:" + fastestJet.getPrice() + "]");
			break;
		}
	}

	private void dogfight() {
		System.out.println("A virus spreads and all pilots go crazy");
		int jetsLeft = jets.length;
		do {
			for (int i = 0; i < jets.length - 1; i++) {
				if (jets[i] == null) {
					continue;
				}
				if (jets[i] instanceof FighterJet) {
					Jets fighter = jets[i];
					for (int j = 0; j < jets.length; j++) {
						if (jets[j] == null || jets[i] == jets[j]) {
							continue;
						}
						System.out.println(fighter.getClass().getSimpleName() + " " + fighter.getModel()
								+ " shoots down " + jets[j].getClass().getSimpleName() + " " + jets[i].getModel());
						jets[j] = null;
						jetsLeft--;
						break;
					}
				}
			}
		} while (jetsLeft > 1);
	}

	private double speedInMach(Jets speedMach) {
		double speedInMach = speedMach.getSpeed() / 767.269;
		return speedInMach;
	}

}
