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
 * MaebodPrecios generated by hbm2java
 */
@Entity
@Table(name = "maebod_precios")
public class MaebodPrecios implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "cod_art")
	private String codArt;
	
	@Column(name = "anio")
	private String anio;
	
	@Column(name = "bodega")
	private String bodega;
	
	@Column(name = "nopieza")
	private String noPieza;
	
	@Column(name = "precio_min")
	private Float precioMin;
	
	@Column(name = "precio_max")
	private Float precioMax;
	
	@Column(name = "desc_min")
	private Float descMin;
	
	@Column(name = "desc_max")
	private Float descMax;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name = "observaciones")
	private String observaciones;

	public MaebodPrecios() {
	}

	public MaebodPrecios(String codArt, String anio, String bodega, String noPieza, Float precioMin, Float precioMax,
			Float descMin, Float descMax, Character statReg, String usuario, Date fechaIngreso, String observaciones) {
		this.codArt = codArt;
		this.anio = anio;
		this.bodega = bodega;
		this.noPieza = noPieza;
		this.precioMin = precioMin;
		this.precioMax = precioMax;
		this.descMin = descMin;
		this.descMax = descMax;
		this.statReg = statReg;
		this.usuario = usuario;
		this.fechaIngreso = fechaIngreso;
		this.observaciones = observaciones;
	}

	public Long getCia() {
		return this.cia;
	}

	public void setCia(Long cia) {
		this.cia = cia;
	}

	public String getCodArt() {
		return this.codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getBodega() {
		return this.bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public String getNoPieza() {
		return this.noPieza;
	}

	public void setNoPieza(String noPieza) {
		this.noPieza = noPieza;
	}

	public Float getPrecioMin() {
		return this.precioMin;
	}

	public void setPrecioMin(Float precioMin) {
		this.precioMin = precioMin;
	}

	public Float getPrecioMax() {
		return this.precioMax;
	}

	public void setPrecioMax(Float precioMax) {
		this.precioMax = precioMax;
	}

	public Float getDescMin() {
		return this.descMin;
	}

	public void setDescMin(Float descMin) {
		this.descMin = descMin;
	}

	public Float getDescMax() {
		return this.descMax;
	}

	public void setDescMax(Float descMax) {
		this.descMax = descMax;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
