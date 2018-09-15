package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Maestro1;

public interface Maestro1Dao {

	List<Maestro1> getMaestro1List();

	Maestro1 getMaestro1ById(Long idMaestro1);

	Maestro1 getMaestro1ByName(String nameMaestro1);

	void updateMaestro1(Maestro1 maestro1);

	void createMaestro1(Maestro1 maestro1);

	void removeMaestro1(Long idMaestro1);

}
