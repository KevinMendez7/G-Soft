package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Depto;

@Qualifier("DeptoDaoCxc")
@Repository("DeptoRepositoryCxc")
@Transactional
public class DeptoDaoImpl extends AbstractSession implements DeptoDao {

	@Override
	public List<Depto> getDeptoList(){
		return (List<Depto>) getCxcSession().createQuery("from Depto").list();
	}

	@Override
	public Depto getDeptoById(Long idDepto) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Depto.class, idDepto);
	}

	@Override
	public Depto getDeptoByName(String nameDepto) {
		// TODO Auto-generated method stub
		return (Depto) getCxcSession().createQuery("from Depto where nombre = :nameDepto")
				.setParameter("nameDepto", nameDepto).uniqueResult();
	}

	@Override
	public void updateDepto(Depto depto) {
		getCxcSession().update(depto);

	}

	@Override
	public void createDepto(Depto depto) {

		getCxcSession().persist(depto);

	}

	@Override
	public void removeDepto(Long idDepto) {

		Depto depto = getDeptoById(idDepto);
		if(depto != null) {
			getCxcSession().delete(depto);
		}

	}

}
