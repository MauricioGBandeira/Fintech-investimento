package br.com.fiap.fintech.DAO;

import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Transacao;

public class TransacaoDao {
	
private Connection conexao;
	
	public TransacaoDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void gravar (Transacao transacao) {
		
		String sql = "INSERT INTO T_SIP_TRANSACAO ( Ct_destino, Dt_transacao,Vl_transacao,Id_conta)"
				+ "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, transacao.getCt_destino());
			Date data = Date.valueOf(transacao.getCt_destino());
			ps.setDate(2, data);
			ps.setDouble((int)3, transacao.getVl_transacao());
			ps.setInt(4, transacao.getId_conta());
			
			
			  ps.execute();
		       
		       ps.close();
              conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluir (Transacao transacao) {
		
		String sql = "DELETE FROM T_SIP_TRANSACAO WHERE ID_conta = ?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, transacao.getId_conta());
			
			ps.close();
			conexao.close();
			System.out.println("Ok");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void atualizar(Transacao transacao) {
		
		String sql = "UPDATE TRANSACAO SET T_SIP_TRANSACAO WHERE (CT_DESTINO, DT_TRANSACAO, VL_TRANSACAO)" + "VALUIES (?,?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1,transacao.getCt_destino());
			Date data = Date.valueOf(transacao.getDt_transacao());
			ps.setDate(2, data);
			ps.setDouble((int)3, transacao.getVl_transacao());
			
			
            ps.execute();
			ps.close();
			conexao.close();
			System.out.println("Ok");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void listarTudo(Transacao transacao) {
		
		String sql = "SELECT * FROM T_SIP_TRANSACAO WHERE TRANSACAO Id_conta, CT_destino =(?,?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, transacao.getId_conta());
			
			ResultSet rs = ps.executeQuery();
			Transacao r = new Transacao ();
			
			if (rs.next());
			r.setId_conta(rs.getInt("Id_conta"));
			r.setCt_destino(rs.getString("Ct_destino"));
			
			
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
