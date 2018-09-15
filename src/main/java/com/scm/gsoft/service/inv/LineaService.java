package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Linea;

public interface LineaService {

	List<Linea> getLineaList();

	Linea getLineaById(Long idLinea);

	Linea getLineaByName(String nameLinea);

	void updateLinea(Linea linea);

	void createLinea(Linea linea);

	void removeLinea(Long idLinea);

}
