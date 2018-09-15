package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Tipo;

public interface TipoDao {

	List<Tipo> getTipoList();

	Tipo getTipoById(Long idTipo);

	Tipo getTipoByName(String nameTipo);

	void updateTipo(Tipo tipo);

	void createTipo(Tipo tipo);

	void removeTipo(Long idTipo);

}
