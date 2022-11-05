package br.com.agencia.model;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "Promo")
public class Promo implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
    @Column(nullable = false)
	private String tipoPacote;	
	
    @Column(name = "data_embarque", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataEmbarque;

    @Column(name = "data_retorno")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataRetorno;
    
    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private double precoTotal;
		
	public Promo() {
		super();
	} 
    public Promo(Long id, String tipoPacote, LocalDate dataEmbarque, LocalDate dataRetorno, double precoTotal,
			Cliente cliente, Passagem passagem, Hospedagem hospedagem) {
		super();
		this.id = id;
		this.tipoPacote = tipoPacote;
		this.dataEmbarque = dataEmbarque;
		this.dataRetorno = dataRetorno;
		this.precoTotal = precoTotal;
		this.cliente = cliente;
		this.passagem = passagem;
		this.hospedagem = hospedagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id_fk", nullable = false)
    private Cliente cliente;
		
	@ManyToOne
	@JoinColumn(name = "Passagem_id")
	private Passagem passagem;
	
	@ManyToOne
	@JoinColumn(name = "Hospedagem_id")
	private Hospedagem hospedagem;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoPacote() {
		return tipoPacote;
	}
	public void setTipoPacote(String tipoPacote) {
		this.tipoPacote = tipoPacote;
	}
	public LocalDate getDataEmbarque() {
		return dataEmbarque;
	}
	public void setDataEmbarque(LocalDate dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}
	public LocalDate getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Passagem getPassagem() {
		return passagem;
	}
	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

