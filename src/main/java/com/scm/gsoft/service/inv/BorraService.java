package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Borra;

public interface BorraService {

	List<Borra> getBorraList();

	Borra getBorraById(Long idBorra);

	Borra getBorraByName(String nameBorra);

	void updateBorra(Borra borra);

	void createBorra(Borra borra);

	void removeBorra(Long idBorra);

}
