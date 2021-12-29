package br.ce.wcjunior.pages;

import br.ce.wcjunior.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirCadastro(){
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarCadastro(){
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarTelaCriarMovimentação(){
		clicarLink("Criar Movimentação");
	}
	
	
}
