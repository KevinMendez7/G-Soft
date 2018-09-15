package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Grupos;

public interface GruposService {

	List<Grupos> getGruposList();

	Grupos getGruposById(Long idGrupos);

	Grupos getGruposByName(String nameGrupos);

	void updateGrupos(Grupos grupos);

	void createGrupos(Grupos grupos);

	void removeGrupos(Long idGrupos);

}
