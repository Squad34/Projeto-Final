package br.com.recode.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Doacao {

	private int id;
	private int id_Usuario;
	private int tipoEquipamento;
	private int estadoEquipamento;
	private boolean necessitaRetirada;
	@DateTimeFormat(iso=ISO.DATE)
	private Date dataColeta;
	private boolean equipamentoDisponivel;
	private boolean equipamentoDoado;
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
	
	public int getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(int _tipoEquipamento) {
		this.tipoEquipamento = _tipoEquipamento;
	}

	public int getEstadoEquipamento() {
		return estadoEquipamento;
	}

	public void setEstadoEquipamento(int _estadoEquipamento) {
		this.estadoEquipamento = _estadoEquipamento;
	}

	public boolean getNecessitaRetirada() {
		return necessitaRetirada;
	}

	public void setNecessitaRetirada(boolean _necessitaRetirada) {
		this.necessitaRetirada = _necessitaRetirada;
	}

	public Date getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(Date _dataColeta) {
		this.dataColeta = _dataColeta;
	}

	public boolean getEquipamentoDisponivel() {
		return equipamentoDisponivel;
	}

	public void setEquipamentoDisponivel(boolean _equipamentoDisponivel) {
		this.equipamentoDisponivel = _equipamentoDisponivel;
	}
	
	public boolean getEquipamentoDoado() {
		return equipamentoDoado;
	}

	public void setEquipamentoDoado(boolean _equipamentoDoado) {
		this.equipamentoDoado = _equipamentoDoado;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String _comentario) {
		this.comentario = _comentario;
	}
}
