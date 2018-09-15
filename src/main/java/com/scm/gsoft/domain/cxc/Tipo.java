package com.scm.gsoft.domain.cxc;
// Generated 26/08/2018 01:38:39 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tipo generated by hbm2java
 */
@Entity
@Table(name = "tipo")
public class Tipo implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descrip")
	private String descrip;
	
	@Column(name = "transa")
	private char transa;
	
	@Column(name = "elec")
	private float elec;
	
	@Column(name = "cuenta")
	private String cuenta;
	
	@Column(name = "correlativo")
	private String correlativo;
	
	@Column(name = "clase")
	private Character clase;
	
	@Column(name = "flag")
	private boolean flag;

	public Tipo() {
	}

	public Tipo(Long cia, String codigo, String descrip, char transa, float elec, String cuenta, boolean flag) {
		this.cia = cia;
		this.codigo = codigo;
		this.descrip = descrip;
		this.transa = transa;
		this.elec = elec;
		this.cuenta = cuenta;
		this.flag = flag;
	}

	public Tipo(Long cia, String codigo, String descrip, char transa, float elec, String cuenta, String correlativo,
			Character clase, boolean flag) {
		this.cia = cia;
		this.codigo = codigo;
		this.descrip = descrip;
		this.transa = transa;
		this.elec = elec;
		this.cuenta = cuenta;
		this.correlativo = correlativo;
		this.clase = clase;
		this.flag = flag;
	}

	public Long getCia() {
		return this.cia;
	}

	public void setCia(Long cia) {
		this.cia = cia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public char getTransa() {
		return this.transa;
	}

	public void setTransa(char transa) {
		this.transa = transa;
	}

	public float getElec() {
		return this.elec;
	}

	public void setElec(float elec) {
		this.elec = elec;
	}

	public String getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCorrelativo() {
		return this.correlativo;
	}

	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}

	public Character getClase() {
		return this.clase;
	}

	public void setClase(Character clase) {
		this.clase = clase;
	}

	public boolean isFlag() {
		return this.flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
