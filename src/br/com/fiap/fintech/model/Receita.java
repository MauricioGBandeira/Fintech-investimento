package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Receita {

	private String Descricao;
	private double Vl_Receita;
	private LocalDate Dt_Recebimento;
	private int Id_conta;
	private Transacao transacao;
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public double getVl_Receita() {
		return Vl_Receita;
	}
	public void setVl_Receita(double vl_Receita) {
		Vl_Receita = vl_Receita;
	}
	public LocalDate getDt_Recebimento() {
		return Dt_Recebimento;
	}
	public void setDt_Recebimento(LocalDate dt_Recebimento) {
		Dt_Recebimento = dt_Recebimento;
	}
	public int getId_conta() {
		return Id_conta;
	}
	public void setId_conta(int id_conta) {
		Id_conta = id_conta;
	}
	public Transacao getTransacao() {
		return transacao;
	}
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	
	
	
	
	
}
