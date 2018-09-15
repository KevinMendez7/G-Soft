package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MaebodDetPadre;

public interface MaebodDetPadreService {

	List<MaebodDetPadre> getMaebodDetPadreList();

	MaebodDetPadre getMaebodDetPadreById(Long idMaebodDetPadre);

	MaebodDetPadre getMaebodDetPadreByName(String nameMaebodDetPadre);

	void updateMaebodDetPadre(MaebodDetPadre maebodDetPadre);

	void createMaebodDetPadre(MaebodDetPadre maebodDetPadre);

	void removeMaebodDetPadre(Long idMaebodDetPadre);

}
