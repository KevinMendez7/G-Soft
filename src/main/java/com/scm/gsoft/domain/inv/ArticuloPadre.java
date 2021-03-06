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
 * ArticuloPadre generated by hbm2java
 */
@Entity
@Table(name = "articulo_padre")
public class ArticuloPadre implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "cod_familia")
	private String codFamilia;
	
	@Column(name = "cod_art_padre")
	private String codArtpadre;
	
	@Column(name = "nombre_padre")
	private String nombrePadre;
	
	@Column(name = "cod_arthijo")
	private String codArtHijo;
	
	@Column(name = "nombre_hijo")
	private String nombreHijo;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name = "checkbox")
	private Long checkbox;

	public ArticuloPadre() {
	}

	public ArticuloPadre(String codFamilia, String codArtpadre, String nombrePadre, String codArtHijo,
			String nombreHijo, Character statReg, String usuario, Date fechaIngreso, Long checkbox) {
		this.codFamilia = codFamilia;
		this.codArtpadre = codArtpadre;
		this.nombrePadre = nombrePadre;
		this.codArtHijo = codArtHijo;
		this.nombreHijo = nombreHijo;
		this.statReg = statReg;
		this.usuario = usuario;
		this.fechaIngreso = fechaIngreso;
		this.checkbox = checkbox;
	}

	public Long getCia() {
		return this.cia;
	}

	public void setCia(Long cia) {
		this.cia = cia;
	}

	public String getCodFamilia() {
		return this.codFamilia;
	}

	public void setCodFamilia(String codFamilia) {
		this.codFamilia = codFamilia;
	}

	public String getCodArtpadre() {
		return this.codArtpadre;
	}

	public void setCodArtpadre(String codArtpadre) {
		this.codArtpadre = codArtpadre;
	}

	public String getNombrePadre() {
		return this.nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getCodArtHijo() {
		return this.codArtHijo;
	}

	public void setCodArtHijo(String codArtHijo) {
		this.codArtHijo = codArtHijo;
	}

	public String getNombreHijo() {
		return this.nombreHijo;
	}

	public void setNombreHijo(String nombreHijo) {
		this.nombreHijo = nombreHijo;
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

	public Long getCheckbox() {
		return this.checkbox;
	}

	public void setCheckbox(Long checkbox) {
		this.checkbox = checkbox;
	}

}
