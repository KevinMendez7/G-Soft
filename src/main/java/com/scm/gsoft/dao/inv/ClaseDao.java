package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Clase;

public interface ClaseDao {

	List<Clase> getClaseList();

	Clase getClaseById(Long idClase);

	Clase getClaseByName(String nameClase);

	void updateClase(Clase clase);

	void createClase(Clase clase);

	void removeClase(Long idClase);

}
