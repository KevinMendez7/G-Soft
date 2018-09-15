package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Estanterias;

public interface EstanteriasService {

	List<Estanterias> getEstanteriasList();

	Estanterias getEstanteriasById(Long idEstanterias);

	Estanterias getEstanteriasByName(String nameEstanterias);

	void updateEstanterias(Estanterias estanterias);

	void createEstanterias(Estanterias estanterias);

	void removeEstanterias(Long idEstanterias);

}
