package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.EntregaMerc;

public interface EntregaMercDao {

	List<EntregaMerc> getEntregaMercList();

	EntregaMerc getEntregaMercById(Long idEntregaMerc);

	EntregaMerc getEntregaMercByName(String nameEntregaMerc);

	void updateEntregaMerc(EntregaMerc entregaMerc);

	void createEntregaMerc(EntregaMerc entregaMerc);

	void removeEntregaMerc(Long idEntregaMerc);

}
