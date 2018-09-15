package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Calidad;

public interface CalidadDao {

	List<Calidad> getCalidadList();

	Calidad getCalidadById(Long idCalidad);

	Calidad getCalidadByName(String nameCalidad);

	void updateCalidad(Calidad calidad);

	void createCalidad(Calidad calidad);

	void removeCalidad(Long idCalidad);

}
