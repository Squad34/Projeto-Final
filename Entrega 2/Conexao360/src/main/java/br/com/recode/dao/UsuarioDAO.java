package br.com.recode.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.recode.connection.Conexao;
import br.com.recode.model.Usuario;
 
public class UsuarioDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
    public void CadastrarUsuario(Usuario usuario) { 
        // Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
        // de dados   
        String sql = "INSERT INTO usuario(Nome, RG, CPF, DataNascimento, Email, Senha, Telefone, Estado, Cidade, CEP, Endereco, Complemento, Administrador)"+
        " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            // Cria uma conexão com o banco
            conn = Conexao.createConnectionMySQL();
 
            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            
            
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getRg());
            pstm.setString(3, usuario.getCpf());
            pstm.setDate(4, new Date(usuario.getDataNasc().getTime()));
            pstm.setString(5, usuario.getEmail());
            pstm.setString(6, usuario.getSenha());
            pstm.setString(7, usuario.getTelefone());
            pstm.setString(8, usuario.getEstado());
            pstm.setString(9, usuario.getCidade());
            pstm.setString(10, usuario.getCep());
            pstm.setString(11, usuario.getEndereco());
            pstm.setString(12, usuario.getComplemento());
            pstm.setBoolean(13, usuario.isAdministrador());
           
 
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
    public void updateUsuario(Usuario usuario) {
	   String sql = "UPDATE usuario SET Nome = ?, RG = ?, CPF = ?,"
	   		+ " DataNascimento = ?, Email = ?, Senha = ?, Telefone = ?, Estado = ?, Cidade = ?, CEP = ?, Endereco = ?, Complemento = ?" + " WHERE id = ?";
	   try {
	        // Cria uma conexão com o banco
	        conn = Conexao.createConnectionMySQL();
	       // Cria um PreparedStatment, classe usada para executar a query
	        pstm = conn.prepareStatement(sql);
	
	        pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getRg());
            pstm.setString(3, usuario.getCpf());
            pstm.setDate(4, new Date(usuario.getDataNasc().getTime()));
            pstm.setString(5, usuario.getEmail());
            pstm.setString(6, usuario.getSenha());
            pstm.setString(7, usuario.getTelefone());
            pstm.setString(8, usuario.getEstado());
            pstm.setString(9, usuario.getCidade());
            pstm.setString(10, usuario.getCep());
            pstm.setString(11, usuario.getEndereco());
            pstm.setString(12, usuario.getComplemento());
	
	       pstm.setInt(13, usuario.getId());
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
    public List<Usuario> getUsuario() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<Usuario>();
         ResultSet rset = null;
        try {
            conn = Conexao.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
             while (rset.next()) {
            	 Usuario usuario = new Usuario();
            	 usuario.setId(rset.getInt("ID"));
            	 usuario.setNome(rset.getString("Nome"));
            	 usuario.setRg(rset.getString("RG"));
            	 usuario.setCpf(rset.getString("CPF"));
            	 usuario.setDataNasc(rset.getDate("DataNascimento"));
            	 usuario.setEmail(rset.getString("Email"));
            	 usuario.setSenha(rset.getString("Senha"));
            	 usuario.setTelefone(rset.getString("Telefone"));
            	 usuario.setEstado(rset.getString("Estado"));
            	 usuario.setCidade(rset.getString("Cidade"));
            	 usuario.setCep(rset.getString("CEP"));
            	 usuario.setEndereco(rset.getString("Endereco"));
            	 usuario.setComplemento(rset.getString("Complemento"));
                 usuarios.add(usuario);
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
        return usuarios;
     }
    public List<Usuario> getUsuariosNome(String nome) {
        String sql = "SELECT * FROM usuario\r\n" + "WHERE Nome LIKE '%" + nome + "%';";
        List<Usuario> usuarios = new ArrayList<Usuario>();
        // Classe que vai recuperar os dados do banco de dados
         ResultSet rset = null;
        try {
            conn = Conexao.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
            	 Usuario usuario = new Usuario();
            	 usuario.setId(rset.getInt("ID"));
            	 usuario.setNome(rset.getString("Nome"));
            	 usuario.setRg(rset.getString("RG"));
            	 usuario.setCpf(rset.getString("CPF"));
            	 usuario.setDataNasc(rset.getDate("DataNascimento"));
            	 usuario.setEmail(rset.getString("Email"));
            	 usuario.setSenha(rset.getString("Senha"));
            	 usuario.setTelefone(rset.getString("Telefone"));
            	 usuario.setEstado(rset.getString("Estado"));
            	 usuario.setCidade(rset.getString("Cidade"));
            	 usuario.setCep(rset.getString("CEP"));
            	 usuario.setEndereco(rset.getString("Endereco"));
            	 usuario.setComplemento(rset.getString("Complemento"));
                 usuarios.add(usuario);
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
        return usuarios;
     }
    public Usuario getUsuarioID(int id) {
        String sql = "SELECT * FROM usuario\r\n" + "WHERE ID LIKE '" + id + "';";
        // Classe que vai recuperar os dados do banco de dados
        Usuario usuario = new Usuario();
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
            	 usuario.setId(rset.getInt("ID"));
            	 usuario.setNome(rset.getString("Nome"));
            	 usuario.setRg(rset.getString("RG"));
            	 usuario.setCpf(rset.getString("CPF"));
            	 usuario.setDataNasc(rset.getDate("DataNascimento"));
            	 usuario.setEmail(rset.getString("Email"));
            	 usuario.setSenha(rset.getString("Senha"));
            	 usuario.setTelefone(rset.getString("Telefone"));
            	 usuario.setEstado(rset.getString("Estado"));
            	 usuario.setCidade(rset.getString("Cidade"));
            	 usuario.setCep(rset.getString("CEP"));
            	 usuario.setEndereco(rset.getString("Endereco"));
            	 usuario.setComplemento(rset.getString("Complemento"));
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
        return usuario;
     }
    
    public Usuario BuscarUsuarioEmail(String _email) {
        String sql = "SELECT * FROM usuario\r\n" + "WHERE Email LIKE '" + _email + "';";
        // Classe que vai recuperar os dados do banco de dados
        Usuario usuario = new Usuario();
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
            	 System.out.println("Achou, populando");
            	 usuario.setId(rset.getInt("ID"));
            	 usuario.setNome(rset.getString("Nome"));
            	 usuario.setRg(rset.getString("RG"));
            	 usuario.setCpf(rset.getString("CPF"));
            	 usuario.setDataNasc(rset.getDate("DataNascimento"));
            	 usuario.setEmail(rset.getString("Email"));
            	 usuario.setSenha(rset.getString("Senha"));
            	 usuario.setTelefone(rset.getString("Telefone"));
            	 usuario.setEstado(rset.getString("Estado"));
            	 usuario.setCidade(rset.getString("Cidade"));
            	 usuario.setCep(rset.getString("CEP"));
            	 usuario.setEndereco(rset.getString("Endereco"));
            	 usuario.setComplemento(rset.getString("Complemento"));
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
        return usuario;
     }
    
    public Boolean VerificarEmailCadastrado(String _email) {
        String sql = "SELECT * FROM usuario\r\n" + "WHERE Email LIKE '" + _email + "';";
        // Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
            	 System.out.println("E-mail já cadastrado");
            	 return true;
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
        return false;
     }
    
    public Boolean getUsuarioCPF(String _CPF) {
        String sql = "SELECT * FROM usuario\r\n" + "WHERE CPF LIKE '" + _CPF + "';";
        // Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
            	 System.out.println("CPF já cadastrado");
            	 return true;
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
        return false;
     }
    
    public Boolean getUsuarioRG(String _RG) {
        String sql = "SELECT * FROM usuario\r\n" + "WHERE RG LIKE '" + _RG + "';";
        // Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
            	 System.out.println("RG já cadastrado");
            	 return true;
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
        return false;
     }
    public Boolean Login(String _email, String _senha) {
        String sql = "SELECT * FROM usuario\r\n" + "WHERE Email LIKE '" + _email + "' AND Senha LIKE '" + _senha + "';";
        // Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            // Enquanto existir dados no banco de dados, faça
             while (rset.next()) {
            	 System.out.println("Usuario e senha corretos");
            	 return true;
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
        return false;
     }
}