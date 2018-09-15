package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Usuario;

public interface UsuarioService {

	List<Usuario> getUsuarioList();

	Usuario getUsuarioById(Long idUsuario);

	Usuario getUsuarioByName(String nameUsuario);

	void updateUsuario(Usuario usuario);

	void createUsuario(Usuario usuario);

	void removeUsuario(Long idUsuario);

}
