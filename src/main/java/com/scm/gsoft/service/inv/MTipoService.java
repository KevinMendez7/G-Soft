package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MTipo;

public interface MTipoService {

	List<MTipo> getMTipoList();

	MTipo getMTipoById(Long idMTipo);

	MTipo getMTipoByName(String nameMTipo);

	void updateMTipo(MTipo mTipo);

	void createMTipo(MTipo mTipo);

	void removeMTipo(Long idMTipo);

}
