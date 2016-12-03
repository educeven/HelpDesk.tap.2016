package com.tap.ucb.managedbean;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import com.tap.ucb.model.Funcao;
import com.tap.ucb.util.JPAUtil;


@ManagedBean
@RequestScoped
public class FuncaoMB {

	private Integer idFun;
	private String nome;
	private Funcao funcao = new Funcao();

	public void gravar(Funcao funcao){
		
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(funcao);
		manager.getTransaction().commit();
		manager.close();
		
	}

	
	public Integer getIdFun() {
		return idFun;
	}

	public void setIdFun(Integer idFun) {
		this.idFun = idFun;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
