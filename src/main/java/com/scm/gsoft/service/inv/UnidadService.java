package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Unidad;

public interface UnidadService {

	List<Unidad> getUnidadList();

	Unidad getUnidadById(Long idUnidad);

	Unidad getUnidadByName(String nameUnidad);

	void updateUnidad(Unidad unidad);

	void createUnidad(Unidad unidad);

	void removeUnidad(Long idUnidad);

}
