package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MaebodDetPadre;

public interface MaebodDetPadreDao {

	List<MaebodDetPadre> getMaebodDetPadreList();

	MaebodDetPadre getMaebodDetPadreById(Long idMaebodDetPadre);

	MaebodDetPadre getMaebodDetPadreByName(String nameMaebodDetPadre);

	void updateMaebodDetPadre(MaebodDetPadre maebodDetPadre);

	void createMaebodDetPadre(MaebodDetPadre maebodDetPadre);

	void removeMaebodDetPadre(Long idMaebodDetPadre);

}
