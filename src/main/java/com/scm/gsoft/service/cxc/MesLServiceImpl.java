package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.MesLDao;
import com.scm.gsoft.domain.cxc.MesL;

@Service("MesLService")
@Transactional
public class MesLServiceImpl implements MesLService {

	@Autowired
	private MesLDao _mesLDao;

	@Override
	public List<MesL> getMesLList(){
		return _mesLDao.getMesLList();
	}

	@Override
	public MesL getMesLById(Long idMesL) {
		// TODO Auto-generated method stub
		return _mesLDao.getMesLById(idMesL);
	}

	@Override
	public MesL getMesLByName(String nameMesL) {
		// TODO Auto-generated method stub
		return _mesLDao.getMesLByName(nameMesL);
	}

	@Override
	public void updateMesL(MesL mesL) {

		_mesLDao.updateMesL(mesL);

	}

	@Override
	public void createMesL(MesL mesL) {

		_mesLDao.createMesL(mesL);

	}

	@Override
	public void removeMesL(Long idMesL) {

		_mesLDao.removeMesL(idMesL);

	}

}
