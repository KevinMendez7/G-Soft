package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.UsuarioVendedor;

@Repository
@Transactional
public class UsuarioVendedorDaoImpl extends AbstractSession implements UsuarioVendedorDao {

	@Override
	public List<UsuarioVendedor> getUsuarioVendedorList(){
		return (List<UsuarioVendedor>) getCxcSession().createQuery("from UsuarioVendedor").list();
	}

	@Override
	public UsuarioVendedor getUsuarioVendedorById(Long idUsuarioVendedor) {
		// TODO Auto-generated method stub
		return getCxcSession().get(UsuarioVendedor.class, idUsuarioVendedor);
	}

	@Override
	public UsuarioVendedor getUsuarioVendedorByName(String nameUsuarioVendedor) {
		// TODO Auto-generated method stub
		return (UsuarioVendedor) getCxcSession().createQuery("from UsuarioVendedor where nombre = :nameUsuarioVendedor")
				.setParameter("nameUsuarioVendedor", nameUsuarioVendedor).uniqueResult();
	}

	@Override
	public void updateUsuarioVendedor(UsuarioVendedor usuarioVendedor) {
		getCxcSession().update(usuarioVendedor);

	}

	@Override
	public void createUsuarioVendedor(UsuarioVendedor usuarioVendedor) {

		getCxcSession().persist(usuarioVendedor);

	}

	@Override
	public void removeUsuarioVendedor(Long idUsuarioVendedor) {

		UsuarioVendedor usuarioVendedor = getUsuarioVendedorById(idUsuarioVendedor);
		if(usuarioVendedor != null) {
			getCxcSession().delete(usuarioVendedor);
		}

	}

}
