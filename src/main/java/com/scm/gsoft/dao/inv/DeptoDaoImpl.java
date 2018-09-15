package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Depto;

@Repository
@Transactional
public class DeptoDaoImpl extends AbstractSession implements DeptoDao {

	@Override
	public List<Depto> getDeptoList(){
		return (List<Depto>) getCxcSession().createQuery("from Depto").list();
	}

	@Override
	public Depto getDeptoById(Long idDepto) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Depto.class, idDepto);
	}

	@Override
	public Depto getDeptoByName(String nameDepto) {
		// TODO Auto-generated method stub
		return (Depto) getCxcSession().createQuery("from Depto where nombre = :nameDepto")
				.setParameter("nameDepto", nameDepto).uniqueResult();
	}

	@Override
	public void updateDepto(Depto depto) {
		getCxcSession().update(depto);

	}

	@Override
	public void createDepto(Depto depto) {

		getCxcSession().persist(depto);

	}

	@Override
	public void removeDepto(Long idDepto) {

		Depto depto = getDeptoById(idDepto);
		if(depto != null) {
			getCxcSession().delete(depto);
		}

	}

}
