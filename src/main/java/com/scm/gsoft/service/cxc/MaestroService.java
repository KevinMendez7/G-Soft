package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Maestro;

public interface MaestroService {

	List<Maestro> getMaestroList();

	Maestro getMaestroById(Long idMaestro);

	Maestro getMaestroByName(String nameMaestro);

	void updateMaestro(Maestro maestro);

	void createMaestro(Maestro maestro);

	void removeMaestro(Long idMaestro);

}
