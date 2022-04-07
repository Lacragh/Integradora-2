package model;

import model.*;

public class WetLandController {

	private WetLand[] wetLands;

	public WetLandController() {

		wetLands = new WetLand[80];
	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo registerWetLand me permite crear un humedal y asignarle su respectiva id.
	 * 
	 * <strong>Inputs:</strong> String name, String size, int type, int zoneLocation, String protectedArea,double myPlan,String url <strong>
	 * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo crear el humedal.
	 * </pre>
	 */

	public boolean registerWetLand(String name, String size, int type, int zoneLocation, String protectedArea,double myPlan,String url) {

		boolean stopFlag = false;

		WetLand myWetLand = new WetLand(name, size, type, zoneLocation, protectedArea,myPlan,url);

		for (int i = 0; i < wetLands.length && !stopFlag; i++) {

			if (wetLands[i] == null) {
				myWetLand.setId((i + 1) + "");
				wetLands[i] = myWetLand;
				stopFlag = true;

			}

		}

		return stopFlag;

	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo registerSpecie me permite agregar un objeto especie a mi arreglo de wetlands dependiendo de la id del wetland.
	 * 
	 * <strong>Inputs:</strong> String wetlandID, String name, String scienceName, String migratory, int type <strong>
	 * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo agregar la especie al humedal especifico.
	 * </pre>
	 */


	public boolean registerSpecie(String wetlandID, String name, String scienceName, String migratory, int type) {

		boolean stopFlag = false;

		for (int i = 0; i < wetLands.length && !stopFlag; i++) {

			if (wetLands[i] != null) {

				if ((i + 1 + "").equals(wetlandID)) {

					stopFlag = wetLands[i].addSpecies(name, scienceName, migratory, type);

				}

			}

		}

		return stopFlag;

	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo registerEvents permite agregar un objeto evento a mi arreglo wetlands dependiendo de la id del humedal.
	 * 
	 * <strong>Inputs:</strong> String wetlandID, int type, String organizer, double price, String description,
			int day, int month, int year  <strong>
	 * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo agregar el evento a mi arreglo de humedal.
	 * </pre>
	 */

	public boolean registerEvent(String wetlandID, int type, String organizer, double price, String description,
			int day, int month, int year) {
		boolean stopFlag = false;

		for (int i = 0; i < wetLands.length && !stopFlag; i++) {

			if (wetLands[i] != null) {

				if ((i + 1 + "").equals(wetlandID)) {
					stopFlag = wetLands[i].addEvents(type, organizer, price, description, day, month, year);
				}
			}
		}

		return stopFlag;
	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showWetLandList permite mostrarme los humedales creados con su respectiva id.
	 * 
	 * <strong>Inputs:</strong> No aplica <strong>
	 * Outputs:</strong> me retorna un mensaje con los id de los humedales y los nombres.
	 * </pre>
	 */

	public String showWetLandList() {

		String msg = "";

		for (int i = 0; i < wetLands.length; i++) {

			if (wetLands[i] != null) {

				msg += "\n" + wetLands[i].getId() + ". " + wetLands[i].getName();
			}
		}

		return msg;

	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showWetlands permite mostrar la informacion de los humedales creados.
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> String msg me retorna un mensaje con la informacion de los humedales.
	 * </pre>
	 */

	public String showWetlands() {

		String msg = "";

		for (int i = 0; i < wetLands.length; i++) {

			if (wetLands[i] != null) {

				msg += "\n" + wetLands[i].toString();
			}
		}

		return msg;

	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showSpecies permite mostrar los humedales que tienen una determinada especie.
	 * 
	 * <strong>Inputs:</strong> String name  <strong>
	 * Outputs:</strong> me retorna un mensaje con el nombre del humedal que tiene determinada especie
	 * </pre>
	 */

	public String showSpecies(String name) {
		String msg = "";

		for (int i = 0; i < wetLands.length; i++) {
			if (wetLands[i] != null) {
				if (wetLands[i].nameWetland(name).equals("")) {
					msg += "There are no wetlands with this species";
				} else {
					msg += "\nThe Wetland: " + wetLands[i].nameWetland(name) + " Have the Specie " + name;
				}
			}

		}
		return msg;
	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showMaintenance permite mostrar el total de eventos que tiene un humedal en determinado año
	 * 
	 * <strong>Inputs:</strong> int year  <strong>
	 * Outputs:</strong> me retorna un mensaje con los humedales creados y sus respectivos mantenimientos en dicho año.
	 * </pre>
	 */
	
	public String showMaintenance(int year) {
		String msg = "";

		for (int i = 0; i < wetLands.length; i++) {
			if (wetLands[i] != null) {
				msg += "\nWetland name " + wetLands[i].getName() + "\nQuantity of Maintenance in the year " + year
						+ " are: " + wetLands[i].wetlandMaintenance(year);
			}
		}
		return msg;
	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showWetLandMaxFauna me hace una comparacion de el total de fauna de cada humedal y el humedal con más fauna lo guarda en un mensaje y lo muestra
	 * 
	 * <strong>Inputs:</strong>  <strong>
	 * Outputs:</strong> me retorna un mensaje con el nombre del humedal con mas especies de fauna.
	 * </pre>
	 */

	public String showWetlandMaxFauna() {
		String msg = "";
		int max = 0;
		for (int i = 0; i < wetLands.length; i++) {
			if (wetLands[i] != null) {
				if (wetLands[i].wetlandMaxFauna() > max) {
					max = wetLands[i].wetlandMaxFauna();
					msg = wetLands[i].getName();
				}
			}
		}
		return msg;
	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showWetLandLeastFlora permite hacer una comparacion entre los humedales con menos flora.
	 * 
	 * <strong>Inputs:</strong> String wetlandID, int type, String organizer, double price, String description,
			int day, int month, int year  <strong>
	 * Outputs:</strong> me retorna un mensaje con el nombre del humedal con menos flora
	 * </pre>
	 */

	public String showWetlandLeastFlora() {
		String msg = "";
		int min = 100;

		for (int i = 0; i < wetLands.length; i++) {
			if (wetLands[i] != null) {
				if (wetLands[i].wetlandLeastFlora() < min) {
					min = wetLands[i].wetlandLeastFlora();
					msg = wetLands[i].getName();
				}
			}
		}
		return msg;
	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo sumPerType permite asignar el total de especies de cada tipo a su respectivo atributo de Wetland
	 * 
	 * <strong>Inputs:</strong> No aplica <strong>
	 * Outputs:</strong> No aplica
	 * </pre>
	 */

	public void sumPerType() {
		for (int i = 0; i < wetLands.length; i++) {
			if (wetLands[i] != null) {
				wetLands[i].setFloraTerrestrial(wetLands[i].sumWetlandTerrestrialFlora());
				wetLands[i].setFloraAquatic(wetLands[i].sumWetLandFloraAquatic());
				wetLands[i].setFaunaMammal(wetLands[i].sumWetLandFaunaMammal());
				wetLands[i].setFaunaBird(wetLands[i].sumWetLandFaunaBird());
				wetLands[i].setFaunaAquatic(wetLands[i].sumWetLandFaunaAquatic());
			}
		}

	}

	/**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showWetLandsInfo permite mostrar la informacion del humedal con la cantidad total de fauna o flora de cada tipo 
	 * 
	 * <strong>Inputs:</strong>   <strong>
	 * Outputs:</strong> me retorna un mensaje con la informacion del humedal y la cantidad de especies de cada tipo.
	 * </pre>
	 */

	public String showWetLandsInfo() {
		String msg = "";
		sumPerType();
		for (int i = 0; i < wetLands.length; i++) {
			if (wetLands[i] != null) {
				msg += wetLands[i].toString();
			}
		}
		return msg;
	}

}
