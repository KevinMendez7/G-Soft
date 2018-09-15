package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.CabezaP;

public interface CabezaPService {

	List<CabezaP> getCabezaPList();

	CabezaP getCabezaPById(Long idCabezaP);

	CabezaP getCabezaPByName(String nameCabezaP);

	void updateCabezaP(CabezaP cabezaP);

	void createCabezaP(CabezaP cabezaP);

	void removeCabezaP(Long idCabezaP);

}
