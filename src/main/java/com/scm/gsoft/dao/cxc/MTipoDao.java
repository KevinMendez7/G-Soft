package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.MTipo;

public interface MTipoDao {

	List<MTipo> getMTipoList();

	MTipo getMTipoById(Long idMTipo);

	MTipo getMTipoByName(String nameMTipo);

	void updateMTipo(MTipo mTipo);

	void createMTipo(MTipo mTipo);

	void removeMTipo(Long idMTipo);

}
