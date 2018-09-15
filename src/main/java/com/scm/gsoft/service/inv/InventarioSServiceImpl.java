package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.InventarioSDao;
import com.scm.gsoft.domain.inv.InventarioS;

@Service("InventarioSService")
@Transactional
public class InventarioSServiceImpl implements InventarioSService {

	@Autowired
	private InventarioSDao _inventarioSDao;

	@Override
	public List<InventarioS> getInventarioSList(){
		return _inventarioSDao.getInventarioSList();
	}

	@Override
	public InventarioS getInventarioSById(Long idInventarioS) {
		// TODO Auto-generated method stub
		return _inventarioSDao.getInventarioSById(idInventarioS);
	}

	@Override
	public InventarioS getInventarioSByName(String nameInventarioS) {
		// TODO Auto-generated method stub
		return _inventarioSDao.getInventarioSByName(nameInventarioS);
	}

	@Override
	public void updateInventarioS(InventarioS inventarioS) {

		_inventarioSDao.updateInventarioS(inventarioS);

	}

	@Override
	public void createInventarioS(InventarioS inventarioS) {

		_inventarioSDao.createInventarioS(inventarioS);

	}

	@Override
	public void removeInventarioS(Long idInventarioS) {

		_inventarioSDao.removeInventarioS(idInventarioS);

	}

}
