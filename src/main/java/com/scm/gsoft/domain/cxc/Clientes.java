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
 * Clientes generated by hbm2java
 */
@Entity
@Table(name = "clientes")
public class Clientes implements java.io.Serializable {

	@Id
	@Column(name = "id_clientes")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClientes;
	
	@Column(name = "cia")
	private Float cia;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "nombre1")
	private String nombre1;
	
	@Column(name = "propietario")
	private String propietario;
	
	@Column(name = "contacto")
	private String contacto;
	
	@Column(name = "mensajero")
	private String mensajero;
	
	@Column(name = "dir1")
	private String dir1;
	
	@Column(name = "plazo")
	private Float plazo;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "nit")
	private String nit;
	
	@Column(name = "nita")
	private String nitA;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "e_mail")
	private String email;
	
	@Column(name = "cedula")
	private String cedula;
	
	@Column(name = "formacompra")
	private String formaCompra;
	
	@Column(name = "formapago")
	private String formaPago;
	
	@Column(name = "activo")
	private String activo;
	
	@Column(name = "limitecredito")
	private Float limiteCredito;
	
	@Column(name = "saldoinicial")
	private Float saldoInicial;
	
	@Column(name = "cargos")
	private Float cargos;
	
	@Column(name = "abonos")
	private Float abonos;
	
	@Column(name = "mesact")
	private String mesAct;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name = "clasificador")
	private String clasificador;
	
	@Column(name = "nombre2")
	private String nombre2;
	
	@Column(name = "dir2")
	private String dir2;
	
	@Column(name = "vendedor")
	private String vendedor;
	
	@Column(name = "proyecto")
	private String proyecto;
	
	@Column(name = "factuaa")
	private String factuAa;
	
	@Column(name = "clavefa")
	private String claveFa;
	
	@Column(name = "direcciona")
	private String direccionA;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "referido_p")
	private String referidoP;
	
	@Column(name = "referido_por")
	private String referidoPor;
	
	@Column(name = "descuento")
	private Float descuento;

	public Clientes() {
	}

	public Clientes(Float cia, String codigo, String nombre1, String propietario, String contacto, String mensajero,
			String dir1, Float plazo, String telefono, String nit, String nitA, String fax, String email, String cedula,
			String formaCompra, String formaPago, String activo, Float limiteCredito, Float saldoInicial, Float cargos,
			Float abonos, String mesAct, String observaciones, Character statReg, String usuario, Date fechaIngreso,
			String clasificador, String nombre2, String dir2, String vendedor, String proyecto, String factuAa,
			String claveFa, String direccionA, String empresa, String referidoP, String referidoPor, Float descuento) {
		this.cia = cia;
		this.codigo = codigo;
		this.nombre1 = nombre1;
		this.propietario = propietario;
		this.contacto = contacto;
		this.mensajero = mensajero;
		this.dir1 = dir1;
		this.plazo = plazo;
		this.telefono = telefono;
		this.nit = nit;
		this.nitA = nitA;
		this.fax = fax;
		this.email = email;
		this.cedula = cedula;
		this.formaCompra = formaCompra;
		this.formaPago = formaPago;
		this.activo = activo;
		this.limiteCredito = limiteCredito;
		this.saldoInicial = saldoInicial;
		this.cargos = cargos;
		this.abonos = abonos;
		this.mesAct = mesAct;
		this.observaciones = observaciones;
		this.statReg = statReg;
		this.usuario = usuario;
		this.fechaIngreso = fechaIngreso;
		this.clasificador = clasificador;
		this.nombre2 = nombre2;
		this.dir2 = dir2;
		this.vendedor = vendedor;
		this.proyecto = proyecto;
		this.factuAa = factuAa;
		this.claveFa = claveFa;
		this.direccionA = direccionA;
		this.empresa = empresa;
		this.referidoP = referidoP;
		this.referidoPor = referidoPor;
		this.descuento = descuento;
	}

	public Long getIdClientes() {
		return this.idClientes;
	}

	public void setIdClientes(Long idClientes) {
		this.idClientes = idClientes;
	}

	public Float getCia() {
		return this.cia;
	}

	public void setCia(Float cia) {
		this.cia = cia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre1() {
		return this.nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getPropietario() {
		return this.propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getMensajero() {
		return this.mensajero;
	}

	public void setMensajero(String mensajero) {
		this.mensajero = mensajero;
	}

	public String getDir1() {
		return this.dir1;
	}

	public void setDir1(String dir1) {
		this.dir1 = dir1;
	}

	public Float getPlazo() {
		return this.plazo;
	}

	public void setPlazo(Float plazo) {
		this.plazo = plazo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNitA() {
		return this.nitA;
	}

	public void setNitA(String nitA) {
		this.nitA = nitA;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFormacompra() {
		return this.formaCompra;
	}

	public void setFormaCompra(String formaCompra) {
		this.formaCompra = formaCompra;
	}

	public String getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Float getLimiteCredito() {
		return this.limiteCredito;
	}

	public void setLimiteCredito(Float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Float getSaldoInicial() {
		return this.saldoInicial;
	}

	public void setSaldoInicial(Float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Float getCargos() {
		return this.cargos;
	}

	public void setCargos(Float cargos) {
		this.cargos = cargos;
	}

	public Float getAbonos() {
		return this.abonos;
	}

	public void setAbonos(Float abonos) {
		this.abonos = abonos;
	}

	public String getMesAct() {
		return this.mesAct;
	}

	public void setMesAct(String mesAct) {
		this.mesAct = mesAct;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	public String getClasificador() {
		return this.clasificador;
	}

	public void setClasificador(String clasificador) {
		this.clasificador = clasificador;
	}

	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getDir2() {
		return this.dir2;
	}

	public void setDir2(String dir2) {
		this.dir2 = dir2;
	}

	public String getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getFactuAa() {
		return this.factuAa;
	}

	public void setFactAaa(String factuAa) {
		this.factuAa = factuAa;
	}

	public String getClaveFa() {
		return this.claveFa;
	}

	public void setClaveFa(String claveFa) {
		this.claveFa = claveFa;
	}

	public String getDireccionA() {
		return this.direccionA;
	}

	public void setDireccionA(String direccionA) {
		this.direccionA = direccionA;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getReferidoP() {
		return this.referidoP;
	}

	public void setReferidoP(String referidoP) {
		this.referidoP = referidoP;
	}

	public String getReferidoPor() {
		return this.referidoPor;
	}

	public void setReferidoPor(String referidoPor) {
		this.referidoPor = referidoPor;
	}

	public Float getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

}
