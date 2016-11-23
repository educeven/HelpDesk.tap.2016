package com.tap.ucb.managedbean;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import com.tap.ucb.model.Funcao;
import com.tap.ucb.util.JPAUtil;


@ManagedBean
@RequestScoped
public class FuncaoMB {

	private Funcao funcao = new Funcao();

	public void gravar(Funcao funcao){
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(funcao);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	
	
}
