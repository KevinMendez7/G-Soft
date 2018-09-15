package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.MDetalle;

public interface MDetalleDao {

	List<MDetalle> getMDetalleList();

	MDetalle getMDetalleById(Long idMDetalle);

	MDetalle getMDetalleByName(String nameMDetalle);

	void updateMDetalle(MDetalle mDetalle);

	void createMDetalle(MDetalle mDetalle);

	void removeMDetalle(Long idMDetalle);

}
