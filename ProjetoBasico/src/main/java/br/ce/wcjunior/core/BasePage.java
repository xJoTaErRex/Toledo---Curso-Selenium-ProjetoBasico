package br.ce.wcjunior.core;

import static br.ce.wcjunior.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

     ////-----------------Escreve-----------------------
	public void escreve(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	public void escreve(String id, String texto) {
		escreve(By.id(id), texto);
	}
	
	//-------------Obtem Valor---------------------------
	public String obtemValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	//-------------Obtem Texto---------------------------
	
	public String obtemTexto(By by) {
		return getDriver().findElement(by).getText();
	}	
	
	public String obtemTexto(String id) {
		return getDriver().findElement(By.id(id)).getText();
	}
	
	
    ////-----------------Clica-----------------------
	public void clicar(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	
    ////-----------------Combo-----------------------
	public void clicarCombo(String id, String valor) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}
	
	public void selecionarComboPrime(String radical, String valor) {
		clicar(By.xpath("//*[@id = '"+ radical +"_input']//..//..//span"));
		clicar(By.xpath("//*[@id = '"+ radical +"_items']//li[.='"+ valor +"']"));
	}
	
	
    ////-----------------Radio-----------------------
	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
    ////-----------------Frames e Janelas-----------------------
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
	public void sairFrame() {
		getDriver().switchTo().defaultContent();
	}
	
	
    ////-----------------Alerta-----------------------
	public String alertaObtemTextoeAceita() {
		Alert alerta = getDriver().switchTo().alert();
		String texto = alerta.getText();
		alerta.accept();
		return texto;
	}
	
	
    ////-----------------JavaScript-----------------------
	public Object executaJavaScript(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
		return js.executeScript(cmd,param);
	}
	
    ////-----------------Tabelas -----------------------
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+ idTabela +"']"));
		//procurar coluna de registro 
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha de registro
		int idLinha = obtemIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botão
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada 
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		
		celula.findElement(By.xpath(".//input")).click();
	}

	private int obtemIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" +idColuna+ "]"));	
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	private int obterIndiceColuna(String colunaBusca, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));	
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(colunaBusca)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
}
