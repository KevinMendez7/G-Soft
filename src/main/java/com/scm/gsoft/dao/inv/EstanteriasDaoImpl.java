package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Estanterias;

@Repository
@Transactional
public class EstanteriasDaoImpl extends AbstractSession implements EstanteriasDao {

	@Override
	public List<Estanterias> getEstanteriasList(){
		return (List<Estanterias>) getCxcSession().createQuery("from Estanterias").list();
	}

	@Override
	public Estanterias getEstanteriasById(Long idEstanterias) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Estanterias.class, idEstanterias);
	}

	@Override
	public Estanterias getEstanteriasByName(String nameEstanterias) {
		// TODO Auto-generated method stub
		return (Estanterias) getCxcSession().createQuery("from Estanterias where nombre = :nameEstanterias")
				.setParameter("nameEstanterias", nameEstanterias).uniqueResult();
	}

	@Override
	public void updateEstanterias(Estanterias estanterias) {
		getCxcSession().update(estanterias);

	}

	@Override
	public void createEstanterias(Estanterias estanterias) {

		getCxcSession().persist(estanterias);

	}

	@Override
	public void removeEstanterias(Long idEstanterias) {

		Estanterias estanterias = getEstanteriasById(idEstanterias);
		if(estanterias != null) {
			getCxcSession().delete(estanterias);
		}

	}

}
