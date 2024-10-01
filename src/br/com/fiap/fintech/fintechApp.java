package br.com.fiap.fintech;

import java.time.LocalDate;


import br.com.fiap.fintech.DAO.Conexao;
import br.com.fiap.fintech.DAO.ContaDao;
import br.com.fiap.fintech.DAO.InvestimentoDao;
import br.com.fiap.fintech.DAO.ReceitaDao;
import br.com.fiap.fintech.DAO.TransacaoDao;
import br.com.fiap.fintech.DAO.UsuarioDao;
import br.com.fiap.fintech.model.Conta;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Transacao;
import br.com.fiap.fintech.model.Usuario;

public class fintechApp {

	public static void main(String[] args) {
		
		
		
		Conta conta = new Conta ();
		conta.setTipo_ct("Conta corrente");
		conta.setDataAbertura(LocalDate.of(2023,05,03));
		int getId_usuario = 0;
		conta.setUsuario((int) getId_usuario);
	
		
		Investimento investimento = new Investimento ();
	    investimento.setTp_invest("CDB");
		investimento.setDt_invest(LocalDate.of(2023, 9, 2));
		
	    Receita receita = new Receita();
	    receita.setDescricao("Salario");
	    receita.setDt_Recebimento(LocalDate.of(2023, 6, 25));
		
	    Transacao transacao = new Transacao();
	    transacao.setCt_destino("Conta corrente");
	    transacao.setDt_transacao(LocalDate.of(2023, 1, 17));
	    
	    Usuario usuario = new Usuario();
	    usuario.setNome("Pedro");
	    usuario.setEmail("pedro.fiap.com.br");
	    usuario.setSenha("12345");
	    
	    
		ContaDao cDao = new ContaDao(Conexao.abrirConexao());
		cDao.gravar(conta);
		
		InvestimentoDao iDao = new InvestimentoDao(Conexao.abrirConexao());
		iDao.gravar(investimento);
		
	    ReceitaDao rDao = new ReceitaDao(Conexao.abrirConexao());
	    rDao.gravar(receita);
	    
	    TransacaoDao tDao = new TransacaoDao(Conexao.abrirConexao());
	    tDao.gravar(transacao);
	    
	    UsuarioDao uDao = new UsuarioDao(Conexao.abrirConexao());
	    uDao.gravar(usuario);

	}

}
