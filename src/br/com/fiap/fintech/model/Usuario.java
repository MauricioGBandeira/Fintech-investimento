package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Usuario {

	private int Id_usuario;
	private String Nome;
	private String Email;
	private String senha;
	private LocalDate Dt_Nasc;
	
	public int getId_usuario() {
		return Id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		Id_usuario = id_usuario;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public LocalDate getDt_Nasc() {
		return Dt_Nasc;
	}
	public void setDt_Nasc(LocalDate dt_Nasc) {
		Dt_Nasc = dt_Nasc;
	}
	
	
	
}
