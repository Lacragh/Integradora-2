package model;

public class WetLand {
	private String name;
	private String size;
	private TypeWetland type;
	private String protectedArea;
	private LocationZone zoneLocation;
	private String id;
	private Specie[] species;
	private Event[] event;
	private int floraTerrestrial;
	private int floraAquatic;
	private int faunaMammal;
	private int faunaAquatic;
	private int faunaBird;
	private int maintenance;

	public WetLand(String name, String size, int type, int zoneLocation, String protectedArea) {
		this.setFloraAquatic(0);
		this.setFloraTerrestrial(0);
		this.setFaunaMammal(0);
		this.setFaunaAquatic(0);
		this.setFaunaBird(0);
		this.maintenance = 0;
		this.id = "";
		this.name = name;
		this.size = size;
		species = new Specie[50];
		event = new Event[50];
		switch (type) {
		case 1:
			this.type = TypeWetland.PRIVATE;
			break;

		case 2:
			this.type = TypeWetland.PUBLIC;
			break;
		}
		this.protectedArea = protectedArea;

		switch (zoneLocation) {
		case 1:
			this.zoneLocation = LocationZone.RURAL;
			break;
		case 2:
			this.zoneLocation = LocationZone.URBAN;
			break;
		}

	}

	public Event[] getEvent() {
		return event;
	}

	public void setEvent(Event[] event) {
		this.event = event;
	}

	public int getFaunaBird() {
		return faunaBird;
	}

	public void setFaunaBird(int faunaBird) {
		this.faunaBird = faunaBird;
	}

	public int getFaunaAquatic() {
		return faunaAquatic;
	}

	public void setFaunaAquatic(int faunaAquatic) {
		this.faunaAquatic = faunaAquatic;
	}

	public int getFaunaMammal() {
		return faunaMammal;
	}

	public void setFaunaMammal(int faunaMammal) {
		this.faunaMammal = faunaMammal;
	}

	public int getFloraAquatic() {
		return floraAquatic;
	}

	public void setFloraAquatic(int floraAquatic) {
		this.floraAquatic = floraAquatic;
	}

	public int getFloraTerrestrial() {
		return floraTerrestrial;
	}

	public void setFloraTerrestrial(int floraTerrestrial) {
		this.floraTerrestrial = floraTerrestrial;
	}

	public boolean addEvents(int type, String organizer, double price, String description, int day, int month,
			int year) {
		boolean stopFlag = false;

		Event myEvent = new Event(type, organizer, price, description, day, month, year);

		for (int i = 0; i < event.length && !stopFlag; i++) {
			if (event[i] == null) {
				event[i] = myEvent;
				stopFlag = true;
			}
		}

		return stopFlag;
	}

	public boolean addSpecies(String name, String scienceName, String migratory, int type) {

		boolean stopFlag = false;

		Specie mySpecie = new Specie(name, scienceName, migratory, type);

		for (int i = 0; i < species.length && !stopFlag; i++) {

			if (species[i] == null) {

				species[i] = mySpecie;
				stopFlag = true;

			}

		}

		return stopFlag;

	}

	/**
	 * @return String return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return String return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return boolean return the protectedArea
	 */
	public String isProtectedArea() {
		return protectedArea;
	}

	/**
	 * @param protectedArea the protectedArea to set
	 */
	public void setProtectedArea(String protectedArea) {
		this.protectedArea = protectedArea;
	}

	public String amountEvents() {
		String msg = "";

		msg += "\n|----------------------------------------------|";
		msg += "\n| Wetland Name:" + name + "|";
		msg += "\n| Quantity of Maintenance in this year" + maintenance + "|";
		msg += "\n|                                                       |";

		return msg;
	}

	@Override
	public String toString() {

		String msg = "";

		msg += "\n|-----------------------------------------|";
		msg += "\n| Wetland Name: " + name + "                         |";
		msg += "\n| Quantity of Terrestrial Flora: " + floraTerrestrial + "        |";
		msg += "\n| Quantity of Aquatic Flora: " + floraAquatic + "            |";
		msg += "\n| Quantity of Mammals: " + faunaMammal + "                  |";
		msg += "\n| Quantity of Birds: " + faunaBird + "                    |";
		msg += "\n| Quantity of Aquatic Fauna: " + faunaAquatic + "            |";
		return msg;
	}

	public String nameWetland(String name) {
		String msg = "";
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if (species[i].getName().equals(name)) {

					msg += this.name;
				} else {
					msg += "";
				}
			}
		}
		return msg;
	}

	public int wetlandMaxFauna() {

		int sum = 0;

		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if ((species[i].getType().equals(TypeSpecie.ACUATIC_FAUNA)
						| (species[i].getType().equals(TypeSpecie.BIRD)
								| (species[i].getType().equals(TypeSpecie.MAMMAL))))) {
					sum += 1;

				}
			}

		}
		return sum;
	}

	public int wetlandMaintenance(int year) {
		int sum = 0;

		for (int i = 0; i < event.length; i++) {
			if (event[i] != null) {
				if (event[i].getDate() == year) {
					sum += 1;
				}
			}
		}
		return sum;
	}

	public int wetlandLeastFlora() {
		int sum = 0;
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if ((species[i].getType().equals(TypeSpecie.TETRESTIAL_FLORA)
						| (species[i].getType().equals(TypeSpecie.ACUATIC_FLORA)))) {
					sum += 1;
				}
			}

		}
		return sum;
	}

	public int sumWetlandTerrestrialFlora() {
		int sum = 0;
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if ((species[i].getType().equals(TypeSpecie.TETRESTIAL_FLORA))) {
					sum += 1;
				}
			}

		}
		return sum;
	}

	public int sumWetLandFloraAquatic() {
		int sum = 0;
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if ((species[i].getType().equals(TypeSpecie.ACUATIC_FLORA))) {
					sum += 1;
				}
			}

		}
		return sum;
	}

	public int sumWetLandFaunaMammal() {
		int sum = 0;

		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if ((species[i].getType().equals(TypeSpecie.MAMMAL))) {
					sum += 1;
				}
			}

		}
		return sum;
	}

	public int sumWetLandFaunaBird() {
		int sum = 0;

		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if ((species[i].getType().equals(TypeSpecie.BIRD))) {
					sum += 1;
				}
			}

		}
		return sum;
	}

	public int sumWetLandFaunaAquatic() {
		int sum = 0;

		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				if ((species[i].getType().equals(TypeSpecie.ACUATIC_FAUNA))) {
					sum += 1;
				}
			}

		}
		return sum;
	}

	/**
	 * @return TypeWetland return the type
	 */
	public TypeWetland getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeWetland type) {
		this.type = type;
	}

	/**
	 * @return LocationZone return the zoneLocation
	 */
	public LocationZone getZoneLocation() {
		return zoneLocation;
	}

	/**
	 * @param zoneLocation the zoneLocation to set
	 */
	public void setZoneLocation(LocationZone zoneLocation) {
		this.zoneLocation = zoneLocation;
	}

	/**
	 * @return String return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return String return the protectedArea
	 */
	public String getProtectedArea() {
		return protectedArea;
	}

	/**
	 * @return Specie[] return the species
	 */
	public Specie[] getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(Specie[] species) {
		this.species = species;
	}

}
