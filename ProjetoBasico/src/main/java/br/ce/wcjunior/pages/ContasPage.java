package br.ce.wcjunior.pages;

import org.openqa.selenium.By;

import br.ce.wcjunior.core.BasePage;

public class ContasPage extends BasePage {
	
    public void setNome(String nomeinserido) {
		escreve("nome", nomeinserido);
	}
	
	public void salvar() {
		clicar(By.xpath("//button[.='Salvar']"));
	}
	
	public String obtemMensagemSucesso() {
		return obtemTexto(By.xpath("//div[@class ='alert alert-success']"));
	}
	
	public String obtemMensagemFalha() {
		return obtemTexto(By.xpath("//div[@class ='alert alert-danger']"));
	}

	public void clicarAlterarConta(String contaalterada) {
		obterCelula("Conta", contaalterada, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class = 'glyphicon glyphicon-edit']")).click();	
		
	}
	
	public void clicarExcluirConta(String contaexcluir) {
		obterCelula("Conta", contaexcluir, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class = 'glyphicon glyphicon-remove-circle']")).click();	
		
	}

}
