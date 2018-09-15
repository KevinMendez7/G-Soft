package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.MDetalle;

public interface MDetalleService {

	List<MDetalle> getMDetalleList();

	MDetalle getMDetalleById(Long idMDetalle);

	MDetalle getMDetalleByName(String nameMDetalle);

	void updateMDetalle(MDetalle mDetalle);

	void createMDetalle(MDetalle mDetalle);

	void removeMDetalle(Long idMDetalle);

}
