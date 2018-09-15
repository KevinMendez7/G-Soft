package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Hoja1S;

@Repository
@Transactional
public class Hoja1SDaoImpl extends AbstractSession implements Hoja1SDao {

	@Override
	public List<Hoja1S> getHoja1SList(){
		return (List<Hoja1S>) getCxcSession().createQuery("from Hoja1S").list();
	}

	@Override
	public Hoja1S getHoja1SById(Long idHoja1S) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Hoja1S.class, idHoja1S);
	}

	@Override
	public Hoja1S getHoja1SByName(String nameHoja1S) {
		// TODO Auto-generated method stub
		return (Hoja1S) getCxcSession().createQuery("from Hoja1S where nombre = :nameHoja1S")
				.setParameter("nameHoja1S", nameHoja1S).uniqueResult();
	}

	@Override
	public void updateHoja1S(Hoja1S hoja1S) {
		getCxcSession().update(hoja1S);

	}

	@Override
	public void createHoja1S(Hoja1S hoja1S) {

		getCxcSession().persist(hoja1S);

	}

	@Override
	public void removeHoja1S(Long idHoja1S) {

		Hoja1S hoja1S = getHoja1SById(idHoja1S);
		if(hoja1S != null) {
			getCxcSession().delete(hoja1S);
		}

	}

}
