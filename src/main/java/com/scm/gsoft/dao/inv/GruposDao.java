package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Grupos;

public interface GruposDao {

	List<Grupos> getGruposList();

	Grupos getGruposById(Long idGrupos);

	Grupos getGruposByName(String nameGrupos);

	void updateGrupos(Grupos grupos);

	void createGrupos(Grupos grupos);

	void removeGrupos(Long idGrupos);

}
