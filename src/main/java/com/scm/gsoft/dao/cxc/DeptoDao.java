package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Depto;

public interface DeptoDao {

	List<Depto> getDeptoList();

	Depto getDeptoById(Long idDepto);

	Depto getDeptoByName(String nameDepto);

	void updateDepto(Depto depto);

	void createDepto(Depto depto);

	void removeDepto(Long idDepto);

}
