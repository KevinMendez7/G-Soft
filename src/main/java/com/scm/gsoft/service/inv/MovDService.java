package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MovD;

public interface MovDService {

	List<MovD> getMovDList();

	MovD getMovDById(Long idMovD);

	MovD getMovDByName(String nameMovD);

	void updateMovD(MovD movD);

	void createMovD(MovD movD);

	void removeMovD(Long idMovD);

}
