package br.ce.wcjunior.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcjunior.core.BaseTest;
import br.ce.wcjunior.core.Propriedades;
import br.ce.wcjunior.pages.ContasPage;
import br.ce.wcjunior.pages.MenuPage;

public class ExcluirContaComMovimentacaoContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contaPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		
		menuPage.acessarTelaListarCadastro();
		contaPage.clicarExcluirConta("Conta com movimentacao");
		Assert.assertEquals("Conta em uso na movimentações", contaPage.obtemMensagemFalha());	
	}
}
