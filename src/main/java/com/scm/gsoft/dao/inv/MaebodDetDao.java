package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MaebodDet;

public interface MaebodDetDao {

	List<MaebodDet> getMaebodDetList();

	MaebodDet getMaebodDetById(Long idMaebodDet);

	MaebodDet getMaebodDetByName(String nameMaebodDet);

	void updateMaebodDet(MaebodDet maebodDet);

	void createMaebodDet(MaebodDet maebodDet);

	void removeMaebodDet(Long idMaebodDet);

}
