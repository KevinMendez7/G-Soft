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
 * DetalleRec generated by hbm2java
 */
@Entity
@Table(name = "detalle_rec")
public class DetalleRec implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "num_dcto")
	private String numDcto;
	
	@Column(name = "num_fac")
	private String numFac;
	
	@Column(name = "fecha_fac")
	private Date fechaFac;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "saldo")
	private Float saldo;
	
	@Column(name = "debe")
	private Float debe;
	
	@Column(name = "haber")
	private Float haber;
	
	@Column(name = "dq")
	private Float dq;
	
	@Column(name = "registro")
	private String registro;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "dcto_lin")
	private Float dctoLin;
	
	@Column(name = "item")
	private Long item;
	
	@Column(name = "dcto_fac")
	private Float dctofac;
	
	@Column(name = "neto")
	private Float neto;
	
	@Column(name = "ajuste")
	private Float ajuste;
	
	@Column(name = "fecha")
	private Date fecha;

	public DetalleRec() {
	}

	public DetalleRec(Long cia, String numDcto, String numFac, String registro) {
		this.cia = cia;
		this.numDcto = numDcto;
		this.numFac = numFac;
		this.registro = registro;
	}

	public DetalleRec(Long cia, String numDcto, String numFac, Date fechaFac, String descripcion, Float saldo,
			Float debe, Float haber, Float dq, String registro, String tipo, Float dctoLin, Long item, Float dctofac,
			Float neto, Float ajuste, Date fecha) {
		this.cia = cia;
		this.numDcto = numDcto;
		this.numFac = numFac;
		this.fechaFac = fechaFac;
		this.descripcion = descripcion;
		this.saldo = saldo;
		this.debe = debe;
		this.haber = haber;
		this.dq = dq;
		this.registro = registro;
		this.tipo = tipo;
		this.dctoLin = dctoLin;
		this.item = item;
		this.dctofac = dctofac;
		this.neto = neto;
		this.ajuste = ajuste;
		this.fecha = fecha;
	}

	public Long getCia() {
		return this.cia;
	}

	public void setCia(Long cia) {
		this.cia = cia;
	}

	public String getNumDcto() {
		return this.numDcto;
	}

	public void setNumDcto(String numDcto) {
		this.numDcto = numDcto;
	}

	public String getNumFac() {
		return this.numFac;
	}

	public void setNumFac(String numFac) {
		this.numFac = numFac;
	}

	public Date getFechaFac() {
		return this.fechaFac;
	}

	public void setFechaFac(Date fechaFac) {
		this.fechaFac = fechaFac;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Float getDebe() {
		return this.debe;
	}

	public void setDebe(Float debe) {
		this.debe = debe;
	}

	public Float getHaber() {
		return this.haber;
	}

	public void setHaber(Float haber) {
		this.haber = haber;
	}

	public Float getDq() {
		return this.dq;
	}

	public void setDq(Float dq) {
		this.dq = dq;
	}

	public String getRegistro() {
		return this.registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getDctoLin() {
		return this.dctoLin;
	}

	public void setDctoLin(Float dctoLin) {
		this.dctoLin = dctoLin;
	}

	public Long getItem() {
		return this.item;
	}

	public void setItem(Long item) {
		this.item = item;
	}

	public Float getDctofac() {
		return this.dctofac;
	}

	public void setDctofac(Float dctofac) {
		this.dctofac = dctofac;
	}

	public Float getNeto() {
		return this.neto;
	}

	public void setNeto(Float neto) {
		this.neto = neto;
	}

	public Float getAjuste() {
		return this.ajuste;
	}

	public void setAjuste(Float ajuste) {
		this.ajuste = ajuste;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
