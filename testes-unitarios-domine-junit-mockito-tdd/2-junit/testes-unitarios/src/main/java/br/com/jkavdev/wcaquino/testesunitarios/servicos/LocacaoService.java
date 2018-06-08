package br.com.jkavdev.wcaquino.testesunitarios.servicos;

import static br.com.jkavdev.wcaquino.testesunitarios.utils.DataUtils.adicionarDias;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.jkavdev.wcaquino.testesunitarios.entidades.Filme;
import br.com.jkavdev.wcaquino.testesunitarios.entidades.Locacao;
import br.com.jkavdev.wcaquino.testesunitarios.entidades.Usuario;
import br.com.jkavdev.wcaquino.testesunitarios.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	@Test
	public void teste() {
		
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Jhonatan");
		Filme filme = new Filme("Annihilation", 50, 26.3);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verificacao
		Assert.assertTrue(locacao.getValor() == 26.1);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
}