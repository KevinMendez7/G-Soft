package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Garantias;

public interface GarantiasService {

	List<Garantias> getGarantiasList();

	Garantias getGarantiasById(Long idGarantias);

	Garantias getGarantiasByName(String nameGarantias);

	void updateGarantias(Garantias garantias);

	void createGarantias(Garantias garantias);

	void removeGarantias(Long idGarantias);

}
