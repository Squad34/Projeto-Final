package br.com.recode.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Requisicao {

	private int id;
	private int id_Usuario;
	private int necessidade;
	private int tipoEquipamento;
	private boolean possuiEquipamento;
	private boolean divideEquipamento;
	private int rendaFamiliar;
	private boolean necessitaRetirada;
	@DateTimeFormat(iso=ISO.DATE)
	private Date dataEntrega;
	private String comentario;

	public int getId() {
		return id;
	}

	public void setId(int _id) {
		this.id = _id;
	}

	public int getIdUsuario() {
		return id_Usuario;
	}

	public void setIdUsuario(int _id_Usuario) {
		this.id_Usuario = _id_Usuario;
	}
	
	public int getNecessidade() {
		return necessidade;
	}

	public void setNecessidade(int _necessidade) {
		this.necessidade = _necessidade;
	}

	public int getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(int _tipoEquipamento) {
		this.tipoEquipamento = _tipoEquipamento;
	}

	public boolean getPossuiEquipamento() {
		return possuiEquipamento;
	}

	public void setPossuiEquipamento(boolean _possuiEquipamento) {
		this.possuiEquipamento = _possuiEquipamento;
	}

	public boolean getDivideEquipamento() {
		return divideEquipamento;
	}

	public void setDivideEquipamento(boolean _divideEquipamento) {
		this.divideEquipamento = _divideEquipamento;
	}

	public int getRendaFamiliar() {
		return rendaFamiliar;
	}

	public void setRendaFamiliar(int _rendaFamiliar) {
		this.rendaFamiliar = _rendaFamiliar;
	}
	
	public boolean getNecessitaRetirada() {
		return necessitaRetirada;
	}
	public void setNecessitaRetirada(boolean _necessitaRetirada) {
		this.necessitaRetirada = _necessitaRetirada;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date _dataEntrega) {
		this.dataEntrega = _dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String _comentario) {
		this.comentario = _comentario;
	}
}
