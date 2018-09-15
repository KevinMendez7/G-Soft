package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.HistArtD;

public interface HistArtDService {

	List<HistArtD> getHistArtDList();

	HistArtD getHistArtDById(Long idHistArtD);

	HistArtD getHistArtDByName(String nameHistArtD);

	void updateHistArtD(HistArtD histArtD);

	void createHistArtD(HistArtD histArtD);

	void removeHistArtD(Long idHistArtD);

}
