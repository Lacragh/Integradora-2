package model;

public class WetLand {
	private String name;
	private String size;
	private TypeWetland type;
	private String protectedArea;
	private LocationZone zoneLocation;
	private String id;
	private EnvironmentalManagementPlan myPlan;
	private Specie[] species;
	private Event[] event;
	private int floraTerrestrial;
	private int floraAquatic;
	private int faunaMammal;
	private int faunaAquatic;
	private int faunaBird;
	private int maintenance;
	private String url;

	public WetLand(String name, String size, int type, int zoneLocation, String protectedArea, double myPlan,
			String url) {
		this.setFloraAquatic(0);
		this.setFloraTerrestrial(0);
		this.setFaunaMammal(0);
		this.setFaunaAquatic(0);
		this.setFaunaBird(0);
		this.maintenance = 0;
		this.id = "";
		this.name = name;
		this.size = size;
		this.myPlan = new EnvironmentalManagementPlan(myPlan);
		this.url = url;
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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo addEvents me permite crear un objeto evento y hace la validacion si es posible crear un nuevo evento, para ello recorre el 
	 * arreglo con el fin de ver si una posicion esta vacia.
	 * 
	 * <strong>Inputs:</strong> int type, String organizer, double price, String description, int day, int month,
			int year <strong>Outputs:</strong> Me retorna un booleano para saber si es posible crear el evento.
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo addSpecies me permite crear un objeto especie y hace la validacion si es posible crear una nueva especie en el arreglo, para ello
	 * recorre el arreglo con el fin de ver si una posicion esta vacia.
	 * 
	 * <strong>Inputs:</strong> String name, String scienceName, String migratory, int type <strong>Outputs:</strong> Me retorna un booleano para saber si es posible crear una especie.
	 * </pre>
	 */
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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo amountEvents me permite mostrar por consola el nombre del humedal con el numero de mantenimientos en un año dado por el usuario
	 * 
	 * <strong>Inputs:</strong> No aplica  <strong>Outputs:</strong> Me retorna un mensaje con la cantidad de mantenimientos de un humedal en un año determinado.
	 * </pre>
	 */

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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo nameWetland me permite saber si dentro del arreglo de especies del humedal existe una especie igual al parametro.
	 * 
	 * <strong>Inputs:</strong> String name <strong>Outputs:</strong> Me retorna un mensaje que seria el nombre de la especie si es que el humedal tiene esa especie.
	 * </pre>
	 */

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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo wetlandMaxFauna permite hacer un conteo dentro del arreglo especies cuantos objetos tienen atributos de fauna.
	 * 
	 * <strong>Inputs:</strong> No aplica  <strong>Outputs:</strong> Me retorna la suma total de las especies tipo fauna.
	 * </pre>
	 */

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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo wetlandMaintenance permite hacer un conteo dentro del arreglo eventos cuantos eventos existen en determinado ano
	 * 
	 * <strong>Inputs:</strong> int year <strong>Outputs:</strong> Me retorna la suma total de eventos en determinado año.
	 * </pre>
	 */

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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo wetlandLeastFlora permite hacer un conteo dentro del arreglo especies cuantos objetos tienen atributos de flora.
	 * 
	 * <strong>Inputs:</strong> No aplica  <strong>Outputs:</strong> Me retorna la suma total de las especies tipo flora.
	 * </pre>
	 */

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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo sumWetlandTerrestrialFlora me permite hacer un conteo de las especies de tipo flora terrestre.
	 * 
	 * <strong>Inputs:</strong> No aplica  <strong>Outputs:</strong> Me retorna la suma total de las especies tipo flora terrestre.
	 * </pre>
	 */

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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo sumWetLandFloraAquatic me permite hacer un conteo de las especies de tipo flora acuatica.
	 * 
	 * <strong>Inputs:</strong> No aplica  <strong>Outputs:</strong> Me retorna la suma total de las especies tipo flora acuatica.
	 * </pre>
	 */

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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo sumWetLandFaunaMammal permite hacer un conteo de las especies de tipo fauna mamiferos.
	 * 
	 * <strong>Inputs:</strong> No aplica  <strong>Outputs:</strong> Me retorna la suma total de las especies tipo mamifero.
	 * </pre>
	 */

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

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo sumWetLandFaunaBird permite hacer un conteo de las especies de tipo fauna ave.
	 * 
	 * <strong>Inputs:</strong> No aplica  <strong>Outputs:</strong> Me retorna la suma total de las especies tipo ave.
	 * </pre>
	 */

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
	
	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo sumWetLandFaunaAquatic permite hacer un conteo de las especies de tipo fauna acuatica.
	 * 
	 * <strong>Inputs:</strong> No aplica  <strong>Outputs:</strong> Me retorna la suma total de las especies tipo fauna acuatica.
	 * </pre>
	 */

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


    /**
     * @return EnvironmentalManagementPlan return the myPlan
     */
    public EnvironmentalManagementPlan getMyPlan() {
        return myPlan;
    }

    /**
     * @param myPlan the myPlan to set
     */
    public void setMyPlan(EnvironmentalManagementPlan myPlan) {
        this.myPlan = myPlan;
    }

    /**
     * @return int return the maintenance
     */
    public int getMaintenance() {
        return maintenance;
    }

    /**
     * @param maintenance the maintenance to set
     */
    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    /**
     * @return String return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
