package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Depto;

public interface DeptoService {

	List<Depto> getDeptoList();

	Depto getDeptoById(Long idDepto);

	Depto getDeptoByName(String nameDepto);

	void updateDepto(Depto depto);

	void createDepto(Depto depto);

	void removeDepto(Long idDepto);

}
