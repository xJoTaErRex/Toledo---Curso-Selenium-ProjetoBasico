package br.ce.wcjunior.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcjunior.core.BaseTest;
import br.ce.wcjunior.core.Propriedades;
import br.ce.wcjunior.pages.HomePage;
import br.ce.wcjunior.pages.MenuPage;

public class SaldoTest extends BaseTest {
    
    HomePage page = new HomePage();
    MenuPage pagemenu = new MenuPage();
    
	@Test
	public void testVeirifcaSaldo(){
		
		pagemenu.acessarTelaHome();
		Assert.assertEquals("7000.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA)); 
	}
	
}
