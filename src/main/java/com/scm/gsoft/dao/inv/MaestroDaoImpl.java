package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Maestro;

@Repository
@Transactional
public class MaestroDaoImpl extends AbstractSession implements MaestroDao {

	@Override
	public List<Maestro> getMaestroList(){
		return (List<Maestro>) getCxcSession().createQuery("from Maestro").list();
	}

	@Override
	public Maestro getMaestroById(Long idMaestro) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Maestro.class, idMaestro);
	}

	@Override
	public Maestro getMaestroByName(String nameMaestro) {
		// TODO Auto-generated method stub
		return (Maestro) getCxcSession().createQuery("from Maestro where nombre = :nameMaestro")
				.setParameter("nameMaestro", nameMaestro).uniqueResult();
	}

	@Override
	public void updateMaestro(Maestro maestro) {
		getCxcSession().update(maestro);

	}

	@Override
	public void createMaestro(Maestro maestro) {

		getCxcSession().persist(maestro);

	}

	@Override
	public void removeMaestro(Long idMaestro) {

		Maestro maestro = getMaestroById(idMaestro);
		if(maestro != null) {
			getCxcSession().delete(maestro);
		}

	}

}
