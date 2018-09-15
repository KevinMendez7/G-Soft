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
 * Maebod generated by hbm2java
 */
@Entity
@Table(name = "maebod")
public class Maebod implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "anioactual")
	private String anioActual;
	
	@Column(name = "mesactual")
	private String mesActual;
	
	@Column(name = "cod_art")
	private String codArt;
	
	@Column(name = "bodega")
	private String bodega;
	
	@Column(name = "saldoinicial")
	private Float saldoInicial;
	
	@Column(name = "entradas")
	private Float entradas;
	
	@Column(name = "salidas")
	private Float salidas;
	
	@Column(name = "fisico")
	private Float fisico;
	
	@Column(name = "kardex")
	private Float kardex;
	
	@Column(name = "fechulfis")
	private Date fechUlFis;
	
	@Column(name = "mesact")
	private String mesAct;
	
	@Column(name = "pedidos")
	private Float pedidos;
	
	@Column(name = "fechapedido")
	private Date fechaPedido;
	
	@Column(name = "malestado")
	private Float malEstado;
	
	@Column(name = "locacionh")
	private String locacionH;
	
	@Column(name = "locacionv")
	private String locacionV;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	public Maebod() {
	}

	public Maebod(String anioActual, String mesActual, String codArt, String bodega, Float saldoInicial, Float entradas,
			Float salidas, Float fisico, Float kardex, Date fechUlFis, String mesAct, Float pedidos, Date fechaPedido,
			Float malEstado, String locacionH, String locacionV, Character statReg, String usuario, Date fechaIngreso) {
		this.anioActual = anioActual;
		this.mesActual = mesActual;
		this.codArt = codArt;
		this.bodega = bodega;
		this.saldoInicial = saldoInicial;
		this.entradas = entradas;
		this.salidas = salidas;
		this.fisico = fisico;
		this.kardex = kardex;
		this.fechUlFis = fechUlFis;
		this.mesAct = mesAct;
		this.pedidos = pedidos;
		this.fechaPedido = fechaPedido;
		this.malEstado = malEstado;
		this.locacionH = locacionH;
		this.locacionV = locacionV;
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

	public String getAnioActual() {
		return this.anioActual;
	}

	public void setAnioActual(String anioActual) {
		this.anioActual = anioActual;
	}

	public String getMesActual() {
		return this.mesActual;
	}

	public void setMesActual(String mesActual) {
		this.mesActual = mesActual;
	}

	public String getCodArt() {
		return this.codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getBodega() {
		return this.bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public Float getSaldoInicial() {
		return this.saldoInicial;
	}

	public void setSaldoInicial(Float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Float getEntradas() {
		return this.entradas;
	}

	public void setEntradas(Float entradas) {
		this.entradas = entradas;
	}

	public Float getSalidas() {
		return this.salidas;
	}

	public void setSalidas(Float salidas) {
		this.salidas = salidas;
	}

	public Float getFisico() {
		return this.fisico;
	}

	public void setFisico(Float fisico) {
		this.fisico = fisico;
	}

	public Float getKardex() {
		return this.kardex;
	}

	public void setKardex(Float kardex) {
		this.kardex = kardex;
	}

	public Date getFechulfis() {
		return this.fechUlFis;
	}

	public void setFechUlFis(Date fechUlFis) {
		this.fechUlFis = fechUlFis;
	}

	public String getMesAct() {
		return this.mesAct;
	}

	public void setMesAct(String mesAct) {
		this.mesAct = mesAct;
	}

	public Float getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Float pedidos) {
		this.pedidos = pedidos;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Float getMalEstado() {
		return this.malEstado;
	}

	public void setMalEstado(Float malEstado) {
		this.malEstado = malEstado;
	}

	public String getLocacionH() {
		return this.locacionH;
	}

	public void setLocacionH(String locacionH) {
		this.locacionH = locacionH;
	}

	public String getLocacionV() {
		return this.locacionV;
	}

	public void setLocacionV(String locacionV) {
		this.locacionV = locacionV;
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
