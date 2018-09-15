package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Maestro;

public interface MaestroDao {

	List<Maestro> getMaestroList();

	Maestro getMaestroById(Long idMaestro);

	Maestro getMaestroByName(String nameMaestro);

	void updateMaestro(Maestro maestro);

	void createMaestro(Maestro maestro);

	void removeMaestro(Long idMaestro);

}
