package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.CiaL;

public interface CiaLService {

	List<CiaL> getCiaLList();

	CiaL getCiaLById(Long idCiaL);

	CiaL getCiaLByName(String nameCiaL);

	void updateCiaL(CiaL ciaL);

	void createCiaL(CiaL ciaL);

	void removeCiaL(Long idCiaL);

}
