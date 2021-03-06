package com.scm.gsoft.domain.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase generated by hbm2java
 */
@Entity
@Table(name = "clase")
public class Clase implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "cod_clase")
	private String codClase;
	
	@Column(name = "descrip_clase")
	private String descripClase;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	public Clase() {
	}

	public Clase(String codClase) {
		this.codClase = codClase;
	}

	public Clase(String codClase, String descripClase, Character statReg, String usuario, Date fechaIngreso) {
		this.codClase = codClase;
		this.descripClase = descripClase;
		this.statReg = statReg;
		this.usuario = usuario;
		this.fechaIngreso = fechaIngreso;
	}

	public Long getCia() {
		return this.cia;
	}

	public void setCia(Long cia) {
		this.cia = cia;
	}

	public String getCodClase() {
		return this.codClase;
	}

	public void setCodClase(String codClase) {
		this.codClase = codClase;
	}

	public String getDescripClase() {
		return this.descripClase;
	}

	public void setDescripClase(String descripClase) {
		this.descripClase = descripClase;
	}

	public Character getStatReg() {
		return this.statReg;
	}

	public void setStatReg(Character statReg) {
		this.statReg = statReg;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
