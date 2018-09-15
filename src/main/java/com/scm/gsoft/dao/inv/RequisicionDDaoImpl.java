package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.RequisicionD;

@Repository
@Transactional
public class RequisicionDDaoImpl extends AbstractSession implements RequisicionDDao {

	@Override
	public List<RequisicionD> getRequisicionDList(){
		return (List<RequisicionD>) getCxcSession().createQuery("from RequisicionD").list();
	}

	@Override
	public RequisicionD getRequisicionDById(Long idRequisicionD) {
		// TODO Auto-generated method stub
		return getCxcSession().get(RequisicionD.class, idRequisicionD);
	}

	@Override
	public RequisicionD getRequisicionDByName(String nameRequisicionD) {
		// TODO Auto-generated method stub
		return (RequisicionD) getCxcSession().createQuery("from RequisicionD where nombre = :nameRequisicionD")
				.setParameter("nameRequisicionD", nameRequisicionD).uniqueResult();
	}

	@Override
	public void updateRequisicionD(RequisicionD requisicionD) {
		getCxcSession().update(requisicionD);

	}

	@Override
	public void createRequisicionD(RequisicionD requisicionD) {

		getCxcSession().persist(requisicionD);

	}

	@Override
	public void removeRequisicionD(Long idRequisicionD) {

		RequisicionD requisicionD = getRequisicionDById(idRequisicionD);
		if(requisicionD != null) {
			getCxcSession().delete(requisicionD);
		}

	}

}
