import java.util.Date;

public class Doacao {

	private int id;
	private int tipoEquipamento;
	private int estadoEquipamento;
	private boolean tipoColeta;
	private Date dataColeta;
	private String CEPColeta;
	private String estadoColeta;
	private String cidadeColeta;
	private String enderecoColeta;
	private String complemento;
	private String comentario;

	public int getId() {
		return id;
	}

	public void setId(int _id) {
		this.id = _id;
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

	public boolean getTipoColeta() {
		return tipoColeta;
	}

	public void setTipoColeta(boolean _tipoColeta) {
		this.tipoColeta = _tipoColeta;
	}

	public Date getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(Date _dataColeta) {
		this.dataColeta = _dataColeta;
	}

	public String getCEPColeta() {
		return CEPColeta;
	}

	public void setCEPColeta(String _CEPColeta) {
		this.CEPColeta = _CEPColeta;
	}

	public String getEstadoColeta() {
		return estadoColeta;
	}

	public void setEstadoColeta(String _estadoColeta) {
		this.estadoColeta = _estadoColeta;
	}

	public String getCidadeColeta() {
		return cidadeColeta;
	}

	public void setCidadeColeta(String _cidadeColeta) {
		this.cidadeColeta = _cidadeColeta;
	}

	public String getEnderecoColeta() {
		return enderecoColeta;
	}

	public void setEnderecoColeta(String _enderecoColeta) {
		this.enderecoColeta = _enderecoColeta;
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
