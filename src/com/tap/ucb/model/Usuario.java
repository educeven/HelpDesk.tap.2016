package com.tap.ucb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUs;
	@Column
	private String nomeUs;
	@Column
	private Integer funcaoUs;

	public Integer getIdUs() {
		return idUs;
	}

	public void setIdUs(Integer idUs) {
		this.idUs = idUs;
	}

	public String getNomeUs() {
		return nomeUs;
	}

	public void setNomeUs(String nomeUs) {
		this.nomeUs = nomeUs;
	}

	public Integer getFuncaoUs() {
		return funcaoUs;
	}

	public void setFuncaoUs(Integer funcaoUs) {
		this.funcaoUs = funcaoUs;
	}

}
