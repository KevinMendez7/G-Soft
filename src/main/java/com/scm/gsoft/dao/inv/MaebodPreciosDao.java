package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MaebodPrecios;

public interface MaebodPreciosDao {

	List<MaebodPrecios> getMaebodPreciosList();

	MaebodPrecios getMaebodPreciosById(Long idMaebodPrecios);

	MaebodPrecios getMaebodPreciosByName(String nameMaebodPrecios);

	void updateMaebodPrecios(MaebodPrecios maebodPrecios);

	void createMaebodPrecios(MaebodPrecios maebodPrecios);

	void removeMaebodPrecios(Long idMaebodPrecios);

}
