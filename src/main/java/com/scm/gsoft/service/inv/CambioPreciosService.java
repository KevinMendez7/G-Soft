package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.CambioPrecios;

public interface CambioPreciosService {

	List<CambioPrecios> getCambioPreciosList();

	CambioPrecios getCambioPreciosById(Long idCambioPrecios);

	CambioPrecios getCambioPreciosByName(String nameCambioPrecios);

	void updateCambioPrecios(CambioPrecios cambioPrecios);

	void createCambioPrecios(CambioPrecios cambioPrecios);

	void removeCambioPrecios(Long idCambioPrecios);

}
