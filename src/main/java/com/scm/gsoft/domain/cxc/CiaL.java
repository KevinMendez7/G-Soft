package com.scm.gsoft.domain.cxc;
// Generated 26/08/2018 01:38:39 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CiaL generated by hbm2java
 */
@Entity
@Table(name = "cia_l")
public class CiaL implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "taza_comi")
	private float tazaComi;
	
	@Column(name = "polizafac")
	private String polizaFac;
	
	@Column(name = "ventas")
	private String ventas;
	
	@Column(name = "iva")
	private Long iva;
	
	@Column(name = "clientes")
	private String clientes;
	
	@Column(name = "cxcconta")
	private Float cxcConta;
	
	@Column(name = "polizarec")
	private String polizaRec;
	
	@Column(name = "clienterec")
	private String clienteRec;
	
	@Column(name = "anticipo")
	private String anticipo;
	
	@Column(name = "bancorec")
	private String bancoRec;
	
	@Column(name = "polizaant")
	private String polizaAnt;
	
	@Column(name = "facmessg")
	private String facMessg;

	public CiaL() {
	}

	public CiaL(Long cia, String nombre, float tazaComi, String polizaRec, String clienteRec, String anticipo,
			String bancoRec, String polizaAnt) {
		this.cia = cia;
		this.nombre = nombre;
		this.tazaComi = tazaComi;
		this.polizaRec = polizaRec;
		this.clienteRec = clienteRec;
		this.anticipo = anticipo;
		this.bancoRec = bancoRec;
		this.polizaAnt = polizaAnt;
	}

	public CiaL(Long cia, String nombre, float tazaComi, String polizaFac, String ventas, Long iva, String clientes,
			Float cxcConta, String polizaRec, String clienteRec, String anticipo, String bancoRec, String polizaAnt,
			String facMessg) {
		this.cia = cia;
		this.nombre = nombre;
		this.tazaComi = tazaComi;
		this.polizaFac = polizaFac;
		this.ventas = ventas;
		this.iva = iva;
		this.clientes = clientes;
		this.cxcConta = cxcConta;
		this.polizaRec = polizaRec;
		this.clienteRec = clienteRec;
		this.anticipo = anticipo;
		this.bancoRec = bancoRec;
		this.polizaAnt = polizaAnt;
		this.facMessg = facMessg;
	}

	public Long getCia() {
		return this.cia;
	}

	public void setCia(Long cia) {
		this.cia = cia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getTazaComi() {
		return this.tazaComi;
	}

	public void setTazaComi(float tazaComi) {
		this.tazaComi = tazaComi;
	}

	public String getPolizaFac() {
		return this.polizaFac;
	}

	public void setPolizaFac(String polizaFac) {
		this.polizaFac = polizaFac;
	}

	public String getVentas() {
		return this.ventas;
	}

	public void setVentas(String ventas) {
		this.ventas = ventas;
	}

	public Long getIva() {
		return this.iva;
	}

	public void setIva(Long iva) {
		this.iva = iva;
	}

	public String getClientes() {
		return this.clientes;
	}

	public void setClientes(String clientes) {
		this.clientes = clientes;
	}

	public Float getCxcConta() {
		return this.cxcConta;
	}

	public void setCxcConta(Float cxcConta) {
		this.cxcConta = cxcConta;
	}

	public String getPolizaRec() {
		return this.polizaRec;
	}

	public void setPolizaRec(String polizaRec) {
		this.polizaRec = polizaRec;
	}

	public String getClienteRec() {
		return this.clienteRec;
	}

	public void setClienteRec(String clienteRec) {
		this.clienteRec = clienteRec;
	}

	public String getAnticipo() {
		return this.anticipo;
	}

	public void setAnticipo(String anticipo) {
		this.anticipo = anticipo;
	}

	public String getBancoRec() {
		return this.bancoRec;
	}

	public void setBancorec(String bancoRec) {
		this.bancoRec = bancoRec;
	}

	public String getPolizaAnt() {
		return this.polizaAnt;
	}

	public void setPolizaAnt(String polizaAnt) {
		this.polizaAnt = polizaAnt;
	}

	public String getFacMessg() {
		return this.facMessg;
	}

	public void setFacMessg(String facMessg) {
		this.facMessg = facMessg;
	}

}