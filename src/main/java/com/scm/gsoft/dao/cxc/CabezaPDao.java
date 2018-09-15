package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.CabezaP;

public interface CabezaPDao {

	List<CabezaP> getCabezaPList();

	CabezaP getCabezaPById(Long idCabezaP);

	CabezaP getCabezaPByName(String nameCabezaP);

	void updateCabezaP(CabezaP cabezaP);

	void createCabezaP(CabezaP cabezaP);

	void removeCabezaP(Long idCabezaP);

}
