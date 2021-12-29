package br.ce.wcjunior.tests;

import org.junit.Assert;
import org.junit.Test;
import br.ce.wcjunior.core.BaseTest;
import br.ce.wcjunior.pages.ContasPage;
import br.ce.wcjunior.pages.MenuPage;

public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contaPage = new ContasPage();

	@Test
	public void testInserirConta() {
		
		menuPage.acessarTelaInserirCadastro();
		contaPage.setNome("Conta de Teste 6");
		contaPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contaPage.obtemMensagemSucesso());
		
	}
	
	@Test
	public void testEditarConta() {
		
		menuPage.acessarTelaListarCadastro();
		contaPage.clicarAlterarConta("Conta de Teste 6");
		contaPage.setNome("Conta de Teste 7");
		contaPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contaPage.obtemMensagemSucesso());
		
	}
	
	@Test
	public void testInserirContaRepetida() {
		
		menuPage.acessarTelaInserirCadastro();
		contaPage.setNome("Conta de Teste 6");
		contaPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contaPage.obtemMensagemFalha());
		
	}
}
