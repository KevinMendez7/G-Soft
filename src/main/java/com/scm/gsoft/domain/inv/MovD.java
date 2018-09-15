package com.scm.gsoft.domain.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MovD generated by hbm2java
 */
@Entity
@Table(name = "mov_d")
public class MovD implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "cod_art")
	private String codArt;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "medida")
	private String medida;

	public MovD() {
	}

	public MovD(String tipo, String numero, String codArt, String nombre, String medida) {
		this.tipo = tipo;
		this.numero = numero;
		this.codArt = codArt;
		this.nombre = nombre;
		this.medida = medida;
	}

	public Long getCia() {
		return this.cia;
	}

	public void setCia(Long cia) {
		this.cia = cia;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodArt() {
		return this.codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMedida() {
		return this.medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

}