package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Usuario;

@Qualifier("UsuarioDaoCxc")
@Repository("UsuarioRepositoryCxc")
@Transactional
public class UsuarioDaoImpl extends AbstractSession implements UsuarioDao {

	@Override
	public List<Usuario> getUsuarioList(){
		return (List<Usuario>) getCxcSession().createQuery("from Usuario").list();
	}

	@Override
	public Usuario getUsuarioById(Long idUsuario) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Usuario.class, idUsuario);
	}

	@Override
	public Usuario getUsuarioByName(String nameUsuario) {
		// TODO Auto-generated method stub
		return (Usuario) getCxcSession().createQuery("from Usuario where nombre = :nameUsuario")
				.setParameter("nameUsuario", nameUsuario).uniqueResult();
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		getCxcSession().update(usuario);

	}

	@Override
	public void createUsuario(Usuario usuario) {

		getCxcSession().persist(usuario);

	}

	@Override
	public void removeUsuario(Long idUsuario) {

		Usuario usuario = getUsuarioById(idUsuario);
		if(usuario != null) {
			getCxcSession().delete(usuario);
		}

	}

}
