package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Graf;

public interface GrafDao {

	List<Graf> getGrafList();

	Graf getGrafById(Long idGraf);

	Graf getGrafByName(String nameGraf);

	void updateGraf(Graf graf);

	void createGraf(Graf graf);

	void removeGraf(Long idGraf);

}
