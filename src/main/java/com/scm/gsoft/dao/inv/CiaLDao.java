package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.CiaL;

public interface CiaLDao {

	List<CiaL> getCiaLList();

	CiaL getCiaLById(Long idCiaL);

	CiaL getCiaLByName(String nameCiaL);

	void updateCiaL(CiaL ciaL);

	void createCiaL(CiaL ciaL);

	void removeCiaL(Long idCiaL);

}
