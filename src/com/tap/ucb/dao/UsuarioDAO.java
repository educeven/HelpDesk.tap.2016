package com.tap.ucb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tap.ucb.model.Usuario;

public class UsuarioDAO {

	// usa a entity Usuario
	
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
	  
	  public Usuario salvar(Usuario usuario) throws Exception {
	    EntityManager eM = getEntityManager();
	    try {
	    	eM.getTransaction().begin();
	      System.out.println("Salvando o Usuário.");
	      
	      if(usuario.getIdUs() == null) {
	    	  eM.persist(usuario);
	      } else {
	    	  usuario = eM.merge(usuario);
	      }
	      eM.getTransaction().commit();
	    } finally {
	    	eM.close();
	    }
	    return usuario;
	  }
	
	  
	  // Apagar a funcao do banco
	   
	  public void excluir(Long idUs) {
	    EntityManager eM = getEntityManager();
	    try {
	      eM.getTransaction().begin();

	      Usuario usuario = consultarPorId(idUs);
	      System.out.println("Excluindo o usuário: " + usuario.getNomeUs());

	      eM.remove(usuario);
	      eM.getTransaction().commit();
	    } finally {
	    	eM.close();
	    }
	  }
	  

	//Consultar a funcao do banco	
	  public Usuario consultarPorId(Long idUs) {
	    EntityManager eM = getEntityManager();
	    Usuario funcao = null;
	    try {
	    	funcao = eM.find(Usuario.class, idUs);
	    } finally {
	      eM.close();
	    }
	    return funcao;
	  }	
	
}
