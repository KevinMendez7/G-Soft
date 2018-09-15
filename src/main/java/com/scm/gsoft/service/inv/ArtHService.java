package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.ArtH;

public interface ArtHService {

	List<ArtH> getArtHList();

	ArtH getArtHById(Long idArtH);

	ArtH getArtHByName(String nameArtH);

	void updateArtH(ArtH artH);

	void createArtH(ArtH artH);

	void removeArtH(Long idArtH);

}
