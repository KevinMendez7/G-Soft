package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.VendedorDao;
import com.scm.gsoft.domain.inv.Vendedor;

@Service("VendedorService")
@Transactional
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	private VendedorDao _vendedorDao;

	@Override
	public List<Vendedor> getVendedorList(){
		return _vendedorDao.getVendedorList();
	}

	@Override
	public Vendedor getVendedorById(Long idVendedor) {
		// TODO Auto-generated method stub
		return _vendedorDao.getVendedorById(idVendedor);
	}

	@Override
	public Vendedor getVendedorByName(String nameVendedor) {
		// TODO Auto-generated method stub
		return _vendedorDao.getVendedorByName(nameVendedor);
	}

	@Override
	public void updateVendedor(Vendedor vendedor) {

		_vendedorDao.updateVendedor(vendedor);

	}

	@Override
	public void createVendedor(Vendedor vendedor) {

		_vendedorDao.createVendedor(vendedor);

	}

	@Override
	public void removeVendedor(Long idVendedor) {

		_vendedorDao.removeVendedor(idVendedor);

	}

}
