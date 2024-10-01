package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Transacao {

	private String Ct_destino;
	private LocalDate Dt_transacao;
	private double Vl_transacao;
	private int Id_conta;
	
	
	public String getCt_destino() {
		return Ct_destino;
	}
	public void setCt_destino(String ct_destino) {
		Ct_destino = ct_destino;
	}
	public LocalDate getDt_transacao() {
		return Dt_transacao;
	}
	public void setDt_transacao(LocalDate dt_transacao) {
		Dt_transacao = dt_transacao;
	}
	public double getVl_transacao() {
		return Vl_transacao;
	}
	public void setVl_transacao(double vl_transacao) {
		Vl_transacao = vl_transacao;
	}
	public int getId_conta() {
		return Id_conta;
	}
	public void setId_conta(int id_conta) {
		Id_conta = id_conta;
	}
}
