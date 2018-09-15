package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Tipo;

public interface TipoService {

	List<Tipo> getTipoList();

	Tipo getTipoById(Long idTipo);

	Tipo getTipoByName(String nameTipo);

	void updateTipo(Tipo tipo);

	void createTipo(Tipo tipo);

	void removeTipo(Long idTipo);

}
