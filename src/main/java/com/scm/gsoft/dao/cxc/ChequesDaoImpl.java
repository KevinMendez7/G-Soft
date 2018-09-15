package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Cheques;

@Repository
@Transactional
public class ChequesDaoImpl extends AbstractSession implements ChequesDao {

	@Override
	public List<Cheques> getChequesList(){
		return (List<Cheques>) getCxcSession().createQuery("from Cheques").list();
	}

	@Override
	public Cheques getChequesById(Long idCheques) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Cheques.class, idCheques);
	}

	@Override
	public Cheques getChequesByName(String nameCheques) {
		// TODO Auto-generated method stub
		return (Cheques) getCxcSession().createQuery("from Cheques where nombre = :nameCheques")
				.setParameter("nameCheques", nameCheques).uniqueResult();
	}

	@Override
	public void updateCheques(Cheques cheques) {
		getCxcSession().update(cheques);

	}

	@Override
	public void createCheques(Cheques cheques) {

		getCxcSession().persist(cheques);

	}

	@Override
	public void removeCheques(Long idCheques) {

		Cheques cheques = getChequesById(idCheques);
		if(cheques != null) {
			getCxcSession().delete(cheques);
		}

	}

}
