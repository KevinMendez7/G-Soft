package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.ArtD;

public interface ArtDDao {

	List<ArtD> getArtDList();

	ArtD getArtDById(Long idArtD);

	ArtD getArtDByName(String nameArtD);

	void updateArtD(ArtD artD);

	void createArtD(ArtD artD);

	void removeArtD(Long idArtD);

}
