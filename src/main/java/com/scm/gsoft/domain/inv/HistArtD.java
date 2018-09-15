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
 * HistArtD generated by hbm2java
 */
@Entity
@Table(name = "hist_art_d")
public class HistArtD implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "transa")
	private char transa;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "bodega")
	private String bodega;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "cod_art")
	private String codArt;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "medida")
	private String medida;
	
	@Column(name = "pu")
	private Float pu;
	
	@Column(name = "debe")
	private Float debe;
	
	@Column(name = "haber")
	private Float haber;
	
	@Column(name = "dq")
	private float dq;
	
	@Column(name = "hq")
	private float hq;
	
	@Column(name = "registro")
	private String registro;
	
	@Column(name = "iva")
	private Float iva;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "mes")
	private String mes;
	
	@Column(name = "cuenta")
	private String cuenta;
	
	@Column(name = "prefijo")
	private String prefijo;
	
	@Column(name = "proveedor")
	private String proveedor;
	
	@Column(name = "nofactura")
	private String noFactura;
	
	@Column(name = "polisa")
	private String polisa;
	
	@Column(name = "campo")
	private String campo;
	
	@Column(name = "bodega2")
	private String bodega2;
	
	@Column(name = "stat_reg")
	private Character statReg;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	public HistArtD() {
	}

	public HistArtD(char transa, String tipo, String bodega, String numero, Date fecha, String codArt, float dq,
			float hq, String year, String mes) {
		this.transa = transa;
		this.tipo = tipo;
		this.bodega = bodega;
		this.numero = numero;
		this.fecha = fecha;
		this.codArt = codArt;
		this.dq = dq;
		this.hq = hq;
		this.year = year;
		this.mes = mes;
	}

	public HistArtD(char transa, String tipo, String bodega, String numero, Date fecha, String codArt, String nombre,
			String medida, Float pu, Float debe, Float haber, float dq, float hq, String registro, Float iva,
			String year, String mes, String cuenta, String prefijo, String proveedor, String noFactura, String polisa,
			String campo, String bodega2, Character statReg, String usuario, Date fechaIngreso) {
		this.transa = transa;
		this.tipo = tipo;
		this.bodega = bodega;
		this.numero = numero;
		this.fecha = fecha;
		this.codArt = codArt;
		this.nombre = nombre;
		this.medida = medida;
		this.pu = pu;
		this.debe = debe;
		this.haber = haber;
		this.dq = dq;
		this.hq = hq;
		this.registro = registro;
		this.iva = iva;
		this.year = year;
		this.mes = mes;
		this.cuenta = cuenta;
		this.prefijo = prefijo;
		this.proveedor = proveedor;
		this.noFactura = noFactura;
		this.polisa = polisa;
		this.campo = campo;
		this.bodega2 = bodega2;
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

	public char getTransa() {
		return this.transa;
	}

	public void setTransa(char transa) {
		this.transa = transa;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getBodega() {
		return this.bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodArt() {
		return this.codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMedida() {
		return this.medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public Float getPu() {
		return this.pu;
	}

	public void setPu(Float pu) {
		this.pu = pu;
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

	public float getDq() {
		return this.dq;
	}

	public void setDq(float dq) {
		this.dq = dq;
	}

	public float getHq() {
		return this.hq;
	}

	public void setHq(float hq) {
		this.hq = hq;
	}

	public String getRegistro() {
		return this.registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Float getIva() {
		return this.iva;
	}

	public void setIva(Float iva) {
		this.iva = iva;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getPrefijo() {
		return this.prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getNoFactura() {
		return this.noFactura;
	}

	public void setNoFactura(String noFactura) {
		this.noFactura = noFactura;
	}

	public String getPolisa() {
		return this.polisa;
	}

	public void setPolisa(String polisa) {
		this.polisa = polisa;
	}

	public String getCampo() {
		return this.campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getBodega2() {
		return this.bodega2;
	}

	public void setBodega2(String bodega2) {
		this.bodega2 = bodega2;
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
