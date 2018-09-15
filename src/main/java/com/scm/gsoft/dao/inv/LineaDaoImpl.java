package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Linea;

@Repository
@Transactional
public class LineaDaoImpl extends AbstractSession implements LineaDao {

	@Override
	public List<Linea> getLineaList(){
		return (List<Linea>) getCxcSession().createQuery("from Linea").list();
	}

	@Override
	public Linea getLineaById(Long idLinea) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Linea.class, idLinea);
	}

	@Override
	public Linea getLineaByName(String nameLinea) {
		// TODO Auto-generated method stub
		return (Linea) getCxcSession().createQuery("from Linea where nombre = :nameLinea")
				.setParameter("nameLinea", nameLinea).uniqueResult();
	}

	@Override
	public void updateLinea(Linea linea) {
		getCxcSession().update(linea);

	}

	@Override
	public void createLinea(Linea linea) {

		getCxcSession().persist(linea);

	}

	@Override
	public void removeLinea(Long idLinea) {

		Linea linea = getLineaById(idLinea);
		if(linea != null) {
			getCxcSession().delete(linea);
		}

	}

}
