import java.util.Date;

public class Requisicao {

	private int id;
	private int id_Usuario;
	private int necessidade;
	private int tipoEquipamento;
	private boolean possuiEquipamento;
	private boolean divideEquipamento;
	private int rendaFamiliar;
	private boolean tipoEntrega;
	private Date dataEntrega;
	private String CEPEntrega;
	private String estadoEntrega;
	private String cidadeEntrega;
	private String enderecoEntrega;
	private String complemento;
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

	public boolean getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(boolean _tipoEntrega) {
		this.tipoEntrega = _tipoEntrega;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date _dataEntrega) {
		this.dataEntrega = _dataEntrega;
	}

	public String getCEPEntrega() {
		return CEPEntrega;
	}

	public void setCEPEntrega(String _CEPEntrega) {
		this.CEPEntrega = _CEPEntrega;
	}

	public String getEstadoEntrega() {
		return estadoEntrega;
	}

	public void setEstadoEntrega(String _estadoEntrega) {
		this.estadoEntrega = _estadoEntrega;
	}

	public String getCidadeEntrega() {
		return cidadeEntrega;
	}

	public void setCidadeEntrega(String _cidadeEntrega) {
		this.cidadeEntrega = _cidadeEntrega;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String _enderecoEntrega) {
		this.enderecoEntrega = _enderecoEntrega;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String _complemento) {
		this.complemento = _complemento;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String _comentario) {
		this.comentario = _comentario;
	}
}
