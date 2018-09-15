package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.HistArtD;

public interface HistArtDDao {

	List<HistArtD> getHistArtDList();

	HistArtD getHistArtDById(Long idHistArtD);

	HistArtD getHistArtDByName(String nameHistArtD);

	void updateHistArtD(HistArtD histArtD);

	void createHistArtD(HistArtD histArtD);

	void removeHistArtD(Long idHistArtD);

}
