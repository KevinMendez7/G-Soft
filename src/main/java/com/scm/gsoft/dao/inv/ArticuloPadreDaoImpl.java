package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.ArticuloPadre;

@Repository
@Transactional
public class ArticuloPadreDaoImpl extends AbstractSession implements ArticuloPadreDao {

	@Override
	public List<ArticuloPadre> getArticuloPadreList(){
		return (List<ArticuloPadre>) getCxcSession().createQuery("from ArticuloPadre").list();
	}

	@Override
	public ArticuloPadre getArticuloPadreById(Long idArticuloPadre) {
		// TODO Auto-generated method stub
		return getCxcSession().get(ArticuloPadre.class, idArticuloPadre);
	}

	@Override
	public ArticuloPadre getArticuloPadreByName(String nameArticuloPadre) {
		// TODO Auto-generated method stub
		return (ArticuloPadre) getCxcSession().createQuery("from ArticuloPadre where nombre = :nameArticuloPadre")
				.setParameter("nameArticuloPadre", nameArticuloPadre).uniqueResult();
	}

	@Override
	public void updateArticuloPadre(ArticuloPadre articuloPadre) {
		getCxcSession().update(articuloPadre);

	}

	@Override
	public void createArticuloPadre(ArticuloPadre articuloPadre) {

		getCxcSession().persist(articuloPadre);

	}

	@Override
	public void removeArticuloPadre(Long idArticuloPadre) {

		ArticuloPadre articuloPadre = getArticuloPadreById(idArticuloPadre);
		if(articuloPadre != null) {
			getCxcSession().delete(articuloPadre);
		}

	}

}
