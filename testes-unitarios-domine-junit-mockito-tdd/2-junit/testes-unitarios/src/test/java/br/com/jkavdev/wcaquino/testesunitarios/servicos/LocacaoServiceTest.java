package br.com.jkavdev.wcaquino.testesunitarios.servicos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.jkavdev.wcaquino.testesunitarios.entidades.Filme;
import br.com.jkavdev.wcaquino.testesunitarios.entidades.Locacao;
import br.com.jkavdev.wcaquino.testesunitarios.entidades.Usuario;
import br.com.jkavdev.wcaquino.testesunitarios.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void teste() {

		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Jhonatan");
		Filme filme = new Filme("Annihilation", 50, 26.3);

		// acao
		Locacao locacao = service.alugarFilme(usuario, filme);

		// verificacao
		Assert.assertTrue(locacao.getValor() == 26.3);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

	}

}
