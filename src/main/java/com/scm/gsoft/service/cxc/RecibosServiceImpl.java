package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.RecibosDao;
import com.scm.gsoft.domain.cxc.Recibos;

@Service("RecibosService")
@Transactional
public class RecibosServiceImpl implements RecibosService {

	@Autowired
	private RecibosDao _recibosDao;

	@Override
	public List<Recibos> getRecibosList(){
		return _recibosDao.getRecibosList();
	}

	@Override
	public Recibos getRecibosById(Long idRecibos) {
		// TODO Auto-generated method stub
		return _recibosDao.getRecibosById(idRecibos);
	}

	@Override
	public Recibos getRecibosByName(String nameRecibos) {
		// TODO Auto-generated method stub
		return _recibosDao.getRecibosByName(nameRecibos);
	}

	@Override
	public void updateRecibos(Recibos recibos) {

		_recibosDao.updateRecibos(recibos);

	}

	@Override
	public void createRecibos(Recibos recibos) {

		_recibosDao.createRecibos(recibos);

	}

	@Override
	public void removeRecibos(Long idRecibos) {

		_recibosDao.removeRecibos(idRecibos);

	}

}
