package br.com.agencia.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Passagem")
public class Passagem implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
    private String destino;

	@Column(nullable = false, length = 15)
	private String origem;

    @Column(nullable = false, length = 80, unique = true)
    private String tipoDest;
    
    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private double valorPass;
    
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "companhia_id_fk", nullable = false)
   private Companhias companhias;
   
   @JsonIgnore
	@OneToMany(mappedBy = "passagem")
	private List<Promo> pacotes = new ArrayList<Promo>();
			 

	public Passagem() {
		super();
	}

	public Passagem(Long id, String destino, String origem, String tipoDest, double valorPass) {
		super();
		this.id = id;
		this.destino = destino;
		this.origem = origem;
		this.tipoDest = tipoDest;
		this.valorPass = valorPass;
	
	}

		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getTipoDest() {
		return tipoDest;
	}

	public void setTipoDest(String tipoDest) {
		this.tipoDest = tipoDest;
	}

	public double getValorPass() {
		return valorPass;
	}

	public void setValorPass(double valorPass) {
		this.valorPass = valorPass;
	}

	public Companhias getCompanhias() {
		return companhias;
	}

	public void setCompanhias(Companhias companhias) {
		this.companhias = companhias;
	}

	public List<Promo> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Promo> pacotes) {
		this.pacotes = pacotes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, id, origem, tipoDest, valorPass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(id, other.id)
				&& Objects.equals(origem, other.origem) && Objects.equals(tipoDest, other.tipoDest)
				&& Double.doubleToLongBits(valorPass) == Double.doubleToLongBits(other.valorPass);
	}

	@Override
	public String toString() {
		return "Passagem [id=" + id + ", destino=" + destino + ", origem=" + origem + ", tipoDest=" + tipoDest
				+ ", valorPass=" + valorPass + "]";
	}

}

