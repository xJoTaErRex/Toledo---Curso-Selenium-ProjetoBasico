package br.ce.wcjunior.pages;

import org.openqa.selenium.By;

import br.ce.wcjunior.core.BasePage;
import br.ce.wcjunior.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	
	public void setEmail(String email) {
		escreve("email",email);
	}
	
	public void setSenha(String senha) {
		escreve("senha",senha);
	}
	
	public void entrar() {
		clicar(By.xpath("//button[.= 'Entrar']"));
	}
	
}
