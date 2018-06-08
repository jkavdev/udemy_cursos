package br.com.jkavdev.wcaquino.testesunitarios.servicos;

import static br.com.jkavdev.wcaquino.testesunitarios.utils.DataUtils.adicionarDias;

import java.util.Date;

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

	public static void main(String[] args) {
		
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Jhonatan");
		Filme filme = new Filme("Annihilation", 50, 26.3);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verificacao
		System.out.println(locacao.getValor() == 26.3);
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
}