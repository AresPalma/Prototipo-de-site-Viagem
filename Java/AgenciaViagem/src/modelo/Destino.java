package modelo;

public class Destino {
	private int id;
	private String nome;
	private String origem;
	private String tipoDestino;
	private double precoDestino;

	private Companhias companhias;

	// Construtores
	public Destino() {
	}

	public Destino(int id, String nome, String origem, String tipoDestino, double precoDestino,
			Companhias companhias) {
		this.id = id;
		this.nome = nome;
		this.origem = origem;
		this.tipoDestino = tipoDestino;
		this.precoDestino = precoDestino;
		this.companhias = companhias;
	}

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

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getTipoDestino() {
		return tipoDestino;
	}

	public void setTipoDestino(String tipo_destino) {
		this.tipoDestino = tipo_destino;
	}

	public double getPrecoDestino() {
		return precoDestino;
	}

	public void setPrecoDestino(double precoDestino) {
		this.precoDestino = precoDestino;
	}

	public Companhias getCompanhias() {
		return companhias;
	}

	public void setCompanhias(Companhias companhias) {
		this.companhias = companhias;
	}

	public String mostrar() {
	return "Destino \n[id: " + this.id + "Tipo_destino: " + this.tipoDestino
		    + "Origem: " + this.origem
			+ "Nome do destino" + this.nome 			
			+ "Preço do voo: " + this.precoDestino
			+ "Companhia Aérea" + this.companhias +"]";
	}

	
}
