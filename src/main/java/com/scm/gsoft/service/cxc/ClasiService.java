package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Clasi;

public interface ClasiService {

	List<Clasi> getClasiList();

	Clasi getClasiById(Long idClasi);

	Clasi getClasiByName(String nameClasi);

	void updateClasi(Clasi clasi);

	void createClasi(Clasi clasi);

	void removeClasi(Long idClasi);

}
