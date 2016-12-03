package com.tap.ucb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tap.ucb.model.Funcao;

public class FuncaoDAO {

	// usa a entity Funcão
	
	  private EntityManager getEntityManager() {
		    EntityManagerFactory fac = null;
		    EntityManager eM = null;
		    try {
		      fac = Persistence.createEntityManagerFactory ("HelpDesk");
		      eM = fac.createEntityManager();
		    } finally {
		      fac.close();
		    }
		    return eM;
		  }
	  
	  
	  
	  // Atualizar e salvar no banco
	  
	  public Funcao salvar(Funcao funcao) throws Exception {
	    EntityManager eM = getEntityManager();
	    try {
	    	eM.getTransaction().begin();
	      System.out.println("Salvando a funcao.");
	      
	      if(funcao.getIdFun() == null) {
	    	  eM.persist(funcao);
	      } else {
	    	  funcao = eM.merge(funcao);
	      }
	      eM.getTransaction().commit();
	    } finally {
	    	eM.close();
	    }
	    return funcao;
	  }
	
	  
	  // Apagar a funcao do banco
	   
	  public void excluir(Long idFun) {
	    EntityManager eM = getEntityManager();
	    try {
	      eM.getTransaction().begin();

	      Funcao funcao = consultarPorId(idFun);
	      System.out.println("Excluindo a função: " + funcao.getNomeFun());

	      eM.remove(funcao);
	      eM.getTransaction().commit();
	    } finally {
	    	eM.close();
	    }
	  }
	  
	  
	  //Consultar a funcao do banco	
	  public Funcao consultarPorId(Long idFun) {
	    EntityManager eM = getEntityManager();
	    Funcao funcao = null;
	    try {
	    	funcao = eM.find(Funcao.class, idFun);
	    } finally {
	      eM.close();
	    }
	    return funcao;
	  }	  
	  
}
