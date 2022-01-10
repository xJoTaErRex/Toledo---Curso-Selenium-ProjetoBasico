package br.ce.wcjunior.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcjunior.core.BaseTest;
import br.ce.wcjunior.core.Propriedades;
import br.ce.wcjunior.pages.MenuPage;
import br.ce.wcjunior.pages.MovimentacaoPage;
import br.ce.wcjunior.utils.DataUtils;

public class MovimentacaoTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
     
	@Test
	public void test1_InserirMoviemntacao() {
		
		menuPage.acessarTelaCriarMovimenta��o();
		movimentacaoPage.setDataMovimentacao(DataUtils.obtemDataformatada(new Date()));
		movimentacaoPage.setDataPagamento(DataUtils.obtemDataformatada(new Date()));
		movimentacaoPage.setDescricao("Testando");
		movimentacaoPage.setInteressado("Qualquer");
		movimentacaoPage.setValor("7000.00");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setStatusPago();
		movimentacaoPage.salvar();
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movimentacaoPage.obtemMensagemSucesso());
		
	}
	
	@Test
	public void test2_Validacoes() {		
		menuPage.acessarTelaCriarMovimenta��o();
		movimentacaoPage.salvar();
		List<String> erros = movimentacaoPage.obtemErros();
		//Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
		//Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio","Descri��o � obrigat�rio","Interessado � obrigat�rio",
				"Valor � obrigat�rio","Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
		
	}
	
	@Test
	public void test3_InserirMoviemntacaoFutura() {
		
		menuPage.acessarTelaCriarMovimenta��o();
		movimentacaoPage.setDataMovimentacao(DataUtils.obtemDataFormatadaComDiferencaDeDias(3));
		movimentacaoPage.setDataPagamento(DataUtils.obtemDataFormatadaComDiferencaDeDias(3));
		movimentacaoPage.setDescricao("Testando");
		movimentacaoPage.setInteressado("Qualquer");
		movimentacaoPage.setValor("1000");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.salvar();

		List<String> erros = movimentacaoPage.obtemErros();
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size());
		
	}
	
}
