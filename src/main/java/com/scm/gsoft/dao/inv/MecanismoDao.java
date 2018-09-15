package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Mecanismo;

public interface MecanismoDao {

	List<Mecanismo> getMecanismoList();

	Mecanismo getMecanismoById(Long idMecanismo);

	Mecanismo getMecanismoByName(String nameMecanismo);

	void updateMecanismo(Mecanismo mecanismo);

	void createMecanismo(Mecanismo mecanismo);

	void removeMecanismo(Long idMecanismo);

}
