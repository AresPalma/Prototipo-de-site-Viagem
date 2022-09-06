package modelo;

public class Companhias {
	
	private int id;
	private String nome;
	
	// constrotores
	public Companhias() {

	}

	public Companhias(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Companhias [id=" + id + ", nome=" + nome + "]";
	}

		

}
