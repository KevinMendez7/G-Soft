package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Clasi;

public interface ClasiDao {

	List<Clasi> getClasiList();

	Clasi getClasiById(Long idClasi);

	Clasi getClasiByName(String nameClasi);

	void updateClasi(Clasi clasi);

	void createClasi(Clasi clasi);

	void removeClasi(Long idClasi);

}
