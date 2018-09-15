package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Familia;

@Repository
@Transactional
public class FamiliaDaoImpl extends AbstractSession implements FamiliaDao {

	@Override
	public List<Familia> getFamiliaList(){
		return (List<Familia>) getCxcSession().createQuery("from Familia").list();
	}

	@Override
	public Familia getFamiliaById(Long idFamilia) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Familia.class, idFamilia);
	}

	@Override
	public Familia getFamiliaByName(String nameFamilia) {
		// TODO Auto-generated method stub
		return (Familia) getCxcSession().createQuery("from Familia where nombre = :nameFamilia")
				.setParameter("nameFamilia", nameFamilia).uniqueResult();
	}

	@Override
	public void updateFamilia(Familia familia) {
		getCxcSession().update(familia);

	}

	@Override
	public void createFamilia(Familia familia) {

		getCxcSession().persist(familia);

	}

	@Override
	public void removeFamilia(Long idFamilia) {

		Familia familia = getFamiliaById(idFamilia);
		if(familia != null) {
			getCxcSession().delete(familia);
		}

	}

}
