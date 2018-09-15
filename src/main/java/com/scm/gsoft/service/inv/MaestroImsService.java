package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MaestroIms;

public interface MaestroImsService {

	List<MaestroIms> getMaestroImsList();

	MaestroIms getMaestroImsById(Long idMaestroIms);

	MaestroIms getMaestroImsByName(String nameMaestroIms);

	void updateMaestroIms(MaestroIms maestroIms);

	void createMaestroIms(MaestroIms maestroIms);

	void removeMaestroIms(Long idMaestroIms);

}
