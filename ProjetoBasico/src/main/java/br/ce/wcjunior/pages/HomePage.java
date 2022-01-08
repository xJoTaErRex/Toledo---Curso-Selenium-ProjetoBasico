package br.ce.wcjunior.pages;

import br.ce.wcjunior.core.BasePage;

public class HomePage extends BasePage {
 
	public String obterSaldoConta(String conta) {
		return obterCelula("Conta", conta, "Saldo", "tabelaSaldo").getText();
	}
}
