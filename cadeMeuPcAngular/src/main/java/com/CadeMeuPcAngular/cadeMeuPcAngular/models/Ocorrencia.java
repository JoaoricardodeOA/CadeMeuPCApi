package com.CadeMeuPcAngular.cadeMeuPcAngular.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ocorrencia implements Comparable<Ocorrencia>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String prestador;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date mes;
	
	private Double valor;
	private String nF;
	@ManyToOne
	private Equipamento equipamento;
	private String problema;
	private String  oS;
	private boolean fonte;
	private boolean situacao;
	
	public Ocorrencia(String prestador, Date mes, Equipamento equipamento, String problema, Boolean fonte ) {
		this.prestador = prestador;
		this.mes = mes;
		this.equipamento = equipamento;
		this.problema = problema;
		this.fonte = fonte;
		this.situacao = true;
	}
	
	public Ocorrencia(){
		
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public void setFonte(boolean fonte) {
		this.fonte = fonte;
	}

	public String getPrestador() {
		return prestador;
	}

	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}

	public Date getMes() {
		return mes;
	}

	public void setMes(Date mes) {
		this.mes = mes;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String  getnF() {
		return nF;
	}

	public void setnF(String  nF) {
		this.nF = nF;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String  getoS() {
		return oS;
	}

	public void setoS(String  oS) {
		this.oS = oS;
	}

	public Boolean getFonte() {
		return fonte;
	}

	public void setFonte(Boolean fonte) {
		this.fonte = fonte;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Ocorrencia [id=" + id + ", prestador=" + prestador + ", Mes=" + mes + ", valor=" + valor + ", nF=" + nF
				+ ", equipamento=" + equipamento + ", problema=" + problema + ", oS=" + oS + ", fonte=" + fonte + "]";
	}

	@Override
	public int compareTo(Ocorrencia o) {
		if(this.mes.compareTo(o.mes)>0) {
			return -1;
		}else if(this.mes.compareTo(o.mes)<0) {
			return 1;
		}else {
			return 0;
		}
	}
	
}
