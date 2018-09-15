package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.RequisicionD;

public interface RequisicionDDao {

	List<RequisicionD> getRequisicionDList();

	RequisicionD getRequisicionDById(Long idRequisicionD);

	RequisicionD getRequisicionDByName(String nameRequisicionD);

	void updateRequisicionD(RequisicionD requisicionD);

	void createRequisicionD(RequisicionD requisicionD);

	void removeRequisicionD(Long idRequisicionD);

}
