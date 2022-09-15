import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RequisicaoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void saveRequisicao(Requisicao _requisicao) {
		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados
		String sql = "INSERT INTO requisicao(ID, ID_Usuario, Necessidade, Tipo_Equipamento, Possui_Equipamento, Divide_Equipamento, Renda_Familiar, Tipo_Entrega, DataEntrega, CEP_Entrega, Estado_Entrega, Cidade_Entrega, Endereco_Entrega, Complemento, Comentario)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, _requisicao.getId());
			pstm.setInt(2, _requisicao.getIdUsuario());
			pstm.setInt(3, _requisicao.getNecessidade());
			pstm.setInt(4, _requisicao.getTipoEquipamento());
			pstm.setBoolean(5, _requisicao.getPossuiEquipamento());
			pstm.setBoolean(6, _requisicao.getDivideEquipamento());
			pstm.setInt(7, _requisicao.getRendaFamiliar());
			pstm.setBoolean(8, _requisicao.getTipoEntrega());
			pstm.setDate(9, new Date(_requisicao.getDataEntrega().getTime()));
			pstm.setString(10, _requisicao.getCEPEntrega());
			pstm.setString(11, _requisicao.getEstadoEntrega());
			pstm.setString(12, _requisicao.getCidadeEntrega());
			pstm.setString(13, _requisicao.getEnderecoEntrega());
			pstm.setString(14, _requisicao.getComplemento());
			pstm.setString(15, _requisicao.getComentario());
			// Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try {
			conn = Conexao.createConnectionToMySQL(); // cria a conexao
			pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm
			pstm.setInt(1, id); // seta o id no comando sql
			pstm.execute(); // executa o comando sql que está no objeto pstm
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateRequisicao(Requisicao _requisicao) {
		String sql = "UPDATE usuario SET ID = ?, ID_Usuario = ?, Necessidade = ?, Tipo_Equipamento = ?, Possui_Equipamento = ?,"
				+ " Divide_Equipamento = ?, Renda_Familiar = ?, Tipo_Entrega = ?, DataEntrega = ?, CEP_Entrega = ?, Estado_Entrega = ?, Cidade_Entrega = ?, Endereco_Entrega = ?, Complemento = ?, Comentario = ?"
				+ " WHERE id = ?";
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();
			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, _requisicao.getId());
			pstm.setInt(2, _requisicao.getIdUsuario());
			pstm.setInt(3, _requisicao.getNecessidade());
			pstm.setInt(4, _requisicao.getTipoEquipamento());
			pstm.setBoolean(5, _requisicao.getPossuiEquipamento());
			pstm.setBoolean(6, _requisicao.getDivideEquipamento());
			pstm.setInt(7, _requisicao.getRendaFamiliar());
			pstm.setBoolean(8, _requisicao.getTipoEntrega());
			pstm.setDate(9, new Date(_requisicao.getDataEntrega().getTime()));
			pstm.setString(10, _requisicao.getCEPEntrega());
			pstm.setString(11, _requisicao.getEstadoEntrega());
			pstm.setString(12, _requisicao.getCidadeEntrega());
			pstm.setString(13, _requisicao.getEnderecoEntrega());
			pstm.setString(14, _requisicao.getComplemento());
			pstm.setString(15, _requisicao.getComentario());

			pstm.setInt(13, _requisicao.getId());
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Requisicao> getRequisicao() {
		String sql = "SELECT * FROM doacao";
		List<Requisicao> requisicoes = new ArrayList<Requisicao>();
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Requisicao _requisicao = new Requisicao();
				_requisicao.setId(rset.getInt("ID"));
				_requisicao.setIdUsuario(rset.getInt("ID_Usuario"));
				_requisicao.setNecessidade(rset.getInt("Necessidade"));
				_requisicao.setTipoEquipamento(rset.getInt("Tipo_Equipamento"));
				_requisicao.setPossuiEquipamento(rset.getBoolean("Possui_Equipamento"));
				_requisicao.setDivideEquipamento(rset.getBoolean("Divide_Equipamento"));
				_requisicao.setRendaFamiliar(rset.getInt("Renda_Familiar"));
				_requisicao.setTipoEntrega(rset.getBoolean("Tipo_Entrega"));
				_requisicao.setDataEntrega(rset.getDate("DataEntrega"));
				_requisicao.setCEPEntrega(rset.getString("CEP_Entrega"));
				_requisicao.setEstadoEntrega(rset.getString("Estado_Entrega"));
				_requisicao.setCidadeEntrega(rset.getString("Cidade_Entrega"));
				_requisicao.setEnderecoEntrega(rset.getString("Endereco_Entrega"));
				_requisicao.setComplemento(rset.getString("Complemento"));
				_requisicao.setComentario(rset.getString("Comentario"));
				requisicoes.add(_requisicao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return requisicoes;
	}

	public Requisicao getRequisicaoID(int id) {
		String sql = "SELECT * FROM requisicao\r\n" + "WHERE ID LIKE '" + id + "';";
		// Classe que vai recuperar os dados do banco de dados
		Requisicao _requisicao = new Requisicao();
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				_requisicao.setId(rset.getInt("ID"));
				_requisicao.setIdUsuario(rset.getInt("ID_Usuario"));
				_requisicao.setNecessidade(rset.getInt("Necessidade"));
				_requisicao.setTipoEquipamento(rset.getInt("Tipo_Equipamento"));
				_requisicao.setPossuiEquipamento(rset.getBoolean("Possui_Equipamento"));
				_requisicao.setDivideEquipamento(rset.getBoolean("Divide_Equipamento"));
				_requisicao.setRendaFamiliar(rset.getInt("Renda_Familiar"));
				_requisicao.setTipoEntrega(rset.getBoolean("Tipo_Entrega"));
				_requisicao.setDataEntrega(rset.getDate("DataEntrega"));
				_requisicao.setCEPEntrega(rset.getString("CEP_Entrega"));
				_requisicao.setEstadoEntrega(rset.getString("Estado_Entrega"));
				_requisicao.setCidadeEntrega(rset.getString("Cidade_Entrega"));
				_requisicao.setEnderecoEntrega(rset.getString("Endereco_Entrega"));
				_requisicao.setComplemento(rset.getString("Complemento"));
				_requisicao.setComentario(rset.getString("Comentario"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return _requisicao;
	}
}