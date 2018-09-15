package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.HistArtH;

public interface HistArtHDao {

	List<HistArtH> getHistArtHList();

	HistArtH getHistArtHById(Long idHistArtH);

	HistArtH getHistArtHByName(String nameHistArtH);

	void updateHistArtH(HistArtH histArtH);

	void createHistArtH(HistArtH histArtH);

	void removeHistArtH(Long idHistArtH);

}
