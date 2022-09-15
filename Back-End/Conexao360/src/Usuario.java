import java.util.Date;
public class Usuario {
	private int id;
	private String nome;
	private String rg;
	private String cpf;
	private Date dataNasc;
	private String email;
	private String senha;
	private String telefone;
	private String estado;
	private String cep;
	private String endereco;
	private String complemento;
	private boolean administrador;
	

	public int getId() {
		return id;
	}
	public void setId(int _id){
		this.id = _id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	
	public String getRG() {
		return rg;
	}
	public void setRG(String _rg) {
		this.rg = _rg;
	}
	
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String _cpf) {
		this.cpf = _cpf;
	}
	
	public Date getDataNascimento() {
		return dataNasc;
	}
	public void setDataNascimento(Date _dataNasc) {
		this.dataNasc = _dataNasc;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String _email) {
		this.email = _email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String _senha) {
		this.senha = _senha;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String _telefone) {
		this.telefone = _telefone;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String _estado) {
		this.estado = _estado;
	}
	
	public String getCEP() {
		return cep;
	}
	public void setCEP(String _cep) {
		this.cep = _cep;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String _endereco) {
		this.endereco = _endereco;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String _complemento) {
		this.complemento = _complemento;
	}
	
	public boolean getAdministrador() {
		return administrador;
	}
	public void setMasterUser(boolean _administrador) {
		this.administrador = _administrador;
	}
}