package com.scm.gsoft.domain.cxc;
// Generated 26/08/2018 01:38:39 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SegL generated by hbm2java
 */
@Entity
@Table(name = "seg_l")
public class SegL implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "clave")
	private String clave;
	
	@Column(name = "seguridad")
	private boolean seguridad;
	
	@Column(name = "empresa")
	private boolean empresa;
	
	@Column(name = "clientes")
	private boolean clientes;
	
	@Column(name = "configura_imp")
	private boolean configuraImp;
	
	@Column(name = "ingreso")	
	private boolean ingreso;
	
	@Column(name = "egreso")
	private boolean egreso;
	
	@Column(name = "consaldos")
	private boolean conSaldos;
	
	@Column(name = "rptcli")
	private boolean rptCli;
	
	@Column(name = "rptmov")
	private boolean rptMov;
	
	@Column(name = "mayor")
	private boolean mayor;
	
	@Column(name = "balance")
	private boolean balance;
	
	@Column(name = "estado")
	private boolean estado;
	
	@Column(name = "tipo")
	private boolean tipo;
	
	@Column(name = "cartera")
	private boolean cartera;
	
	@Column(name = "clasifica")
	private boolean clasifica;
	
	@Column(name = "vendedor")
	private boolean vendedor;
	
	@Column(name = "busca")
	private boolean busca;
	
	@Column(name = "anual")
	private boolean anual;
	
	@Column(name = "rptcliven")
	private boolean rptCliVen;
	
	@Column(name = "facvende")
	private boolean facVende;
	
	@Column(name = "uno")
	private boolean uno;
	
	@Column(name = "dos")
	private boolean dos;
	
	@Column(name = "tres")
	private boolean tres;
	
	@Column(name = "cuatro")
	private boolean cuatro;

	public SegL() {
	}

	public SegL(Long cia, String usuario, String nombre, String clave, boolean seguridad, boolean empresa,
			boolean clientes, boolean configuraImp, boolean ingreso, boolean egreso, boolean conSaldos, boolean rptCli,
			boolean rptMov, boolean mayor, boolean balance, boolean estado, boolean tipo, boolean cartera,
			boolean clasifica, boolean vendedor, boolean busca, boolean anual, boolean rptCliVen, boolean facVende,
			boolean uno, boolean dos, boolean tres, boolean cuatro) {
		this.cia = cia;
		this.usuario = usuario;
		this.nombre = nombre;
		this.clave = clave;
		this.seguridad = seguridad;
		this.empresa = empresa;
		this.clientes = clientes;
		this.configuraImp = configuraImp;
		this.ingreso = ingreso;
		this.egreso = egreso;
		this.conSaldos = conSaldos;
		this.rptCli = rptCli;
		this.rptMov = rptMov;
		this.mayor = mayor;
		this.balance = balance;
		this.estado = estado;
		this.tipo = tipo;
		this.cartera = cartera;
		this.clasifica = clasifica;
		this.vendedor = vendedor;
		this.busca = busca;
		this.anual = anual;
		this.rptCliVen = rptCliVen;
		this.facVende = facVende;
		this.uno = uno;
		this.dos = dos;
		this.tres = tres;
		this.cuatro = cuatro;
	}

	public Long getCia() {
		return this.cia;
	}

	public void setCia(Long cia) {
		this.cia = cia;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isSeguridad() {
		return this.seguridad;
	}

	public void setSeguridad(boolean seguridad) {
		this.seguridad = seguridad;
	}

	public boolean isEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(boolean empresa) {
		this.empresa = empresa;
	}

	public boolean isClientes() {
		return this.clientes;
	}

	public void setClientes(boolean clientes) {
		this.clientes = clientes;
	}

	public boolean isConfiguraImp() {
		return this.configuraImp;
	}

	public void setConfiguraImp(boolean configuraImp) {
		this.configuraImp = configuraImp;
	}

	public boolean isIngreso() {
		return this.ingreso;
	}

	public void setIngreso(boolean ingreso) {
		this.ingreso = ingreso;
	}

	public boolean isEgreso() {
		return this.egreso;
	}

	public void setEgreso(boolean egreso) {
		this.egreso = egreso;
	}

	public boolean isConSaldos() {
		return this.conSaldos;
	}

	public void setConSaldos(boolean conSaldos) {
		this.conSaldos = conSaldos;
	}

	public boolean isRptCli() {
		return this.rptCli;
	}

	public void setRptCli(boolean rptCli) {
		this.rptCli = rptCli;
	}

	public boolean isRptMov() {
		return this.rptMov;
	}

	public void setRptMov(boolean rptMov) {
		this.rptMov = rptMov;
	}

	public boolean isMayor() {
		return this.mayor;
	}

	public void setMayor(boolean mayor) {
		this.mayor = mayor;
	}

	public boolean isBalance() {
		return this.balance;
	}

	public void setBalance(boolean balance) {
		this.balance = balance;
	}

	public boolean isEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isTipo() {
		return this.tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public boolean isCartera() {
		return this.cartera;
	}

	public void setCartera(boolean cartera) {
		this.cartera = cartera;
	}

	public boolean isClasifica() {
		return this.clasifica;
	}

	public void setClasifica(boolean clasifica) {
		this.clasifica = clasifica;
	}

	public boolean isVendedor() {
		return this.vendedor;
	}

	public void setVendedor(boolean vendedor) {
		this.vendedor = vendedor;
	}

	public boolean isBusca() {
		return this.busca;
	}

	public void setBusca(boolean busca) {
		this.busca = busca;
	}

	public boolean isAnual() {
		return this.anual;
	}

	public void setAnual(boolean anual) {
		this.anual = anual;
	}

	public boolean isRptCliVen() {
		return this.rptCliVen;
	}

	public void setRptCliVen(boolean rptCliVen) {
		this.rptCliVen = rptCliVen;
	}

	public boolean isFacVende() {
		return this.facVende;
	}

	public void setFacVende(boolean facVende) {
		this.facVende = facVende;
	}

	public boolean isUno() {
		return this.uno;
	}

	public void setUno(boolean uno) {
		this.uno = uno;
	}

	public boolean isDos() {
		return this.dos;
	}

	public void setDos(boolean dos) {
		this.dos = dos;
	}

	public boolean isTres() {
		return this.tres;
	}

	public void setTres(boolean tres) {
		this.tres = tres;
	}

	public boolean isCuatro() {
		return this.cuatro;
	}

	public void setCuatro(boolean cuatro) {
		this.cuatro = cuatro;
	}

}