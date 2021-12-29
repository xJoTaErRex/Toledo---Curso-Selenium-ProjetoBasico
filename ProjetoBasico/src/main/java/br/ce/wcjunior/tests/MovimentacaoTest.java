package br.ce.wcjunior.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcjunior.core.BaseTest;
import br.ce.wcjunior.pages.MenuPage;
import br.ce.wcjunior.pages.MovimentacaoPage;
import br.ce.wcjunior.utils.DataUtils;

public class MovimentacaoTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
     
	@Test
	public void testInserirMoviemntacao() {
		
		menuPage.acessarTelaCriarMovimentação();
		movimentacaoPage.setDataMovimentacao("11/04/2019");
		movimentacaoPage.setDataPagamento("11/04/2019");
		movimentacaoPage.setDescricao("Testando");
		movimentacaoPage.setInteressado("Qualquer");
		movimentacaoPage.setValor("1000");
		movimentacaoPage.setConta("Conta de Teste 6");
		movimentacaoPage.salvar();
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obtemMensagemSucesso());
		
	}
	
	@Test
	public void testValidacoes() {		
		menuPage.acessarTelaCriarMovimentação();
		movimentacaoPage.salvar();
		List<String> erros = movimentacaoPage.obtemErros();
		//Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
		//Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório","Descrição é obrigatório","Interessado é obrigatório",
				"Valor é obrigatório","Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
		
	}
	
	@Test
	public void testInserirMoviemntacaoFutura() {
		
		menuPage.acessarTelaCriarMovimentação();
		movimentacaoPage.setDataMovimentacao(DataUtils.obtemDataFormatadaComDiferencaDeDias(3));
		movimentacaoPage.setDataPagamento(DataUtils.obtemDataFormatadaComDiferencaDeDias(3));
		movimentacaoPage.setDescricao("Testando");
		movimentacaoPage.setInteressado("Qualquer");
		movimentacaoPage.setValor("1000");
		movimentacaoPage.setConta("Conta de Teste 6");
		movimentacaoPage.salvar();

		List<String> erros = movimentacaoPage.obtemErros();
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
		
	}
	
}
