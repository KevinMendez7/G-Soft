package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Dolar;

@Qualifier("DolarDaoCxc")
@Repository("DolarRepositoryCxc")
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
