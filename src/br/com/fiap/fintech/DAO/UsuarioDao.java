package br.com.fiap.fintech.DAO;

import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Usuario;

public class UsuarioDao {

private Connection conexao;
	
	public UsuarioDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void gravar (Usuario usuario) {
		
		String sql = "INSERT INTO T_SIP_USUARIO (Id_usuario, Nome, Email, Senha, Dt_nascimento) "
				+ "VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, usuario.getId_usuario());
			ps.setNString(2, usuario.getNome());
			ps.setNString(3, usuario.getEmail());
			ps.setNString(4, usuario.getSenha());
			Date data = Date.valueOf(usuario.getDt_Nasc());
			ps.setDate(5, data);
			
			
			ps.execute();
		       ps.close();
            conexao.close();
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	 	
	}
	
	public void excluir (Usuario usuario) {
		
		String sql = "DELETE FROM T_SIP_USUARIO WHERE ID_Usuario = ( ? )";
		
			try {
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setInt(1, usuario.getId_usuario());
				
				
				ps.execute();
				ps.close();
				conexao.close();
				System.out.println("Ok");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void alterar (Usuario usuario) {
		String sql=  "UPDATE USUARIO SET T_SIP_USUARIO WHERE (ID_USUARIO, NOME, EMAIL, SENHA, DT_NASCIMENTO)" + "VALUIES (?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			ps.setInt(1, usuario.getId_usuario());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getSenha());
			Date data = Date.valueOf(usuario.getDt_Nasc());
			ps.setDate(5, data);
			
			
			ps.execute();
			ps.close();
			conexao.close();
			System.out.println("Ok");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void listarTudo (Usuario usuario) {
		
		String sql =  "SELECT * FROM T_SIP_USUARIO WHERE USUARIO Id_Usuario, Nome = (?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, usuario.getId_usuario());
			ps.setString(2, usuario.getNome());
			
			ResultSet rs = ps.executeQuery();
			Usuario u = new Usuario();
			
			if (rs.next());
			u.setId_usuario(rs.getInt("Id_usuario"));
			u.setNome(rs.getString("Nome"));
			
			ps.execute();
			ps.close();
			conexao.close();
			System.out.println("Ok");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
