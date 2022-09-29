package modelo;

public class Usuarios {
	// Atributos
	private int id;
	private String nome;
	private String cpf;
	private String tel;
	private String cep;
	private String email;
	private String senha;

	private Permissoes permissoes;

	public Usuarios() {

	}

	public Usuarios(int id, String nome, String cpf, String tel, String cep,String email, String senha, Permissoes permissoes) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.tel = tel;
		this.cep = cep;
		this.email = email;
		this.senha = senha;
		this.permissoes = permissoes;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTel() {
		return tel;
	}
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Permissoes getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Permissoes permissoes) {
		this.permissoes = permissoes;
	}

		public String mostrar() {
		return "id: " + this.id + "Nome" + this.nome 
				+ "CPF: " + this.cpf
				+ "Telefone: " + this.tel
				+ "Email: " + this.email 
				+ "senha" + this.senha
				+ "Tipo permissão: " + this.permissoes.getTipo();
	}
				
		}

		
			
	


