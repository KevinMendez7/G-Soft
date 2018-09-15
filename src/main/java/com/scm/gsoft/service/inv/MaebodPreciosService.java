package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MaebodPrecios;

public interface MaebodPreciosService {

	List<MaebodPrecios> getMaebodPreciosList();

	MaebodPrecios getMaebodPreciosById(Long idMaebodPrecios);

	MaebodPrecios getMaebodPreciosByName(String nameMaebodPrecios);

	void updateMaebodPrecios(MaebodPrecios maebodPrecios);

	void createMaebodPrecios(MaebodPrecios maebodPrecios);

	void removeMaebodPrecios(Long idMaebodPrecios);

}
