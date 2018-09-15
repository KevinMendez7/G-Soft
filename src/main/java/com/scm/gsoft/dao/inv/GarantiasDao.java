package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Garantias;

public interface GarantiasDao {

	List<Garantias> getGarantiasList();

	Garantias getGarantiasById(Long idGarantias);

	Garantias getGarantiasByName(String nameGarantias);

	void updateGarantias(Garantias garantias);

	void createGarantias(Garantias garantias);

	void removeGarantias(Long idGarantias);

}
