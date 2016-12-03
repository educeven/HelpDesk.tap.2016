package com.tap.ucb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="tb_funcao")
public class Funcao {
	
	@Id
	private Integer idFun;
	@Column
	private String nomeFun;
	
	
	public Integer getIdFun() {
		return idFun;
	}
	public void setIdFun(Integer idFun) {
		this.idFun = idFun;
	}
	public String getNomeFun() {
		return nomeFun;
	}
	public void setNomeFun(String nomeFun) {
		this.nomeFun = nomeFun;
	}
	
	
	
	
}
