package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Maebod;

public interface MaebodService {

	List<Maebod> getMaebodList();

	Maebod getMaebodById(Long idMaebod);

	Maebod getMaebodByName(String nameMaebod);

	void updateMaebod(Maebod maebod);

	void createMaebod(Maebod maebod);

	void removeMaebod(Long idMaebod);

}
