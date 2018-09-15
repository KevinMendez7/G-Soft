package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Calidad;

public interface CalidadService {

	List<Calidad> getCalidadList();

	Calidad getCalidadById(Long idCalidad);

	Calidad getCalidadByName(String nameCalidad);

	void updateCalidad(Calidad calidad);

	void createCalidad(Calidad calidad);

	void removeCalidad(Long idCalidad);

}
