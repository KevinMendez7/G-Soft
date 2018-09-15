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
 * Estanterias generated by hbm2java
 */
@Entity
@Table(name = "estanterias")
public class Estanterias implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "estanteria")
	private String estanteria;
	
	@Column(name = "no_ubicaciones")
	private String noUbicaciones;
	
	@Column(name = "filas")
	private String filas;
	
	@Column(name = "bodega")
	private String bodega;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	public Estanterias() {
	}

	public Estanterias(String estanteria, String noUbicaciones, String filas, String bodega, Character statReg,
			String usuario, Date fechaIngreso) {
		this.estanteria = estanteria;
		this.noUbicaciones = noUbicaciones;
		this.filas = filas;
		this.bodega = bodega;
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

	public String getEstanteria() {
		return this.estanteria;
	}

	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}

	public String getNoUbicaciones() {
		return this.noUbicaciones;
	}

	public void setNoUbicaciones(String noUbicaciones) {
		this.noUbicaciones = noUbicaciones;
	}

	public String getFilas() {
		return this.filas;
	}

	public void setFilas(String filas) {
		this.filas = filas;
	}

	public String getBodega() {
		return this.bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
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
