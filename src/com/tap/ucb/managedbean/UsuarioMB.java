package com.tap.ucb.managedbean;


import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import com.tap.ucb.model.Usuario;
import com.tap.ucb.util.JPAUtil;


@ManagedBean
@RequestScoped
public class UsuarioMB {

	private Usuario usuario = new Usuario();

	public void gravar(Usuario usuario){
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
		
	
}
