package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Passagem {
	// Atributos
	private int id;
	private String tipoPacote;
	private LocalDate dataEmbarque;
	private LocalDate dataRetorno;
	private String Qtd_dias;
	private double valor_pacote;

	private Usuarios usuarios;
	private Hospedagem hospedagem;
	private Destino destino;

	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
	// Construtores
	public Passagem() {

	}

	public Passagem(int id, String tipoPacote, String dataEmbarque, String dataRetorno, String qtd_dias,
			Double valor_pacote, Usuarios usuarios, Hospedagem hospedagem, Destino destino) {
		this.id = id;
		this.tipoPacote = tipoPacote;		
		this.dataEmbarque = LocalDate.parse(dataEmbarque, formatter);
		this.dataRetorno = LocalDate.parse(dataRetorno, formatter);
		this.Qtd_dias = qtd_dias;
		valor_pacote(hospedagem.getPrecoHosped());
		valor_pacote(destino.getPrecoDestino());
	}

	// gettes e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoPacote() {
		return tipoPacote;
	}

	public void setTipoPacote(String tipoPacote) {
		this.tipoPacote = tipoPacote;
	}

	// convertendo data do tipo LocalDate (yyyy-MM-dd) para String (dd/MM/yyyy)
	public String getDataEmbarque() {
		return formatter.format(dataEmbarque);
	}

	public void setDataEmbarque(String dataEmbarque) {
		this.dataEmbarque = LocalDate.parse(dataEmbarque, formatter);
	}

	public String getDataRetorno() {
		return formatter.format(dataRetorno);
	}

	public void setDataRetorno(String dataRetorno) {
		this.dataRetorno = LocalDate.parse(dataRetorno, formatter);
	}

	public String getQtd_dias() {
		return Qtd_dias;
	}

	public void setQtd_dias(String qtd_dias) {
		Qtd_dias = qtd_dias;
	}

	public double getValor_pacote() {
		return valor_pacote;
	}

	public void setValor_pacote(double valor_total) {
		this.valor_pacote= valor_total;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Passagem [id= " + id + ", Qtd_dias= " + Qtd_dias + ", tipo de pacote= " + tipoPacote + ", data de embarque= "
				+ dataEmbarque + ", data de retorno= " + dataRetorno + ", preco da compra do pacote= " + valor_pacote + ", usuarios = "
				+ usuarios + ", hospedagem= " + hospedagem + ", destino= " + destino + ", formatter= " + formatter + "]";
	}
	
	private void valor_pacote(double valor_total) {
		this.valor_pacote= hospedagem.getPrecoHosped() + destino.getPrecoDestino();
		
	}

	}
	
	
	
