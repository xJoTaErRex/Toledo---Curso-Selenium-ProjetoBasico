package br.ce.wcjunior.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcjunior.core.BaseTest;
import br.ce.wcjunior.core.DriverFactory;
import br.ce.wcjunior.pages.MenuPage;
import br.ce.wcjunior.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
	
	MenuPage menu = new MenuPage();
	ResumoPage page = new ResumoPage();
	
	@Test
	public void test1_ExcluirMovimentacao() {
		menu.acessarTelaResumo();
		page.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", page.obtemMensagemSucesso());
	}

	@Test
	public void test2_ResumoMensal() {
		menu.acessarTelaResumo();
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
		
	    List<WebElement> lista = DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
	    Assert.assertEquals(0,lista.size());
	    
	}

}
