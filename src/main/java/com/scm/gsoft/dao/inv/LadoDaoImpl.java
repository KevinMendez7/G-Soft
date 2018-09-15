package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Lado;

@Repository
@Transactional
public class LadoDaoImpl extends AbstractSession implements LadoDao {

	@Override
	public List<Lado> getLadoList(){
		return (List<Lado>) getCxcSession().createQuery("from Lado").list();
	}

	@Override
	public Lado getLadoById(Long idLado) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Lado.class, idLado);
	}

	@Override
	public Lado getLadoByName(String nameLado) {
		// TODO Auto-generated method stub
		return (Lado) getCxcSession().createQuery("from Lado where nombre = :nameLado")
				.setParameter("nameLado", nameLado).uniqueResult();
	}

	@Override
	public void updateLado(Lado lado) {
		getCxcSession().update(lado);

	}

	@Override
	public void createLado(Lado lado) {

		getCxcSession().persist(lado);

	}

	@Override
	public void removeLado(Long idLado) {

		Lado lado = getLadoById(idLado);
		if(lado != null) {
			getCxcSession().delete(lado);
		}

	}

}
