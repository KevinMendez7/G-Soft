package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.GruposS;

public interface GruposSService {

	List<GruposS> getGruposSList();

	GruposS getGruposSById(Long idGruposS);

	GruposS getGruposSByName(String nameGruposS);

	void updateGruposS(GruposS gruposS);

	void createGruposS(GruposS gruposS);

	void removeGruposS(Long idGruposS);

}
