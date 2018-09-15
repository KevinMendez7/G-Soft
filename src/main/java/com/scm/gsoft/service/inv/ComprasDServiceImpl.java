package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ComprasDDao;
import com.scm.gsoft.domain.inv.ComprasD;

@Service("ComprasDService")
@Transactional
public class ComprasDServiceImpl implements ComprasDService {

	@Autowired
	private ComprasDDao _comprasDDao;

	@Override
	public List<ComprasD> getComprasDList(){
		return _comprasDDao.getComprasDList();
	}

	@Override
	public ComprasD getComprasDById(Long idComprasD) {
		// TODO Auto-generated method stub
		return _comprasDDao.getComprasDById(idComprasD);
	}

	@Override
	public ComprasD getComprasDByName(String nameComprasD) {
		// TODO Auto-generated method stub
		return _comprasDDao.getComprasDByName(nameComprasD);
	}

	@Override
	public void updateComprasD(ComprasD comprasD) {

		_comprasDDao.updateComprasD(comprasD);

	}

	@Override
	public void createComprasD(ComprasD comprasD) {

		_comprasDDao.createComprasD(comprasD);

	}

	@Override
	public void removeComprasD(Long idComprasD) {

		_comprasDDao.removeComprasD(idComprasD);

	}

}
