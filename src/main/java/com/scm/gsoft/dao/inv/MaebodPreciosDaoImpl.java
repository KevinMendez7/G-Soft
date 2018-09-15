package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.MaebodPrecios;

@Repository
@Transactional
public class MaebodPreciosDaoImpl extends AbstractSession implements MaebodPreciosDao {

	@Override
	public List<MaebodPrecios> getMaebodPreciosList(){
		return (List<MaebodPrecios>) getCxcSession().createQuery("from MaebodPrecios").list();
	}

	@Override
	public MaebodPrecios getMaebodPreciosById(Long idMaebodPrecios) {
		// TODO Auto-generated method stub
		return getCxcSession().get(MaebodPrecios.class, idMaebodPrecios);
	}

	@Override
	public MaebodPrecios getMaebodPreciosByName(String nameMaebodPrecios) {
		// TODO Auto-generated method stub
		return (MaebodPrecios) getCxcSession().createQuery("from MaebodPrecios where nombre = :nameMaebodPrecios")
				.setParameter("nameMaebodPrecios", nameMaebodPrecios).uniqueResult();
	}

	@Override
	public void updateMaebodPrecios(MaebodPrecios maebodPrecios) {
		getCxcSession().update(maebodPrecios);

	}

	@Override
	public void createMaebodPrecios(MaebodPrecios maebodPrecios) {

		getCxcSession().persist(maebodPrecios);

	}

	@Override
	public void removeMaebodPrecios(Long idMaebodPrecios) {

		MaebodPrecios maebodPrecios = getMaebodPreciosById(idMaebodPrecios);
		if(maebodPrecios != null) {
			getCxcSession().delete(maebodPrecios);
		}

	}

}
