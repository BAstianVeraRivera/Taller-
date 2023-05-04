package model;

public class Cafe {
	private String nombreCafe;
	private int gramosCafe;
	private int mililitros;
	private String tamaño;
	private String ingredientesOpcionales;


	public Cafe(String nombreCafe, int gramosCafe, int mililitros, String tamaño, String ingredientesOpcionales) {
		this.nombreCafe=nombreCafe;
		this.gramosCafe = gramosCafe;
		this.mililitros = mililitros;
		this.tamaño = tamaño;
		this.ingredientesOpcionales = ingredientesOpcionales;
	}
	public String toString(){
		return "\n Nombre del café: "+this.nombreCafe+"\n Gramos de cafe (en gramos): "+this.gramosCafe+"\n Mililitros: "+this.mililitros+"\n Tamaño (pequeño, mediano, grande): "+this.tamaño+"\n Ingredintes Opcionales (Crema, leche, chocolate): "+this.ingredientesOpcionales;
	}

	public String getNombreCafe() {return nombreCafe;}

	public void setNombreCafe(String nombreCafe) {this.nombreCafe = nombreCafe;}

	public int getGramosCafe() {
		return this.gramosCafe;
	}

	public void setGramosCafe(int gramosCafe) {
		this.gramosCafe = gramosCafe;
	}

	public int getMililitros() {
		return this.mililitros;
	}

	public void setMililitros(int mililitros) {
		this.mililitros = mililitros;
	}

	public String getTamaño() {
		return this.tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public String getIngredientesOpcionales() {
		return this.ingredientesOpcionales;
	}

	public void setIngredientesOpcionales(String ingredientesOpcionales) {
		this.ingredientesOpcionales = ingredientesOpcionales;
	}
}