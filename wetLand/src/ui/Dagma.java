package ui;

import java.io.Reader;
import java.util.Scanner;

import model.WetLandController;

public class Dagma {
	public static Scanner lector;
	public static int answerMenu;
	public static WetLandController controller;

	public static void main(String[] args) {
		init();
		menu();

	}

	public static void init() {
		lector = new Scanner(System.in);
		controller = new WetLandController();
		System.out.println("Welcome to the wetland administration");

	}

	public static void menu() {
		boolean stopflag = false;

		while (stopflag == false) {
			System.out.println("|-------------------------------------------|");
			System.out.println("|   1. Register a Wetland                   |");
			System.out.println("|   2. Register a Specie in a Wetland       |");
			System.out.println("|   3. Register a new event in a Wetland    |");
			System.out.println("|   4. Show Wetlands maintenance per Year   |");
			System.out.println("|   5. Show Wetland with least flora        |");
			System.out.println("|   6. Show Wetland with most fauna         |");
			System.out.println("|   7. Show Wetlands per Species            |");
			System.out.println("|   8. Show all Wetlands info               |");
			System.out.println("|   9. Exit                                 |");
			System.out.println("|-------------------------------------------|");
			System.out.print("Type Here ------>");
			answerMenu = lector.nextInt();

			switch (answerMenu) {

			case 1:
				System.out.println("What is the name of the wetland");
				String wetlandName = lector.next();

				System.out.println("Where is the zone location of wetland\n1. Rural\n2. Urban");
				int zoneLocation = lector.nextInt();

				System.out.println("Type the size of wetland in km2");
				String size = lector.next();

				System.out.println("Write the type of wetland\n1.Private\n2. Public");
				int type = lector.nextInt();

				System.out.println("the wetland is a protected area.Yes or No");
				String protection = lector.next();

				if (controller.registerWetLand(wetlandName, size, type, zoneLocation, protection)) {
					System.out.println("The wetland " + wetlandName + " was successfully registered");
				} else {
					System.out.println("The wetland " + wetlandName + " couldn't be registered");
				}

				break;

			case 2:
				if (controller.showWetLandList().equals("")) {
					System.out.println("There aren't any Wetlands registered.");
				} else {

					System.out.println("These are the Wetlands currently registered:" + controller.showWetLandList());

					System.out.println("Type the ID of the Wetland you want to register a Specie:");
					String wetlandID = lector.next();

					System.out.println("What is the name of specie");
					String specieName = lector.next();

					System.out.println("What is the Science name of the specie");
					String sciencename = lector.next();

					System.out.println("Is migratory (True or False)");
					String migratory = lector.next();

					System.out.println(
							"What is the type of the specie\n1.Terrestrial flora\n2.Aquatic flora\n3. Bird\n4. Mammal\n5.Aquatic fauna");
					int specieType = lector.nextInt();

					if (controller.registerSpecie(wetlandID, specieName, sciencename, migratory, specieType)) {
						System.out.println("The Specie " + specieName + " was successfully registered");
					} else {
						System.out.println("The wetland " + specieName + " couldn't be registered");
					}

				}

				break;

			case 3:
				if (controller.showWetLandList().equals("")) {
					System.out.println("There aren't any Wetlands registered.");
				} else {

					System.out.println("These are the Wetlands currently registered:" + controller.showWetLandList());

					System.out.println("Type the ID of the Wetland you want to register a Event:");
					String wetlandID = lector.next();

					System.out.println(
							"What is the type of event to register\n1. MAINTENANCE\n2. SCHOOL VISITS\n3. ACTIVITIES\n4. CELEBRATION");
					int typeEvent = lector.nextInt();

					System.out.println("Who is the organizer of the event");
					String organizer = lector.next();

					System.out.println("What is the price of the event");
					double price = lector.nextDouble();

					System.out.println("Type the description of the event");
					String descriptionEvent = lector.next();

					System.out.println("Type the date of event (YYYY-MM-DD): ");
					String foundationDate = lector.next();

					int year = Integer.parseInt(foundationDate.split("-")[0]);
					int month = Integer.parseInt(foundationDate.split("-")[1]);
					int day = Integer.parseInt(foundationDate.split("-")[2]);

					if (controller.registerEvent(wetlandID, typeEvent, organizer, price, descriptionEvent, day, month,
							year)) {
						System.out.println("The event  was successfully registered");
					} else {
						System.out.println("The event couldn't be registered");
					}

				}

				break;

			case 4:
				System.out.println("write the year to know the wetlands that have maintenance in that year");
				int year = lector.nextInt();
				System.out.println(controller.showMaintenance(year));
				break;
			case 5:
				System.out.println("The wetland with least flora is:");
				System.out.println("--------->" + controller.showWetlandLeastFlora());
				break;
			case 6:
				System.out.println("The wetland with most fauna is:");
				System.out.println(controller.showWetlandMaxFauna());
				break;

			case 7:
				System.out.println("Type the name of Specie");
				String name = lector.next();
				if (controller.showSpecies(name).equals("")) {
					System.out.println("There are no wetlands with this species");
				} else {
					System.out.println(controller.showSpecies(name));
				}

				break;
			case 8:
				System.out.println(controller.showWetLandsInfo());
				break;

			case 9:

				break;

			}

		}

	}

}