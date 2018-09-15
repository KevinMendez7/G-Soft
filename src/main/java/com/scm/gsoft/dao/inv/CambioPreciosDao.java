package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.CambioPrecios;

public interface CambioPreciosDao {

	List<CambioPrecios> getCambioPreciosList();

	CambioPrecios getCambioPreciosById(Long idCambioPrecios);

	CambioPrecios getCambioPreciosByName(String nameCambioPrecios);

	void updateCambioPrecios(CambioPrecios cambioPrecios);

	void createCambioPrecios(CambioPrecios cambioPrecios);

	void removeCambioPrecios(Long idCambioPrecios);

}
