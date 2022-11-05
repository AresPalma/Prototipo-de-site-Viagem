package br.com.agencia.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Hospedagem")
public class Hospedagem implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
    private String nome;

	@Column(nullable = false, length = 15)
	private String telefone;

    @Column(nullable = false, length = 80, unique = true)
    private String email;

	@Column(nullable = false, length = 90, unique = true)
	private String logradouro;

	@Column
	private String cidade;

	@Column
	private String estado;
	
	@Column
	private String pais;
	
	@Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private double valorDiaria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "hospedagem")
	private List<Promo> pacotes = new ArrayList<Promo>();
			 
	public Hospedagem() {
		super();
				
	}
	
	public Hospedagem(Long id, String nome, String telefone, String email, String logradouro, String cidade,
			String estado, String pais, int valorDiaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.valorDiaria = valorDiaria;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	public List<Promo> getPacotes() {
		return pacotes;
	}	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cidade, email, estado, id, logradouro, nome, pais, telefone, valorDiaria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospedagem other = (Hospedagem) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(email, other.email)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(nome, other.nome)
				&& Objects.equals(pais, other.pais) && Objects.equals(telefone, other.telefone)
				&& valorDiaria == other.valorDiaria;
	}

	@Override
	public String toString() {
		return "Hospedagem [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", logradouro=" + logradouro + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais
				+ ", valorDiaria=" + valorDiaria + "]";
	}

}
