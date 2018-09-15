package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.MaebodDetPadre;

@Repository
@Transactional
public class MaebodDetPadreDaoImpl extends AbstractSession implements MaebodDetPadreDao {

	@Override
	public List<MaebodDetPadre> getMaebodDetPadreList(){
		return (List<MaebodDetPadre>) getCxcSession().createQuery("from MaebodDetPadre").list();
	}

	@Override
	public MaebodDetPadre getMaebodDetPadreById(Long idMaebodDetPadre) {
		// TODO Auto-generated method stub
		return getCxcSession().get(MaebodDetPadre.class, idMaebodDetPadre);
	}

	@Override
	public MaebodDetPadre getMaebodDetPadreByName(String nameMaebodDetPadre) {
		// TODO Auto-generated method stub
		return (MaebodDetPadre) getCxcSession().createQuery("from MaebodDetPadre where nombre = :nameMaebodDetPadre")
				.setParameter("nameMaebodDetPadre", nameMaebodDetPadre).uniqueResult();
	}

	@Override
	public void updateMaebodDetPadre(MaebodDetPadre maebodDetPadre) {
		getCxcSession().update(maebodDetPadre);

	}

	@Override
	public void createMaebodDetPadre(MaebodDetPadre maebodDetPadre) {

		getCxcSession().persist(maebodDetPadre);

	}

	@Override
	public void removeMaebodDetPadre(Long idMaebodDetPadre) {

		MaebodDetPadre maebodDetPadre = getMaebodDetPadreById(idMaebodDetPadre);
		if(maebodDetPadre != null) {
			getCxcSession().delete(maebodDetPadre);
		}

	}

}
