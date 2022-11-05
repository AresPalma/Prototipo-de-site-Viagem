package br.com.agencia.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cliente")

	public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
    private String nome;
	
	@Column(nullable = false, length = 15)
	private String genero;


    @Column(nullable = false, length = 14, unique = true)
    private String cpf;
	
	@Column(nullable = false, length = 15)
	private String telefone;

    @Column(nullable = false, length = 80, unique = true)
    private String email;
    
	@Column(nullable = false, length = 8, unique = true)
	private String cep;
	
    @Column(nullable = false)
    private String senha;	
    
	public Cliente() {
	}

	public Cliente(Long id, String nome,String genero, String cpf, String telefone, String email, String cep, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero= genero;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, cpf, email, genero, id, nome, senha, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha)
				&& Objects.equals(telefone, other.telefone);
	}

		
}
