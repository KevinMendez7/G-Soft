package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.EntregaMercDao;
import com.scm.gsoft.domain.cxc.EntregaMerc;

@Service("EntregaMercService")
@Transactional
public class EntregaMercServiceImpl implements EntregaMercService {

	@Autowired
	private EntregaMercDao _entregaMercDao;

	@Override
	public List<EntregaMerc> getEntregaMercList(){
		return _entregaMercDao.getEntregaMercList();
	}

	@Override
	public EntregaMerc getEntregaMercById(Long idEntregaMerc) {
		// TODO Auto-generated method stub
		return _entregaMercDao.getEntregaMercById(idEntregaMerc);
	}

	@Override
	public EntregaMerc getEntregaMercByName(String nameEntregaMerc) {
		// TODO Auto-generated method stub
		return _entregaMercDao.getEntregaMercByName(nameEntregaMerc);
	}

	@Override
	public void updateEntregaMerc(EntregaMerc entregaMerc) {

		_entregaMercDao.updateEntregaMerc(entregaMerc);

	}

	@Override
	public void createEntregaMerc(EntregaMerc entregaMerc) {

		_entregaMercDao.createEntregaMerc(entregaMerc);

	}

	@Override
	public void removeEntregaMerc(Long idEntregaMerc) {

		_entregaMercDao.removeEntregaMerc(idEntregaMerc);

	}

}
