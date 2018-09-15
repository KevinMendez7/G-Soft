
package com.scm.gsoft.domain.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

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
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "tipo")
	private char tipo;
	
	@Column(name = "tipot")
	private Character tipoT;
	
	@Column(name = "corr")
	private String corr;

	public Tipo() {
	}

	public Tipo(String codigo, String nombre, char tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public Tipo(String codigo, String nombre, char tipo, Character tipoT, String corr) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.tipoT = tipoT;
		this.corr = corr;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getTipo() {
		return this.tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public Character getTipoT() {
		return this.tipoT;
	}

	public void setTipoT(Character tipoT) {
		this.tipoT = tipoT;
	}

	public String getCorr() {
		return this.corr;
	}

	public void setCorr(String corr) {
		this.corr = corr;
	}

}