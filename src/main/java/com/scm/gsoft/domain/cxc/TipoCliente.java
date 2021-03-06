package com.scm.gsoft.domain.cxc;
// Generated 26/08/2018 01:38:39 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TipoCliente generated by hbm2java
 */
@Entity
@Table(name = "tipo_cliente")
public class TipoCliente implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "cod_cli")
	private String codCli;
	
	@Column(name = "descripcion_tipo")
	private String descripcionTipo;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	public TipoCliente() {
	}

	public TipoCliente(Long cia, String codCli, String descripcionTipo) {
		this.cia = cia;
		this.codCli = codCli;
		this.descripcionTipo = descripcionTipo;
	}

	public TipoCliente(Long cia, String codCli, String descripcionTipo, Character statReg, String usuario,
			Date fechaIngreso) {
		this.cia = cia;
		this.codCli = codCli;
		this.descripcionTipo = descripcionTipo;
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

	public String getCodCli() {
		return this.codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	public String getDescripcionTipo() {
		return this.descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
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
