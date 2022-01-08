package br.ce.wcjunior.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcjunior.core.BasePage;
import br.ce.wcjunior.core.DriverFactory;

public class MovimentacaoPage extends BasePage {
	
	public void setDataMovimentacao(String data) {
		escreve("data_transacao", data);
	}
	
	public void salvar() {
		clicarBotaoPorNome("Salvar");
	}
	
	public void setDataPagamento(String data) {
		escreve("data_pagamento", data);
	}
	
	public void setDescricao(String desc) {
		escreve("descricao", desc);
	}
	
	public void setInteressado(String interressado) {
		escreve("interessado", interressado);
	}
	
	public void setValor(String valor) {
		escreve("valor", valor);
	}
	
	public void setConta(String conta) {
		clicarCombo("conta", conta);
	}
	
	public void setStatusPago() {
		clicar("status_pago");
	}
	
	public String obtemMensagemSucesso() {
		return obtemTexto(By.xpath("//div[@class ='alert alert-success']"));
	}
	
	public List<String> obtemErros() {
		List<WebElement> lista = DriverFactory.getDriver().findElements(By.xpath("//div[@class ='alert alert-danger']//li"));
		List<String> erros = new ArrayList<String>();
		for(WebElement erro: lista) {
			erros.add(erro.getText());
		}
		return erros;
	}


}
