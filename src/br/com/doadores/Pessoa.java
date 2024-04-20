package br.com.doadores;

public class Pessoa {
//	VARIAVEIS---------------------------------------------------------------------------------------------
	private String nome;
	private double valorDoacao;
//	CONSTRUTOR--------------------------------------------------------------------------------------------
	public Pessoa(String nome, double valorDoacao) {
		super();
		this.nome = nome;
		this.valorDoacao = valorDoacao;
	}
//	GETTERS AND SETTERS-----------------------------------------------------------------------------------
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValorDoacao() {
		return valorDoacao;
	}
	public void setValorDoacao(double valorDoacao) {
		this.valorDoacao = valorDoacao;
	}
}
