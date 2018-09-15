package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Emisores;

public interface EmisoresDao {

	List<Emisores> getEmisoresList();

	Emisores getEmisoresById(Long idEmisores);

	Emisores getEmisoresByName(String nameEmisores);

	void updateEmisores(Emisores emisores);

	void createEmisores(Emisores emisores);

	void removeEmisores(Long idEmisores);

}
