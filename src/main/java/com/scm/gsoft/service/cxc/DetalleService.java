package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Detalle;

public interface DetalleService {

	List<Detalle> getDetalleList();

	Detalle getDetalleById(Long idDetalle);

	Detalle getDetalleByName(String nameDetalle);

	void updateDetalle(Detalle detalle);

	void createDetalle(Detalle detalle);

	void removeDetalle(Long idDetalle);

}
