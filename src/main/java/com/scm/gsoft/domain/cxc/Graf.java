package com.scm.gsoft.domain.cxc;
// Generated 26/08/2018 01:38:39 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Graf generated by hbm2java
 */
@Entity
@Table(name = "graf")
public class Graf implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1020892209952450208L;

	@Id
	@Column(name = "id_graf")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGraf;
	
	@Column(name = "olegraph")
	private byte[] olegraph;
	
	@Column(name = "timestamp_column")
	private byte[] timestampColumn;

	public Graf() {
	}

	public Graf(byte[] olegraph, byte[] timestampColumn) {
		this.olegraph = olegraph;
		this.timestampColumn = timestampColumn;
	}

	public Long getIdGraf() {
		return this.idGraf;
	}

	public void setIdGraf(Long idGraf) {
		this.idGraf = idGraf;
	}

	public byte[] getOlegraph() {
		return this.olegraph;
	}

	public void setOlegraph(byte[] olegraph) {
		this.olegraph = olegraph;
	}

	public byte[] getTimestampColumn() {
		return this.timestampColumn;
	}

	public void setTimestampColumn(byte[] timestampColumn) {
		this.timestampColumn = timestampColumn;
	}

}
