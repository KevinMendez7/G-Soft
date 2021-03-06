package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Clase;

public interface ClaseDao {

	List<Clase> getClaseList();

	Clase getClaseById(Long idClase);

	Clase getClaseByName(String nameClase);

	void updateClase(Clase clase);

	void createClase(Clase clase);

	void removeClase(Long idClase);

}
