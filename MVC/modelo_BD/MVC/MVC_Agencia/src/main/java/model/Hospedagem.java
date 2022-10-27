package model;

//variavéis
public class Hospedagem {
	private int id;
	private String nome;
	private String tel;
	private String cidadeEstado;
	private String logradouro;
	private double precoHosped;

	//Construtores
	public Hospedagem() {

	}

	public Hospedagem(int id, String nome,String tel, String cidadeEstado, String logradouro, double precoHosped) {
		this.id = id;
		this.nome = nome;
		this.tel = tel;
		this.cidadeEstado = cidadeEstado;
		this.logradouro = logradouro;
		this.precoHosped = precoHosped;
	}

	//Getts ne Settrs
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCidadeEstado() {
		return cidadeEstado;
	}

	public void setCidadeEstado(String cidadeEstado) {
		this.cidadeEstado = cidadeEstado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public double getPrecoHosped() {
		return precoHosped;
	}

	public void setPrecoHosped(double precoHosped) {
		this.precoHosped = precoHosped;
	}
	
	public String mostrar() {
		return "Hospedagem \n[id: " + this.id + "nome do hotel: " + this.nome
			    + "Telefone: " + this.tel
				+ "Cidade/Estado/pais" + this.cidadeEstado		
				+ "Logradouro: " + this.logradouro
				+ "Preco da acomodação/diaria" + this.precoHosped+"]";
		}
	}