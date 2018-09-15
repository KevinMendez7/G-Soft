package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Graf;

@Repository
@Transactional
public class GrafDaoImpl extends AbstractSession implements GrafDao {

	@Override
	public List<Graf> getGrafList(){
		return (List<Graf>) getCxcSession().createQuery("from Graf").list();
	}

	@Override
	public Graf getGrafById(Long idGraf) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Graf.class, idGraf);
	}

	@Override
	public Graf getGrafByName(String nameGraf) {
		// TODO Auto-generated method stub
		return (Graf) getCxcSession().createQuery("from Graf where nombre = :nameGraf")
				.setParameter("nameGraf", nameGraf).uniqueResult();
	}

	@Override
	public void updateGraf(Graf graf) {
		getCxcSession().update(graf);

	}

	@Override
	public void createGraf(Graf graf) {

		getCxcSession().persist(graf);

	}

	@Override
	public void removeGraf(Long idGraf) {

		Graf graf = getGrafById(idGraf);
		if(graf != null) {
			getCxcSession().delete(graf);
		}

	}

}
