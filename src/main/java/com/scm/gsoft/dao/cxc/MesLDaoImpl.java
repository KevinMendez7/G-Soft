package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.MesL;

@Repository
@Transactional
public class MesLDaoImpl extends AbstractSession implements MesLDao {

	@Override
	public List<MesL> getMesLList(){
		return (List<MesL>) getCxcSession().createQuery("from MesL").list();
	}

	@Override
	public MesL getMesLById(Long idMesL) {
		// TODO Auto-generated method stub
		return getCxcSession().get(MesL.class, idMesL);
	}

	@Override
	public MesL getMesLByName(String nameMesL) {
		// TODO Auto-generated method stub
		return (MesL) getCxcSession().createQuery("from MesL where nombre = :nameMesL")
				.setParameter("nameMesL", nameMesL).uniqueResult();
	}

	@Override
	public void updateMesL(MesL mesL) {
		getCxcSession().update(mesL);

	}

	@Override
	public void createMesL(MesL mesL) {

		getCxcSession().persist(mesL);

	}

	@Override
	public void removeMesL(Long idMesL) {

		MesL mesL = getMesLById(idMesL);
		if(mesL != null) {
			getCxcSession().delete(mesL);
		}

	}

}
