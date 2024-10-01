package br.com.fiap.fintech.DAO;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Conta;

public class ContaDao {
	
	private Connection conexao;
	
	public ContaDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void gravar(Conta conta) {
		
		String sql = "INSERT INTO T_SIP_CONTA (Id_conta, Tipo_ct, DataAbertura, Id_usuario, Saldo)"
		        + "VALUES (?,?,?,?,?,)";
		
		       try {
			   PreparedStatement ps = conexao.prepareStatement(sql);
			   
			   ps.setInt(1, conta.getId_conta());
		       ps.setString(2,conta.getTipo_ct());
		       Date data = Date.valueOf(conta.getDataAbertura());
		       ps.setDate(3, data);
		       ps.setInt(4, conta.getUsuario().getId_usuario());
		       ps.setDouble((int) 5, conta.getSaldo());
               
               
		       ps.execute();
		       ps.close();
               conexao.close();
               System.out.println("Ok");
               
		       } catch (SQLException e) {
				
				e.printStackTrace();
			}
    }
	
	public void excluir(Conta conta) {
		
		String sql = "DELETE FROM T_SIP_CONTA WHERE ID_CONTA = ?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, conta.getId_conta());
			
			ps.execute();
			ps.close();
			conexao.close();
			System.out.println("Ok");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar (Conta conta) {
		
		String sql = "UPDATE CONTA SET T_SIP_CONTA WHERE (ID_CONTA, TIPO_CONTA, DT_ABERTURA, ID_USUARIO, SALDO)"
		+ "VALUIES (?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
		    ps.setInt(1, conta.getId_conta());
		    ps.setString(2,conta.getTipo_ct());
		    Date data = Date.valueOf(conta.getDataAbertura());
		    ps.setDate(3, data);
		    ps.setInt(4, conta.getUsuario().getId_usuario());
		    ps.setDouble((int) 5, conta.getSaldo());
			
			ps.execute();
			ps.close();
			conexao.close();
			System.out.println("Ok");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void listarTodos(Conta conta) {
		
		String sql = "SELECT * FROM T_SIP_CONTA WHERE CONTA ID_CONTA, TIPO_CONTA = (?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, conta.getId_conta());
			ps.setString(1, conta.getTipo_ct());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}	
	