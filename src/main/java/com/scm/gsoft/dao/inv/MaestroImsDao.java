package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MaestroIms;

public interface MaestroImsDao {

	List<MaestroIms> getMaestroImsList();

	MaestroIms getMaestroImsById(Long idMaestroIms);

	MaestroIms getMaestroImsByName(String nameMaestroIms);

	void updateMaestroIms(MaestroIms maestroIms);

	void createMaestroIms(MaestroIms maestroIms);

	void removeMaestroIms(Long idMaestroIms);

}
