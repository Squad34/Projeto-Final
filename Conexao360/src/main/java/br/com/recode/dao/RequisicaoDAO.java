package br.com.recode.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.recode.connection.Conexao;
import br.com.recode.model.Requisicao;


public class RequisicaoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void CadastrarRequisicao(Requisicao _requisicao) {
		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados
		String sql = "INSERT INTO requisicao_equipamento(ID_Usuario, Necessidade, Tipo_Equipamento, Possui_Equipamento, Divide_Equipamento, Renda_Familiar, Tipo_Entrega, DataEntrega, Comentario)"+
	        " VALUES(?,?,?,?,?,?,?,?,?)";
	        try {
	            // Cria uma conexão com o banco
	            conn = Conexao.createConnectionMySQL();
	 
	            // Cria um PreparedStatment, classe usada para executar a query
	            pstm = conn.prepareStatement(sql);
	 
	            pstm.setInt(1, _requisicao.getIdUsuario());
	            pstm.setInt(2, _requisicao.getNecessidade());
	            pstm.setInt(3, _requisicao.getTipoEquipamento());
	            pstm.setBoolean(4, _requisicao.getPossuiEquipamento());
	            pstm.setBoolean(5, _requisicao.getDivideEquipamento());
	            pstm.setDouble(6, _requisicao.getRendaFamiliar());
	            pstm.setBoolean(7, _requisicao.getNecessitaRetirada());
	            pstm.setDate(8, new Date(_requisicao.getDataEntrega().getTime()));
	            pstm.setString(9, _requisicao.getComentario());
	           
	 
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
		String sql = "DELETE FROM requisicao_equipamento WHERE id = ?";
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

	public void updateRequisicao(Requisicao _requisicao) {
		String sql = "UPDATE usuario SET ID = ?, ID_Usuario = ?, Necessidade = ?, Tipo_Equipamento = ?, Possui_Equipamento = ?,"
				+ " Divide_Equipamento = ?, Renda_Familiar = ?, Tipo_Entrega = ?, DataEntrega = ?, Comentario = ?"
				+ " WHERE id = ?";
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionMySQL();
			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, _requisicao.getId());
			pstm.setInt(2, _requisicao.getIdUsuario());
			pstm.setInt(3, _requisicao.getNecessidade());
			pstm.setInt(4, _requisicao.getTipoEquipamento());
			pstm.setBoolean(5, _requisicao.getPossuiEquipamento());
			pstm.setBoolean(6, _requisicao.getDivideEquipamento());
			pstm.setInt(7, _requisicao.getRendaFamiliar());
			pstm.setBoolean(8, _requisicao.getNecessitaRetirada());
			pstm.setDate(9, new Date(_requisicao.getDataEntrega().getTime()));
			pstm.setString(10, _requisicao.getComentario());

			pstm.setInt(11, _requisicao.getId());
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

	public List<Requisicao> getRequisicao(int _id) {
		String sql = "SELECT * FROM requisicao_equipamento\r\n" + "WHERE ID_Usuario LIKE '" + _id + "';";
		List<Requisicao> requisicoes = new ArrayList<Requisicao>();
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionMySQL();
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
				_requisicao.setNecessitaRetirada(rset.getBoolean("Tipo_Entrega"));
				_requisicao.setDataEntrega(rset.getDate("DataEntrega"));
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
			conn = Conexao.createConnectionMySQL();
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
				_requisicao.setNecessitaRetirada(rset.getBoolean("Tipo_Entrega"));
				_requisicao.setDataEntrega(rset.getDate("DataEntrega"));
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