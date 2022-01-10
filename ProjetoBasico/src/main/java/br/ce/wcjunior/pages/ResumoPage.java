package br.ce.wcjunior.pages;

import org.openqa.selenium.By;

import br.ce.wcjunior.core.BasePage;

public class ResumoPage extends BasePage {
	
	public String obtemMensagemSucesso() {
		return obtemTexto(By.xpath("//div[@class ='alert alert-success']"));
	}
	
	public void excluirMovimentacao() {
		clicar(By.xpath("//span[@class = 'glyphicon glyphicon-remove-circle']"));
	}
	
	public void escolherAnoPassado() {
		
	    clicarCombo("ano", "2021");
		clicar(By.xpath("//input[@value = 'Buscar']"));
	}

}
