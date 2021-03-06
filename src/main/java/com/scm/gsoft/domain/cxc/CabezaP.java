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
 * Cabezap generated by hbm2java
 */
@Entity
@Table(name = "cabezap")
public class CabezaP implements java.io.Serializable {

	@Id
	@Column(name = "cia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cia;
	
	@Column(name = "poliza")
	private String poliza;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "correlativo")
	private String correlativo;
	
	@Column(name = "tramitador")
	private String tramitador;
	
	@Column(name = "tasa")
	private float tasa;
	
	@Column(name = "fob_s")
	private float fobS;
	
	@Column(name = "fob_q")
	private float fobQ;
	
	@Column(name = "flete")
	private float flete;
	
	@Column(name = "seguro")
	private float seguro;
	
	@Column(name = "otros")
	private float otros;
	
	@Column(name = "multas")
	private float multas;
	
	@Column(name = "documentos")
	private float documentos;
	
	@Column(name = "certificacion")
	private float certificacion;
	
	@Column(name = "almacenaje")
	private float almacenaje;
	
	@Column(name = "servicios")
	private float servicios;
	
	@Column(name = "multasaduana")
	private float multasaduana;
	
	@Column(name = "manejo")
	private float manejo;
	
	@Column(name = "transporte")
	private float transporte;
	
	@Column(name = "cif")
	private float cif;
	
	@Column(name = "derechos")
	private float derechos;
	
	@Column(name = "gastosaduana")
	private float gastosaduana;
	
	@Column(name = "costos")
	private float costo;

	public CabezaP() {
	}

	public CabezaP(Long cia, String poliza, Date fecha, String correlativo, String tramitador, float tasa, float fobS,
			float fobQ, float flete, float seguro, float otros, float multas, float documentos, float certificacion,
			float almacenaje, float servicios, float multasaduana, float manejo, float transporte, float cif,
			float derechos, float gastosaduana, float costo) {
		this.cia = cia;
		this.poliza = poliza;
		this.fecha = fecha;
		this.correlativo = correlativo;
		this.tramitador = tramitador;
		this.tasa = tasa;
		this.fobS = fobS;
		this.fobQ = fobQ;
		this.flete = flete;
		this.seguro = seguro;
		this.otros = otros;
		this.multas = multas;
		this.documentos = documentos;
		this.certificacion = certificacion;
		this.almacenaje = almacenaje;
		this.servicios = servicios;
		this.multasaduana = multasaduana;
		this.manejo = manejo;
		this.transporte = transporte;
		this.cif = cif;
		this.derechos = derechos;
		this.gastosaduana = gastosaduana;
		this.costo = costo;
	}

	public Long getCia() {
		return this.cia;
	}

	public void setCia(Long cia) {
		this.cia = cia;
	}

	public String getPoliza() {
		return this.poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCorrelativo() {
		return this.correlativo;
	}

	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}

	public String getTramitador() {
		return this.tramitador;
	}

	public void setTramitador(String tramitador) {
		this.tramitador = tramitador;
	}

	public float getTasa() {
		return this.tasa;
	}

	public void setTasa(float tasa) {
		this.tasa = tasa;
	}

	public float getFobS() {
		return this.fobS;
	}

	public void setFobS(float fobS) {
		this.fobS = fobS;
	}

	public float getFobQ() {
		return this.fobQ;
	}

	public void setFobQ(float fobQ) {
		this.fobQ = fobQ;
	}

	public float getFlete() {
		return this.flete;
	}

	public void setFlete(float flete) {
		this.flete = flete;
	}

	public float getSeguro() {
		return this.seguro;
	}

	public void setSeguro(float seguro) {
		this.seguro = seguro;
	}

	public float getOtros() {
		return this.otros;
	}

	public void setOtros(float otros) {
		this.otros = otros;
	}

	public float getMultas() {
		return this.multas;
	}

	public void setMultas(float multas) {
		this.multas = multas;
	}

	public float getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(float documentos) {
		this.documentos = documentos;
	}

	public float getCertificacion() {
		return this.certificacion;
	}

	public void setCertificacion(float certificacion) {
		this.certificacion = certificacion;
	}

	public float getAlmacenaje() {
		return this.almacenaje;
	}

	public void setAlmacenaje(float almacenaje) {
		this.almacenaje = almacenaje;
	}

	public float getServicios() {
		return this.servicios;
	}

	public void setServicios(float servicios) {
		this.servicios = servicios;
	}

	public float getMultasaduana() {
		return this.multasaduana;
	}

	public void setMultasaduana(float multasaduana) {
		this.multasaduana = multasaduana;
	}

	public float getManejo() {
		return this.manejo;
	}

	public void setManejo(float manejo) {
		this.manejo = manejo;
	}

	public float getTransporte() {
		return this.transporte;
	}

	public void setTransporte(float transporte) {
		this.transporte = transporte;
	}

	public float getCif() {
		return this.cif;
	}

	public void setCif(float cif) {
		this.cif = cif;
	}

	public float getDerechos() {
		return this.derechos;
	}

	public void setDerechos(float derechos) {
		this.derechos = derechos;
	}

	public float getGastosaduana() {
		return this.gastosaduana;
	}

	public void setGastosaduana(float gastosaduana) {
		this.gastosaduana = gastosaduana;
	}

	public float getCosto() {
		return this.costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

}
