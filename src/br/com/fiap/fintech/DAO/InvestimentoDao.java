package br.com.fiap.fintech.DAO;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Investimento;

public class InvestimentoDao {
	
private Connection conexao;
	
	public InvestimentoDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void gravar (Investimento investimento) {
		
		String sql = "INSERT INTO T_SIP_INVESTIMENTO (Id_invest, Vl_invest, Tp_invest, Dt_invest)"
				+ "VALUES (sq_invest.nextval,?,?,?)";
		
		try {
		PreparedStatement pc  = conexao.prepareStatement(sql);
		
		pc.setInt(1, investimento.getId_invest());
		pc.setDouble((int)2, investimento.getVl_invest());
		pc.setString(3, investimento.getTp_invest());
		Date data = Date.valueOf(investimento.getDt_invest());
		pc.setDate(4, data);
		
	
		 pc.execute();
	       
	       pc.close();
         conexao.close();
         
	       } catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void excluir (Investimento investimento){
		
		String sql = "DELETE FROM T_SIP_INVESTIMENTO WHERE ID_Invest = ?";
		
		try {
			PreparedStatement pc = conexao.prepareStatement(sql);
			
			pc.setInt(1, investimento.getId_invest());
			
			pc.execute();
			pc.close();
			conexao.close();
			System.out.println("Ok");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void atualizar (Investimento investimento){
		
		String sql =  "UPDATE INVESTIMENTO SET T_SIP_INVESTIMENTO WHERE (Id_invest, Vl_invest, Tp_invest, Dt_invest)"
				+ "VALUES (sq_invest.nextval,?,?,?)";
		
		try {
			PreparedStatement pc = conexao.prepareStatement(sql);
			
			pc.setInt(1, investimento.getId_invest());
			pc.setDouble((int)2, investimento.getVl_invest());
			pc.setString(2, investimento.getTp_invest());
			Date data = Date.valueOf(investimento.getDt_invest());
			pc.setDate(4, data);
			
			pc.execute();
			pc.close();
			conexao.close();
			System.out.println("Ok");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void listarTudo(Investimento investimento) {
		
		String sql = "SELECT * FROM T_SIP_INVESTIMENTO WHERE INVESTIMENTO (Id_invest, Vl_invest, Tp_invest)"
				+ "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pc = conexao.prepareStatement(sql);
			
			ResultSet rs = pc.executeQuery();
			Investimento r = new Investimento();
			
			if (rs.next());{
				r.setId_invest(rs.getInt("Id_Investimento"));
				r.setVl_invest(rs.getDouble("Vl_investimneto"));
				r.setTp_invest(rs.getString("Tp_Investimneto"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


