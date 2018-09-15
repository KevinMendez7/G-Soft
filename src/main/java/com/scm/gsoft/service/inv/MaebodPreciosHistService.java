package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.MaebodPreciosHist;

public interface MaebodPreciosHistService {

	List<MaebodPreciosHist> getMaebodPreciosHistList();

	MaebodPreciosHist getMaebodPreciosHistById(Long idMaebodPreciosHist);

	MaebodPreciosHist getMaebodPreciosHistByName(String nameMaebodPreciosHist);

	void updateMaebodPreciosHist(MaebodPreciosHist maebodPreciosHist);

	void createMaebodPreciosHist(MaebodPreciosHist maebodPreciosHist);

	void removeMaebodPreciosHist(Long idMaebodPreciosHist);

}
