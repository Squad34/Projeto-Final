import java.util.Date;

public class Requisicao {
	
	private int id;
	private int necessidade;
	private int tipoEquipamento;
	private boolean possuiEquipamento;
	private boolean divideEquipamento;
	private boolean rendaFamiliar;
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
	public void setId(int _id){
		this.id = _id;
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
	public void setTipoEquipamentoe(int _tipoEquipamento) {
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
	public boolean getRendaFamiliar() {
		return rendaFamiliar;
	}
	public void setRendaFamiliar(boolean _rendaFamiliar) {
		this.rendaFamiliar = _rendaFamiliar;
	}
	public Date getDataEntregar() {
		return dataEntrega;
	}
	public void setDataEntregar(Date _dataEntrega) {
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
	public String geComentario() {
		return comentario;
	}
	public void setComentario(String _comentario) {
		this.comentario = _comentario;
	}
}
