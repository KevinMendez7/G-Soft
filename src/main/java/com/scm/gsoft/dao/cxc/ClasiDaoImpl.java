package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Clasi;

@Qualifier("ClasiDaoCxc")
@Repository("ClasiRepositoryCxc")
@Transactional
public class ClasiDaoImpl extends AbstractSession implements ClasiDao {

	@Override
	public List<Clasi> getClasiList(){
		return (List<Clasi>) getCxcSession().createQuery("from Clasi").list();
	}

	@Override
	public Clasi getClasiById(Long idClasi) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Clasi.class, idClasi);
	}

	@Override
	public Clasi getClasiByName(String nameClasi) {
		// TODO Auto-generated method stub
		return (Clasi) getCxcSession().createQuery("from Clasi where nombre = :nameClasi")
				.setParameter("nameClasi", nameClasi).uniqueResult();
	}

	@Override
	public void updateClasi(Clasi clasi) {
		getCxcSession().update(clasi);

	}

	@Override
	public void createClasi(Clasi clasi) {

		getCxcSession().persist(clasi);

	}

	@Override
	public void removeClasi(Long idClasi) {

		Clasi clasi = getClasiById(idClasi);
		if(clasi != null) {
			getCxcSession().delete(clasi);
		}

	}

}
