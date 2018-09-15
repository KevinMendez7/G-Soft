package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.ChequesDao;
import com.scm.gsoft.domain.cxc.Cheques;

@Service("ChequesService")
@Transactional
public class ChequesServiceImpl implements ChequesService {

	@Autowired
	private ChequesDao _chequesDao;

	@Override
	public List<Cheques> getChequesList(){
		return _chequesDao.getChequesList();
	}

	@Override
	public Cheques getChequesById(Long idCheques) {
		// TODO Auto-generated method stub
		return _chequesDao.getChequesById(idCheques);
	}

	@Override
	public Cheques getChequesByName(String nameCheques) {
		// TODO Auto-generated method stub
		return _chequesDao.getChequesByName(nameCheques);
	}

	@Override
	public void updateCheques(Cheques cheques) {

		_chequesDao.updateCheques(cheques);

	}

	@Override
	public void createCheques(Cheques cheques) {

		_chequesDao.createCheques(cheques);

	}

	@Override
	public void removeCheques(Long idCheques) {

		_chequesDao.removeCheques(idCheques);

	}

}
