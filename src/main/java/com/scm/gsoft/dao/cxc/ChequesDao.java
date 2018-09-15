package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Cheques;

public interface ChequesDao {

	List<Cheques> getChequesList();

	Cheques getChequesById(Long idCheques);

	Cheques getChequesByName(String nameCheques);

	void updateCheques(Cheques cheques);

	void createCheques(Cheques cheques);

	void removeCheques(Long idCheques);

}
