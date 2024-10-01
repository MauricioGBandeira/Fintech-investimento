package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Conta {

	private int Id_conta;
	private String Tipo_ct;
 	private LocalDate dataAbertura;
	private int Id_Usuario;
	private double Saldo;
	private Usuario usuario;
	private Receita receita;
	private Investimento investimento;
	
	public int getId_conta() {
		return Id_conta;
	}
	public void setId_conta(int id_conta) {
		Id_conta = id_conta;
	}
	public String getTipo_ct() {
		return Tipo_ct;
	}
	public void setTipo_ct(String tipo_ct) {
		Tipo_ct = tipo_ct;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public int getId_Usuario() {
		return Id_Usuario;
	}
	
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	public Investimento getInvestimento() {
		return investimento;
	}
	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
	public void setUsuario(int getId_usuario) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
