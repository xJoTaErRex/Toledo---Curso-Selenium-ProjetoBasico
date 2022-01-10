package br.ce.wcjunior.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcjunior.core.DriverFactory;
import br.ce.wcjunior.pages.LoginPage;
import br.ce.wcjunior.tests.ContaTest;
import br.ce.wcjunior.tests.ExcluirContaComMovimentacaoContaTest;
import br.ce.wcjunior.tests.MovimentacaoTest;
import br.ce.wcjunior.tests.ResumoTest;
import br.ce.wcjunior.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	ExcluirContaComMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void resetarMassaDeDados() {
		page.acessarTelaInicial();
		page.setEmail("jr13freitas@hotmail.com");
		page.setSenha("13233213");		
		page.entrar();		
		page.resetar();
		DriverFactory.killDriver();
	}
}
