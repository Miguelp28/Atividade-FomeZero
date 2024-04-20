package br.com.fundação;

public class Fundacao {
//	VARIAVEIS---------------------------------------------------------------------
	private final String nomeFundacao = "Fome Zero";
	private final Long cnpj = 16741236987456L;
	private double valorArrecadado;
//	CONSTRUTUOR--------------------------------------------------------------------
	public Fundacao(){};
//	METODOS-----------------------------------------------------------------------
	public void adicionarDoacao(Long valor){
		this.valorArrecadado += valor;
	}
	public String toString() {
			return "Nome da fundação: "+getNomeFundacao()+"\nCNPJ: "+getCnpj()+"\nValor Arrecadado: R$"+getValorArrecadado();
		}
//	GETTERS AND SETTERS----------------------------------------------------------
	public double getValorArrecadado() {
		return valorArrecadado;
	}
	public void setValorArrecadado(double valorArrecadado) {
		this.valorArrecadado = valorArrecadado;
	}
	public String getNomeFundacao() {
		return nomeFundacao;
	}
	public Long getCnpj() {
		return cnpj;
	}
}
