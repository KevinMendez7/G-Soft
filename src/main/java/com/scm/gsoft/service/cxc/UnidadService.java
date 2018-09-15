package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Unidad;

public interface UnidadService {

	List<Unidad> getUnidadList();

	Unidad getUnidadById(Long idUnidad);

	Unidad getUnidadByName(String nameUnidad);

	void updateUnidad(Unidad Unidad);

	void createUnidad(Unidad Unidad);

	void removeUnidad(Long idUnidad);

}
