package br.com.aplicação;

import br.com.doadores.*;
import br.com.fundação.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicação {
//	INICIALIZAÇÃO DO ARRAYLIST-----------------------------------------------------------------------------------------------------------------
	public static ArrayList<PessoaFisica> listaPF = new ArrayList<>();
	public static ArrayList<EmpresaPessoaJuridica> listaPJ = new ArrayList<>();
//	VARIAVEIS/METODOS SIMPLES------------------------------------------------------------------------------------------------------------------
	public void spaco() {System.out.println("********************************************************");};
	public void spacoVazio(){System.out.println("\n");};
	Scanner scanner = new Scanner(System.in);
	Fundacao fundacao = new Fundacao();
//	LOOP MENU PRINCIPAL-------------------------------------------------------------------------------------------------------------------------
	public void menu(){
		boolean stop = true;//stop do loop menu principal
		while(!stop == false){
			try {
				spacoVazio();
				System.out.println("Seja bem vindo ao nosso sistema de doações da fundação Fome Zero");
				System.out.print("Digite uma das opções abaixo: \n[1] Dados da fundação \n[2] Realizar doação \n[3] Historico de doação \n[4] Alterar dados cadastrais\n[5] Excluir usuario\n[6] Sair \nOpção: ");
				int opt = Integer.parseInt(scanner.nextLine());//metodo para identificar a entrada se é string ou int
				if(opt == 1){
					exibirDadosFundacao();
				}else if(opt == 2){
					realizarDoacao();
				}else if(opt == 3){
					historicoDoacao();
				}else if(opt == 4){
					editarDados();
				}else if(opt == 5){					
					excluirUsuario();
				}else if(opt == 6){					
					stop = false;
				}else{
					menuErradoGen();					
				}
			} catch (NumberFormatException e) {
				spacoVazio();
				menuErradoGen();
			}
		}
	}
//	MENUS GENERICOS-----------------------------------------------------------------------------------------------------------------------------
	public void menuErradoGen(){
		spacoVazio();
		System.out.println("Opção incorreta ou valor incorreto, pressione enter para retornar a menu principal:");
		scanner.nextLine();
	}
	public void menuErradoDinheiro(){
		spacoVazio();
		System.out.println("Opção incorreta para sua segurança esta operação foi cançelada!, pressione enter para retornar a menu principal:");
		scanner.nextLine();
	}
	public void valorErradoDinheiro(){
		spacoVazio();
		System.out.println("Valor invalido para sua segurança esta operação foi cançelada!, pressione enter para retornar a menu principal:");
		scanner.nextLine();
	}
	public void dadosNaoEncontrados(){
		spacoVazio();
		System.out.println("O documento informado não possui cadastro ou foi digitado incorretamente! pressione enter para voltar ao menu");
		scanner.nextLine();
	}
	public void agradecimento(){
		spacoVazio();
		System.out.println("Doação confirmada! A fundação Fome Zero agradece imensamente sua doação pressicone enter para voltar ao menu");
		scanner.nextLine();
	}
//	metodos-menus-------------------------------------------------------------------------------------------------------------------------------
	public void exibirDadosFundacao(){
		spacoVazio();
		spaco();
		System.out.println(fundacao.toString());
		spaco();
		System.out.println("Estes são os dados da fundação, pressione enter para retornar a menu principal:");
		scanner.nextLine();
	}
	public void realizarDoacao(){
		spacoVazio();
		System.out.print("Possui cadastro de doação?\n[1] Sim\n[2] Não\n[3] Voltar ao menu\nOpção: ");
		int opt = Integer.parseInt(scanner.nextLine());
		if(opt == 1){//----------------------------POSSUI CADASTRO!----------------------------
			spacoVazio();
			System.out.print("Possui cadastro como: \n[1] Pessoa fisica(CPF) \n[2] Pessoa Juridica(CNPJ) \n[3] Nenhum(Voltar ao menu)\nOpção: ");
			int opt2 = Integer.parseInt(scanner.nextLine());
			if(opt2 == 1){//----------------------------PESSOA FISICA!----------------------------
				spacoVazio();
				System.out.print("Informe seu CPF: ");
				long cpf = Long.parseLong(scanner.nextLine());
				PessoaFisica busca = buscaPorCpf(cpf);
				if(busca != null){
					spaco();
					System.out.println(busca);
					spaco();
					System.out.print("Estes são os seus dados! informe o valor que deseja doar: R$");///////////////////////////////////////////
					double valor = Double.parseDouble(scanner.nextLine());
					if(valor > 0 ){
						System.out.print("Digite '1' para confirmar a doação de (R$"+valor+") Ou digite '2' para cançelar a doação\nOpção: ");
						int conf = Integer.parseInt(scanner.nextLine());
						if(conf == 1){
							busca.setValorDoacao(valor + busca.getValorDoacao()); 
							fundacao.setValorArrecadado(valor + fundacao.getValorArrecadado());
							agradecimento();
						}else if(conf == 2){
							System.out.println("Doação cançelada! pressione enter para voltar ao menu");
							scanner.nextLine();
						}else {
							menuErradoGen();
						}
					}else{
						valorErradoDinheiro();
					}
				}else{
					dadosNaoEncontrados();
				}
			}else if(opt2 == 2){//----------------------------PESSOA JURIDICA!----------------------------
				spacoVazio();
				System.out.print("Informe seu CNPJ: ");
				long cnpj = Long.parseLong(scanner.nextLine());
				EmpresaPessoaJuridica busca = buscaPorCnpj(cnpj);
				if(busca != null){
					spaco();
					System.out.println(busca);
					spaco();
					System.out.print("Estes são os seus dados! informe o valor que deseja doar: R$");///////////////////////////////////////////
					double valor = Double.parseDouble(scanner.nextLine());
					if(valor > 0 ){
						System.out.print("Digite '1' para confirmar a doação de (R$"+valor+") Ou digite '2' para cançelar a doação\nOpção: ");
						int conf = Integer.parseInt(scanner.nextLine());
						if(conf == 1){
							busca.setValorDoacao(valor + busca.getValorDoacao()); 
							fundacao.setValorArrecadado(valor + fundacao.getValorArrecadado());
							agradecimento();
						}else if(conf == 2){
							System.out.println("Doação cançelada! pressione enter para voltar ao menu");
							scanner.nextLine();
						}else {
							menuErradoGen();
						}
					}else{
						valorErradoDinheiro();
					}
				}else{
					dadosNaoEncontrados();
				}
			}else if(opt2 == 3){
				//volta para o menu
			}else{
				menuErradoGen();
			}
		}else if(opt == 2){//----------------------------NÃO POSSUI CADASTRO!----------------------------
			spacoVazio();
			System.out.print("Deseja realizar o cadastro como:\n[1] Pessoa Fisica (CPF)\n[2] Pessoa juridica(CNPJ)\nOpção: ");
			int opt1 = Integer.parseInt(scanner.nextLine());
			if(opt1 == 1){//-----------------------------CADASTRAR PESSOA CPF----------------------------
				System.out.print("Iremos pedir alguns dados como nome e CPF para cadastro. Documentos como CPF não serão publicos, estando ciente de nossas politicas você aceita nosso termos de uso?"
						+ "\n[1] Sim concordo \n[2] Não concordo \nOpção: ");
				int termos = Integer.parseInt(scanner.nextLine());
				if(termos == 1){
					spacoVazio();
					System.out.print("Qual seria seu primeiro nome: ");
					String nome = scanner.nextLine();
					System.out.print("Qual seria seu CPF: ");
					long cpf = Long.parseLong(scanner.nextLine());
					if(buscaPorCpf(cpf) == null){
						spacoVazio();
						listaPF.add(new PessoaFisica(nome, 0, cpf));
						System.out.println("Cadastro completo agora no menu principal agora é possivel realizar uma doação a partir do seu CPF! Precione enter para voltar ao menu");
						System.out.println(cpf);
						scanner.nextLine();
					}else if(buscaPorCpf(cpf) != null){
						spacoVazio();
						System.out.println("Este CPF já possui cadastro, basta digitar ele quando solicitado que podera realizar a doação!  Precione enter para voltar ao menu");
						scanner.nextLine();
					}
				}else if(termos == 2){
					spacoVazio();
					System.out.println("Não podemos prosseguir com seu cadastro sem nossos termos aceitos! Pressione enter para voltar ao menu");
					scanner.nextLine();
				}else{
					menuErradoGen();
				}
			}else if(opt1 == 2){//-----------------------------CADASTRAR PESSOA JURIDICA CNPJ----------------------------
				spacoVazio();
				System.out.print("Iremos pedir alguns dados como nome e CNPJ para cadastro. Estando ciente de nossas politicas você aceita nosso termos de uso?"
						+ "\n[1] Sim concordo \n[2] Não concordo \nOpção: ");
				int termos = Integer.parseInt(scanner.nextLine());
				if(termos == 1){
					spacoVazio();
					System.out.print("Qual seria o nome da Empresa: ");
					String nome = scanner.nextLine();
					System.out.print("Qual seria seu CNPJ: ");
					long cnpj = Long.parseLong(scanner.nextLine());
					if(buscaPorCnpj(cnpj) == null){
						spacoVazio();
						listaPJ.add(new EmpresaPessoaJuridica(nome, 0, cnpj));
						System.out.println("Cadastro completo agora no menu principal agora é possivel realizar uma doação a partir do seu CNPJ! Precione enter para voltar ao menu");
						scanner.nextLine();
					}else if(buscaPorCnpj(cnpj) != null){
						spacoVazio();
						System.out.println("Este CNPJ já possui cadastro, basta digitar ele quando solicitado que podera realizar a doação!  Precione enter para voltar ao menu");
						scanner.nextLine();
					}
				}else if(termos == 2){
					spacoVazio();
					System.out.println("Não podemos prosseguir com seu cadastro sem nossos termos aceitos! Pressione enter para voltar ao menu");
					scanner.nextLine();
				}else{
					menuErradoGen();
				}
			}else{
				menuErradoGen();
			}
		}else if(opt == 3){//-----------------------------VOLTAR AO MENU----------------------------
			//VOLTA AO MENU
		}else{
			menuErradoGen();
		}
	}
	public void historicoDoacao(){
		spacoVazio();
		System.out.println("Deseja ver o histotorico de doação de: \n[1] Pessoas \n[2] Empresas \n[3] Voltar ao menu");
		int opt1 = Integer.parseInt(scanner.nextLine());
		if(opt1 == 1 && listaPF.size() > 0){//----------------PESSOA---------------------
			historicoPessoaFisica();
			System.out.println("Estas foram as pessoas que ajudaram a varias famílias a se alimentarem e terem uma condição de vida melhor! a fundação Fome Zero agradece a todos por tornarem o mundo um puco melhor");
			System.out.println("Precione enter para voltar ao menu!");
			scanner.nextLine();
		}else if(opt1 == 2 && listaPJ.size() > 0){//-------------------EMPRESA--------------------
			historicoPessoaJuridica();
			System.out.println("Estas foram as empresas que ajudaram a varias famílias a se alimentarem e terem uma condição de vida melhor! a fundação Fome Zero agradece a todos por tornarem o mundo um puco melhor");
			System.out.println("Precione enter para voltar ao menu!");
			scanner.nextLine();
		}else if(opt1 == 3){//-----------------VOLTAR MENU------------------
			//VARIO PARA VOLTAR AO MENU DIRETO
		}else if(listaPF.size() <= 0 || listaPJ.size() <=0){// CASO UMA DAS LISTAS VAZIAS
			System.out.println("No momento não há doaçoes, mas seja um dos primeiros a realizar doações e ajudar familhas em condições precarias no brasil, precione enter para voltar ao menu!");
			scanner.nextLine();
		}else{			
			menuErradoGen();
		}
	}
	public void editarDados(){
		spacoVazio();
		System.out.println("Nos só podemos alterar o nome/nome da empresa, caso for necessario mudar CPF/CNPJ entre em contato com o suporte!");
		System.out.println("Estando ciente que só é possivel alterar o nome o deseja fazer:\n[1] Pessoa Fisica \n[2] Pessoa Juridica \n[3] Voltar ao menu\nOpção: ");
		int opt1 = Integer.parseInt(scanner.nextLine());
		if(opt1 == 1){//------------------PESSOA FISICA----------------------------
			spacoVazio();
			System.out.println("Qual o seu CPF: ");
			long cpf = Long.parseLong(scanner.nextLine());
			if(buscaPorCpf(cpf) != null){
				spacoVazio();
				System.out.println("Qua seria o novo nome da conta: ");
				String nomeNovo = scanner.nextLine();
				System.out.println("Realemente deseja alterar o nome antigo: "+buscaPorCpf(cpf).getNome()+", para o nome novo: "+nomeNovo+"?\n[1] Sim quero alterar o nome\n[2] Não quero alterar o nome");
				int conf = Integer.parseInt(scanner.nextLine());
				if(conf == 1){
					spacoVazio();
					buscaPorCpf(cpf).setNome(nomeNovo);
					System.out.println("Alteração feita com sucesso! precione enter para voltar ao menu");
					scanner.nextLine();
				}else if(conf == 2){
					spacoVazio();
					System.out.println("Alteração cançelada com sucesso! precione enter para voltar ao menu");
					scanner.nextLine();
				}else{
					menuErradoGen();
				}
			}else if(buscaPorCpf(cpf) == null){
				dadosNaoEncontrados();
			}else{
				menuErradoGen();
			}
		}else if(opt1 == 2){//----------------PESSOA JURIDICA----------------------------
			spacoVazio();
			System.out.println("Qual o seu CNPJ: ");
			long cnpj = Long.parseLong(scanner.nextLine());
			if(buscaPorCnpj(cnpj) != null){
				spacoVazio();
				System.out.println("Qua seria o novo nome da empresa: ");
				String nomeNovo = scanner.nextLine();
				System.out.println("Realemente deseja alterar o nome antigo: "+buscaPorCnpj(cnpj).getNome()+", para o nome novo: "+nomeNovo+"?\n[1] Sim quero alterar o nome\n[2] Não quero alterar o nome");
				int conf = Integer.parseInt(scanner.nextLine());
				if(conf == 1){
					spacoVazio();
					buscaPorCnpj(cnpj).setNome(nomeNovo);
					System.out.println("Alteração feita com sucesso! precione enter para voltar ao menu");
					scanner.nextLine();
				}else if(conf == 2){
					spacoVazio();
					System.out.println("Alteração cançelada com sucesso! precione enter para voltar ao menu");
					scanner.nextLine();
				}else{
					menuErradoGen();
				}
			}else if(buscaPorCnpj(cnpj) == null){
				dadosNaoEncontrados();
			}else{
				menuErradoGen();
			}
		}else if(opt1 == 3){//----------------------------VOLTAR AO MENU----------------------------
			spacoVazio();
		}else{
			menuErradoGen();
		}
	}
	public void excluirUsuario(){
		spacoVazio();
		System.out.println("Qual seu tipo de conta: \n[1] Pessoa fisica(CPF) \n[2] Pessoa juridica(CNPJ) \n[3] Voltar ao menu");
		int opt1 = Integer.parseInt(scanner.nextLine());
		if(opt1 == 1){//-----------------------------PESSOA FISICA------------------------------------------
			spacoVazio();
			System.out.println("Qual seu CPF: ");
			long cpf = Long.parseLong(scanner.nextLine());
			if(buscaPorCpf(cpf) != null){
				spacoVazio();
				System.out.println("Confirme que deseja excluir sua conta com os seguintes dados:");
				spaco();
				System.out.println(buscaPorCpf(cpf).toString());
				spaco();
				System.out.print("[1] Confimo, quero excluir o usuario \n[2] Não quero apagar o usuario \nOpção: ");
				int conf = Integer.parseInt(scanner.nextLine());
				if(conf == 1){
					spacoVazio();
					listaPF.remove(buscaPorCpf(cpf));
					System.out.println("Usuario removido! precione enter para voltar ao menu:");
					scanner.nextLine();
				}else if(conf == 2){
					spacoVazio();
					System.out.println("Exclusão cançelada precione enter para voltar ao menu:");
					scanner.nextLine();
				}else{
					spacoVazio();
					menuErradoDinheiro();
				}
			}else{
				spacoVazio();
				dadosNaoEncontrados();
			}
		}else if(opt1 == 2){//-----------------------------PESSOA JURIDICA----------------------------------
			spacoVazio();
			System.out.println("Qual seu CNPJ: ");
			long cnpj = Long.parseLong(scanner.nextLine());
			if(buscaPorCnpj(cnpj) != null){
				spacoVazio();
				System.out.println("Confirme que deseja excluir sua conta com os seguintes dados:");
				spaco();
				System.out.println(buscaPorCnpj(cnpj).toString());
				spaco();
				System.out.print("[1] Confimo, quero excluir o usuario \n[2] Não quero apagar o usuario \nOpção: ");
				int conf = Integer.parseInt(scanner.nextLine());
				if(conf == 1){
					spacoVazio();
					listaPJ.remove(buscaPorCnpj(cnpj));
					System.out.println("Usuario removido! precione enter para voltar ao menu:");
					scanner.nextLine();
				}else if(conf == 2){
					spacoVazio();
					System.out.println("Exclusão cançelada precione enter para voltar ao menu:");
					scanner.nextLine();
				}else{
					spacoVazio();
					menuErradoDinheiro();
				}
			}else{
				spacoVazio();
				dadosNaoEncontrados();
			}
		}else if(opt1 == 3){//-----------------------------VOLTAR AO MENU-----------------------------------
			//VOLTARA PARA O MENU AUTOMATICAMENTE
		}else{//-------------------------------------------OPÇÃO INVALIDA-----------------------------------
			menuErradoGen();
		}
	}
//	METODOS DE BUSCA----------------------------------------------------------------------------------------------------------------------------
	public PessoaFisica buscaPorCpf(long cpf){// BUSCAR NA LISTA A PARTIR DO CPF
		for (PessoaFisica lista : listaPF) {
			if(lista.getCpf() == cpf){
				return lista;
			}
		}
		return null;
	}
	public EmpresaPessoaJuridica buscaPorCnpj(long cnpjBusca){// BUSCAR NA LISTA A PARTIR DO CNPJ
		for (EmpresaPessoaJuridica lista : listaPJ) {
			if(lista.getCnpj() == cnpjBusca){
				return lista;
			}
		}
		return null;
	}
	public void historicoPessoaFisica(){// BUSCAR NA LISTA TODOS OS DADOS EXCETO CPF DA LISTA PF
		for (PessoaFisica pF : listaPF) {
			if(pF.getValorDoacao() > 0){
				spaco();
				System.out.println("Nome: "+pF.getNome()+"\nValor doado: R$"+pF.getValorDoacao());
				spaco();
			}
		}
	}
	public void historicoPessoaJuridica(){// BUSCAR NA LISTA TODOS OS DADOS DA LISTA PJ
		for (EmpresaPessoaJuridica pJ : listaPJ) {
			if(pJ.getValorDoacao() > 0){
				spaco();
				System.out.println("Nome da Empresa: "+pJ.getNome()+"\nCNPJ: "+pJ.getCnpj()+"\nValor doado: R$"+pJ.getValorDoacao());
				spaco();
			}
		}
	}
}//FINAL----------------------------------------------------------------------------------------------------------------------------------------
