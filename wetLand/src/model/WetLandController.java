package model;

import model.*;
public class WetLandController {


private WetLand[] wetLands;




    public WetLandController(){

        wetLands = new WetLand[80];
    }

   
    public boolean registerWetLand(String name,String size, int type, int zoneLocation,String protectedArea) {

		boolean stopFlag = false;

		WetLand myWetLand = new WetLand(name, size, type,zoneLocation,protectedArea);

		for (int i = 0; i < wetLands.length && !stopFlag; i++) {

			if (wetLands[i] == null) {
                myWetLand.setId((i + 1) + "");
				wetLands[i] = myWetLand;
				stopFlag = true;

			}

		}

		return stopFlag;

	}
    public boolean registerSpecie(String wetlandID, String name, String scienceName, String migratory, int type){

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

	public boolean registerEvent(String wetlandID,int type,String organizer, double price, String description,int day,int month,int year){
		boolean stopFlag = false;

		for (int i = 0; i < wetLands.length && !stopFlag; i++) {

			if (wetLands[i] != null) {

				if ((i + 1 + "").equals(wetlandID)){
					stopFlag = wetLands[i].addEvents(type, organizer, price, description, day, month, year);
				}
			}
		}

		return stopFlag;
	}

    public String showWetLandList() {

		String msg = "";

		for (int i = 0; i < wetLands.length; i++) {

			if (wetLands[i] != null) {

				msg += "\n" + wetLands[i].getId() + ". " + wetLands[i].getName();
			}
		}

		return msg;

	}


	public String showWetlands() {

		String msg = "";

		for (int i = 0; i < wetLands.length; i++) {

			if (wetLands[i] != null) {

				msg += "\n" + wetLands[i].toString();
			}
		}

		return msg;

	}

	public String showSpecies(String name){
		String msg = "";
		
		for (int i = 0; i < wetLands.length; i++){
			if(wetLands[i]!=null){
				if(wetLands[i].nameWetland(name).equals("")){
				msg += "There are no wetlands with this species";
				}else{
				msg += "\nThe Wetland: "+wetLands[i].nameWetland(name)+" Have the Specie "+name;
				}
			}
			
		}
		return msg;
	}

	public String showMaintenance(int year){
		String msg = "";

		for(int i = 0; i < wetLands.length; i++){
			if (wetLands[i]!=null){
				msg += "\nWetland name "+wetLands[i].getName()+"\nQuantity of Maintenance in the year "+year+" are: "+wetLands[i].wetlandMaintenance(year);
			}
		}
		return msg;
	}

	public String showWetlandMaxFauna(){
		String msg = "";
		int max = 0;
		for (int i = 0; i < wetLands.length; i++){
			if (wetLands[i]!=null){
				if(wetLands[i].wetlandMaxFauna()>max){
					max = wetLands[i].wetlandMaxFauna();
					msg = wetLands[i].getName();
				}
			}
		}
		return msg;
	}

	public String showWetlandLeastFlora(){
		String msg = "";
		int min = 100;

		for (int i= 0; i < wetLands.length; i++){
			if (wetLands[i]!=null){
				if (wetLands[i].wetlandLeastFlora()<min){
					min = wetLands[i].wetlandLeastFlora();
					msg = wetLands[i].getName();
				}
			}
		}
		return msg;
	}

	public void sumPerType(){
		for (int i = 0; i < wetLands.length; i++){
			if (wetLands[i]!=null){
				wetLands[i].setFloraTerrestrial(wetLands[i].sumWetlandTerrestrialFlora());
				wetLands[i].setFloraAquatic(wetLands[i].sumWetLandFloraAquatic());
				wetLands[i].setFaunaMammal(wetLands[i].sumWetLandFaunaMammal());
				wetLands[i].setFaunaBird(wetLands[i].sumWetLandFaunaBird());
				wetLands[i].setFaunaAquatic(wetLands[i].sumWetLandFaunaAquatic());
			}
		}
		
	}


	public String showWetLandsInfo(){
		String msg = "";
		sumPerType();
			for (int i = 0; i < wetLands.length; i++){
				if (wetLands[i]!=null){
					msg += wetLands[i].toString();
				}
			}
			return msg;
	}


}
		
		
	
			
	





		