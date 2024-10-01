package br.com.fiap.fintech.DAO;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Receita;


public class ReceitaDao {
	
private Connection conexao;
	
	public ReceitaDao(Connection conexao) {
		this.conexao = conexao;
	}

	
	public void gravar (Receita receita) {
		
		String sql = "INSERT INTO T_SIP_RECEITA (Descricao, Vl_receita, Dt_recebimento,Id_conta)"
				+ "VALUES (?,?,?,?)";
		
		
			try {
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1, receita.getDescricao());
				ps.setDouble((int)2, receita.getVl_Receita());
				Date data = Date.valueOf(receita.getDt_Recebimento());
				ps.setDate(3, data);
				ps.setInt(4, receita.getId_conta());
				
				ps.execute();
			    ps.close();
		        conexao.close();
		         
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
		}
	
	public void excluir (Receita receita) {
		
		String sql = "DELETE FROM T_SIP_RECEITA WHERE ID_CONTA = ?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, receita.getId_conta());
			
			ps.execute();
			ps.close();
			conexao.close();
			System.out.println("Ok");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterar (Receita receita ) {
		String sql =  "UPDATE RECEITA SET T_SIP_RECEITA WHERE (ID_CONTA, DESCRICAO, VL_RECEITA, DT_RECEBIMENTO)" + "VALUIES (?,?,?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1,receita.getId_conta());
			ps.setString(2, receita.getDescricao());
			ps.setDouble((int)3, receita.getVl_Receita());
			Date data = Date.valueOf(receita.getDt_Recebimento());
			ps.setDate(4, data);
			
			ps.execute();
			ps.close();
			conexao.close();
			System.out.println("Ok");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void listarTudo(Receita receita) {
		
		String sql = "SELECT * FROM T_SIP_RECEITA WHERE RECEITA Id_conta, Descricao = (?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, receita.getId_conta());
			ps.setString(2, receita.getDescricao());
			
			ResultSet rs = ps.executeQuery();
			Receita r = new Receita ();
			
			if (rs.next()) {
				r.setId_conta(rs.getInt("Id_conta"));
				r.setDescricao(rs.getString("Descricao"));
			}
			
			
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
