package model;

public class Specie {

	private String name;
	private String scienceName;
	private String migratory;
	private TypeSpecie type;

	public Specie(String name, String scienceName, String migratory, int type) {
		this.name = name;
		this.scienceName = scienceName;
		this.migratory = migratory;
		switch (type) {
		case 1:
			this.type = TypeSpecie.TETRESTIAL_FLORA;
			break;
		case 2:
			this.type = TypeSpecie.ACUATIC_FLORA;
			break;
		case 3:
			this.type = TypeSpecie.BIRD;
			break;
		case 4:
			this.type = TypeSpecie.MAMMAL;
			break;
		case 5:
			this.type = TypeSpecie.ACUATIC_FAUNA;
			break;
		}

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
	 * @return String return the scienceName
	 */
	public String getScienceName() {
		return scienceName;
	}

	/**
	 * @param scienceName the scienceName to set
	 */
	public void setScienceName(String scienceName) {
		this.scienceName = scienceName;
	}

	/**
	 * @return boolean return the migratory
	 */
	public String isMigratory() {
		return migratory;
	}

	/**
	 * @param migratory the migratory to set
	 */
	public void setMigratory(String migratory) {
		this.migratory = migratory;
	}

	/**
	 * @return String return the type
	 */
	public TypeSpecie getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeSpecie type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "\nSpecie:" + name + "\nScience name:" + scienceName;

	}

}