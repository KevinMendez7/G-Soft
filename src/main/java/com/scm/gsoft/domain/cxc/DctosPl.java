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
 * DctosPl generated by hbm2java
 */
@Entity
@Table(name = "dctos_pl")
public class DctosPl implements java.io.Serializable {

	@Id
	@Column(name = "id_dctos_pl")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDctosPl;
	
	@Column(name = "cia")
	private float cia;
	
	@Column(name = "tipo_pl")
	private String tipoPl;
	
	@Column(name = "num_pl")
	private String numPl;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "nombrecliente")
	private String nombreCliente;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "tipo_cliente")
	private String tipoCliente;
	
	@Column(name = "vendedor")
	private String vendedor;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	public DctosPl() {
	}

	public DctosPl(Long cia) {
		this.cia = cia;
	}

	public DctosPl(Long cia, String tipoPl, String numPl, Date fecha, String codigo, String nombreCliente,
			String direccion, String telefono, String email, String observaciones, String tipoCliente, String vendedor,
			Character statReg, String usuario, Date fechaIngreso) {
		this.cia = cia;
		this.tipoPl = tipoPl;
		this.numPl = numPl;
		this.fecha = fecha;
		this.codigo = codigo;
		this.nombreCliente = nombreCliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.observaciones = observaciones;
		this.tipoCliente = tipoCliente;
		this.vendedor = vendedor;
		this.statReg = statReg;
		this.usuario = usuario;
		this.fechaIngreso = fechaIngreso;
	}

	public Long getIdDctosPl() {
		return this.idDctosPl;
	}

	public void setIdDctosPl(Long idDctosPl) {
		this.idDctosPl = idDctosPl;
	}

	public float getCia() {
		return this.cia;
	}

	public void setCia(float cia) {
		this.cia = cia;
	}

	public String getTipoPl() {
		return this.tipoPl;
	}

	public void setTipoPl(String tipoPl) {
		this.tipoPl = tipoPl;
	}

	public String getNumPl() {
		return this.numPl;
	}

	public void setNumPl(String numPl) {
		this.numPl = numPl;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
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