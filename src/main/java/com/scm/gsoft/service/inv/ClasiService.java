package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Clasi;

public interface ClasiService {

	List<Clasi> getClasiList();

	Clasi getClasiById(Long idClasi);

	Clasi getClasiByName(String nameClasi);

	void updateClasi(Clasi clasi);

	void createClasi(Clasi clasi);

	void removeClasi(Long idClasi);

}
