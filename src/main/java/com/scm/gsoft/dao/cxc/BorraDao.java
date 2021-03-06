package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Borra;

public interface BorraDao {

	List<Borra> getBorraList();

	Borra getBorraById(Long idBorra);

	Borra getBorraByCodeBodega(String codeBodega);

	void updateBorra(Borra borra);

	void createBorra(Borra borra);

	void removeBorra(Long idBorra);

}
