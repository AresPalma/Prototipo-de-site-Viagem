package modelo;

public class Permissoes {

	// Atributos
	private int id;
	private String tipo;
	
	// construtor
	public Permissoes() {
	}
	public Permissoes(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	// Gets e Sets

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
	
}
