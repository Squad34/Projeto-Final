package br.com.recode.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.recode.connection.Conexao;
import br.com.recode.model.Doacao;

public class DoacaoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void CadastrarDoacao(Doacao _doacao) {
		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados
		String sql = "INSERT INTO Doacao_Equipamento(ID_Usuario, Tipo_Equipamento, Estado_Equipamento, TipoColeta, DataColeta, Equipamento_Disponivel, Equipamento_Doado, Comentario)"
				+ " VALUES(?,?,?,?,?,?,?,?)";
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, _doacao.getIdUsuario());
			pstm.setInt(2, _doacao.getTipoEquipamento());
			pstm.setInt(3, _doacao.getEstadoEquipamento());
			pstm.setBoolean(4, _doacao.getNecessitaRetirada());
			pstm.setDate(5, new Date(_doacao.getDataColeta().getTime()));
			pstm.setBoolean(6, _doacao.getEquipamentoDisponivel());
			pstm.setBoolean(7, _doacao.getEquipamentoDoado());
			pstm.setString(8, _doacao.getComentario());

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
		String sql = "DELETE FROM doacao_equipamento WHERE id = ?";
		try {
			conn = Conexao.createConnectionMySQL(); // cria a conexao
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

	public void updateDoacao(Doacao _doacao) {
		String sql = "UPDATE usuario SET ID = ?, ID_Usuario = ?, Tipo_Equipamento = ?, Estado_Equipamento = ?, TipoColeta = ?,"
				+ " DataColeta = ?, Equipamento_Disponivel = ?, Equipamento_Doado = ?, Comentario = ?"
				+ " WHERE id = ?";
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionMySQL();
			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, _doacao.getId());
			pstm.setInt(2, _doacao.getIdUsuario());
			pstm.setInt(3, _doacao.getTipoEquipamento());
			pstm.setInt(4, _doacao.getEstadoEquipamento());
			pstm.setBoolean(5, _doacao.getNecessitaRetirada());
			pstm.setDate(6, new Date(_doacao.getDataColeta().getTime()));
			pstm.setBoolean(7, _doacao.getEquipamentoDisponivel());
			pstm.setBoolean(8, _doacao.getEquipamentoDoado());
			pstm.setString(9, _doacao.getComentario());

			pstm.setInt(10, _doacao.getId());
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

	public List<Doacao> getListaDoacoes(int _id) {
		String sql = "SELECT * FROM Doacao_Equipamento\r\n" + "WHERE ID_Usuario LIKE '" + _id + "';";
		List<Doacao> doacoes = new ArrayList<Doacao>();
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Doacao _doacao = new Doacao();

				_doacao.setId(rset.getInt("ID"));
				_doacao.setIdUsuario(rset.getInt("ID_Usuario"));
				_doacao.setTipoEquipamento(rset.getInt("Tipo_Equipamento"));
				_doacao.setEstadoEquipamento(rset.getInt("Estado_Equipamento"));
				_doacao.setNecessitaRetirada(rset.getBoolean("TipoColeta"));
				_doacao.setDataColeta(rset.getDate("DataColeta"));
				_doacao.setEquipamentoDisponivel(rset.getBoolean("Equipamento_Disponivel"));
				_doacao.setEquipamentoDoado(rset.getBoolean("Equipamento_Doado"));
				_doacao.setComentario(rset.getString("Comentario"));
				doacoes.add(_doacao);
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
		return doacoes;
	}
	
	

	public Doacao getDoacaoID(int _id) {
		String sql = "SELECT * FROM Doacao_Equipamento\r\n" + "WHERE ID LIKE '" + _id + "';";
		// Classe que vai recuperar os dados do banco de dados
		Doacao _doacao = new Doacao();
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				_doacao.setId(rset.getInt("ID"));
				_doacao.setIdUsuario(rset.getInt("ID_Usuario"));
				_doacao.setTipoEquipamento(rset.getInt("Tipo_Equipamento"));
				_doacao.setEstadoEquipamento(rset.getInt("Estado_Equipamento"));
				_doacao.setNecessitaRetirada(rset.getBoolean("TipoColeta"));
				_doacao.setDataColeta(rset.getDate("DataColeta"));
				_doacao.setEquipamentoDisponivel(rset.getBoolean("Equipamento_Disponivel"));
				_doacao.setEquipamentoDoado(rset.getBoolean("Equipamento_Doado"));
				_doacao.setComentario(rset.getString("Comentario"));
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
		return _doacao;
	}
	
}