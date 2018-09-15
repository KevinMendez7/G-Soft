package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.AniosArt;

public interface AniosArtDao {

	List<AniosArt> getAniosArtList();

	AniosArt getAniosArtById(Long idAniosArt);

	AniosArt getAniosArtByName(String nameAniosArt);

	void updateAniosArt(AniosArt aniosArt);

	void createAniosArt(AniosArt aniosArt);

	void removeAniosArt(Long idAniosArt);

}
