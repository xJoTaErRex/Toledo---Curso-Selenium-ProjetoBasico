package br.ce.wcjunior.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcjunior.core.BaseTest;
import br.ce.wcjunior.core.Propriedades;
import br.ce.wcjunior.pages.ContasPage;
import br.ce.wcjunior.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contaPage = new ContasPage();

	@Test
	public void test1_InserirConta() {
		
		menuPage.acessarTelaInserirCadastro();
		contaPage.setNome("Conta de Teste 6");
		contaPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contaPage.obtemMensagemSucesso());
		
	}
	
	@Test
	public void test2_EditarConta() {
		
		menuPage.acessarTelaListarCadastro();
		contaPage.clicarAlterarConta("Conta de Teste 6");
		contaPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contaPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contaPage.obtemMensagemSucesso());
		
	}
	
	@Test
	public void test3_InserirContaRepetida() {
		
		menuPage.acessarTelaInserirCadastro();
		contaPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contaPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contaPage.obtemMensagemFalha());
		
	}
	

}
