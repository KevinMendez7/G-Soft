package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.SegL;

@Repository
@Transactional
public class SegLDaoImpl extends AbstractSession implements SegLDao {

	@Override
	public List<SegL> getSegLList(){
		return (List<SegL>) getCxcSession().createQuery("from SegL").list();
	}

	@Override
	public SegL getSegLById(Long idSegL) {
		// TODO Auto-generated method stub
		return getCxcSession().get(SegL.class, idSegL);
	}

	@Override
	public SegL getSegLByName(String nameSegL) {
		// TODO Auto-generated method stub
		return (SegL) getCxcSession().createQuery("from SegL where nombre = :nameSegL")
				.setParameter("nameSegL", nameSegL).uniqueResult();
	}

	@Override
	public void updateSegL(SegL segL) {
		getCxcSession().update(segL);

	}

	@Override
	public void createSegL(SegL segL) {

		getCxcSession().persist(segL);

	}

	@Override
	public void removeSegL(Long idSegL) {

		SegL segL = getSegLById(idSegL);
		if(segL != null) {
			getCxcSession().delete(segL);
		}

	}

}
