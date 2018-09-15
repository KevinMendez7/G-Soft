package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.RequisicionH;

@Repository
@Transactional
public class RequisicionHDaoImpl extends AbstractSession implements RequisicionHDao {

	@Override
	public List<RequisicionH> getRequisicionHList(){
		return (List<RequisicionH>) getCxcSession().createQuery("from RequisicionH").list();
	}

	@Override
	public RequisicionH getRequisicionHById(Long idRequisicionH) {
		// TODO Auto-generated method stub
		return getCxcSession().get(RequisicionH.class, idRequisicionH);
	}

	@Override
	public RequisicionH getRequisicionHByName(String nameRequisicionH) {
		// TODO Auto-generated method stub
		return (RequisicionH) getCxcSession().createQuery("from RequisicionH where nombre = :nameRequisicionH")
				.setParameter("nameRequisicionH", nameRequisicionH).uniqueResult();
	}

	@Override
	public void updateRequisicionH(RequisicionH requisicionH) {
		getCxcSession().update(requisicionH);

	}

	@Override
	public void createRequisicionH(RequisicionH requisicionH) {

		getCxcSession().persist(requisicionH);

	}

	@Override
	public void removeRequisicionH(Long idRequisicionH) {

		RequisicionH requisicionH = getRequisicionHById(idRequisicionH);
		if(requisicionH != null) {
			getCxcSession().delete(requisicionH);
		}

	}

}
