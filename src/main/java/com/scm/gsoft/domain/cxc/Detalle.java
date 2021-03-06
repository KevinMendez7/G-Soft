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
 * Detalle generated by hbm2java
 */
@Entity
@Table(name = "detalle")
public class Detalle implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "num_dcto")
	private String numDcto;
	
	@Column(name = "cod_art")
	private String codArt;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "debe")
	private Float debe;
	
	@Column(name = "pu")
	private Float pu;
	
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
	
	@Column(name = "cq")
	private Float cq;
	
	@Column(name = "grupo")
	private String grupo;
	
	@Column(name = "codigoanterior")
	private String codigoAnterior;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name = "nopieza")
	private String noPieza;

	public Detalle() {
	}

	public Detalle(Long cia, String numDcto, String codArt, String registro) {
		this.cia = cia;
		this.numDcto = numDcto;
		this.codArt = codArt;
		this.registro = registro;
	}

	public Detalle(Long cia, String numDcto, String codArt, String descripcion, Float debe, Float pu, Float dq,
			String registro, String tipo, Float dctoLin, Long item, Float dctofac, Float neto, Float ajuste, Date fecha,
			Float cq, String grupo, String codigoanterior, Character statReg, String usuario, Date fechaIngreso,
			String nopieza) {
		this.cia = cia;
		this.numDcto = numDcto;
		this.codArt = codArt;
		this.descripcion = descripcion;
		this.debe = debe;
		this.pu = pu;
		this.dq = dq;
		this.registro = registro;
		this.tipo = tipo;
		this.dctoLin = dctoLin;
		this.item = item;
		this.dctofac = dctofac;
		this.neto = neto;
		this.ajuste = ajuste;
		this.fecha = fecha;
		this.cq = cq;
		this.grupo = grupo;
		this.codigoAnterior = codigoAnterior;
		this.statReg = statReg;
		this.usuario = usuario;
		this.fechaIngreso = fechaIngreso;
		this.noPieza = noPieza;
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

	public String getCodArt() {
		return this.codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getDebe() {
		return this.debe;
	}

	public void setDebe(Float debe) {
		this.debe = debe;
	}

	public Float getPu() {
		return this.pu;
	}

	public void setPu(Float pu) {
		this.pu = pu;
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

	public Float getCq() {
		return this.cq;
	}

	public void setCq(Float cq) {
		this.cq = cq;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCodigoAnterior() {
		return this.codigoAnterior;
	}

	public void setCodigoAnterior(String codigoAnterior) {
		this.codigoAnterior = codigoAnterior;
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

	public String getNoPieza() {
		return this.noPieza;
	}

	public void setNoPieza(String noPieza) {
		this.noPieza = noPieza;
	}

}
