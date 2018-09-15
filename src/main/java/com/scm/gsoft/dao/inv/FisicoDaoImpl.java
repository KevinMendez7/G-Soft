package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Fisico;

@Repository
@Transactional
public class FisicoDaoImpl extends AbstractSession implements FisicoDao {

	@Override
	public List<Fisico> getFisicoList(){
		return (List<Fisico>) getCxcSession().createQuery("from Fisico").list();
	}

	@Override
	public Fisico getFisicoById(Long idFisico) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Fisico.class, idFisico);
	}

	@Override
	public Fisico getFisicoByName(String nameFisico) {
		// TODO Auto-generated method stub
		return (Fisico) getCxcSession().createQuery("from Fisico where nombre = :nameFisico")
				.setParameter("nameFisico", nameFisico).uniqueResult();
	}

	@Override
	public void updateFisico(Fisico fisico) {
		getCxcSession().update(fisico);

	}

	@Override
	public void createFisico(Fisico fisico) {

		getCxcSession().persist(fisico);

	}

	@Override
	public void removeFisico(Long idFisico) {

		Fisico fisico = getFisicoById(idFisico);
		if(fisico != null) {
			getCxcSession().delete(fisico);
		}

	}

}
