package br.com.doadores;

public class PessoaFisica extends Pessoa{
//	VARIAVEIS--------------------------------------------------------------------------
	private Long cpf;
//	CONSTRUTOR-------------------------------------------------------------------------	
	public PessoaFisica(String nome, double valorDoacao, Long cpf) {
		super(nome, valorDoacao);
		this.cpf = cpf;
	}
//	METODOS---------------------------------------------------------------------------
	public String toString() {
		return "Nome: "+getNome()+"\nCPF: "+cpf+"\nValor total doado: R$"+getValorDoacao();
	}
//	GETTERS AND SETTERS-----------------------------------------------------------------
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
}
