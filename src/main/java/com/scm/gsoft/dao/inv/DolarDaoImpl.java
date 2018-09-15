package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Dolar;

@Repository
@Transactional
public class DolarDaoImpl extends AbstractSession implements DolarDao {

	@Override
	public List<Dolar> getDolarList(){
		return (List<Dolar>) getCxcSession().createQuery("from Dolar").list();
	}

	@Override
	public Dolar getDolarById(Long idDolar) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Dolar.class, idDolar);
	}

	@Override
	public Dolar getDolarByName(String nameDolar) {
		// TODO Auto-generated method stub
		return (Dolar) getCxcSession().createQuery("from Dolar where nombre = :nameDolar")
				.setParameter("nameDolar", nameDolar).uniqueResult();
	}

	@Override
	public void updateDolar(Dolar dolar) {
		getCxcSession().update(dolar);

	}

	@Override
	public void createDolar(Dolar dolar) {

		getCxcSession().persist(dolar);

	}

	@Override
	public void removeDolar(Long idDolar) {

		Dolar dolar = getDolarById(idDolar);
		if(dolar != null) {
			getCxcSession().delete(dolar);
		}

	}

}
