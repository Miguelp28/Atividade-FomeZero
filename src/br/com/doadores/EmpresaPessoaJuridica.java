package br.com.doadores;

public class EmpresaPessoaJuridica extends Pessoa{
//	VARIAVEIS-------------------------------------------------------------------------
	private Long cnpj;
//	CONSTRUTOR------------------------------------------------------------------------
	public EmpresaPessoaJuridica(String nome, double valorDoacao, Long cnpj) {
		super(nome, valorDoacao);
		this.cnpj = cnpj;
	}
//	TOSTRING---------------------------------------------------------------------------
	public String toString() {
		return "Nome da empresa: "+getNome()+"\nCNPJ: "+cnpj+"\nValor total doado: R$"+getValorDoacao();
	}
//	GETTERS AND SETTERS----------------------------------------------------------------
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
}
