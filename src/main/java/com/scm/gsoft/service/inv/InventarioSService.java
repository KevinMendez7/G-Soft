package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.InventarioS;

public interface InventarioSService {

	List<InventarioS> getInventarioSList();

	InventarioS getInventarioSById(Long idInventarioS);

	InventarioS getInventarioSByName(String nameInventarioS);

	void updateInventarioS(InventarioS inventarioS);

	void createInventarioS(InventarioS inventarioS);

	void removeInventarioS(Long idInventarioS);

}
