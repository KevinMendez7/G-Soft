package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.ArticuloPadre;

public interface ArticuloPadreService {

	List<ArticuloPadre> getArticuloPadreList();

	ArticuloPadre getArticuloPadreById(Long idArticuloPadre);

	ArticuloPadre getArticuloPadreByName(String nameArticuloPadre);

	void updateArticuloPadre(ArticuloPadre articuloPadre);

	void createArticuloPadre(ArticuloPadre articuloPadre);

	void removeArticuloPadre(Long idArticuloPadre);

}
