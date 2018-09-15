package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Borra;

public interface BorraDao {

	List<Borra> getBorraList();

	Borra getBorraById(Long idBorra);

	Borra getBorraByName(String nameBorra);

	void updateBorra(Borra borra);

	void createBorra(Borra borra);

	void removeBorra(Long idBorra);

}
