package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Investimento {

	private int Id_invest;
	private double Vl_invest;
	private String Tp_invest;
	private LocalDate Dt_invest;
	public int getId_invest() {
		return Id_invest;
	}
	public void setId_invest(int id_invest) {
		Id_invest = id_invest;
	}
	public double getVl_invest() {
		return Vl_invest;
	}
	public void setVl_invest(double vl_invest) {
		Vl_invest = vl_invest;
	}
	public String getTp_invest() {
		return Tp_invest;
	}
	public void setTp_invest(String tp_invest) {
		Tp_invest = tp_invest;
	}
	public LocalDate getDt_invest() {
		return Dt_invest;
	}
	public void setDt_invest(LocalDate dt_invest) {
		Dt_invest = dt_invest;
	}
	
	
}
