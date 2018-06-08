# Seção 2 - JUnit

# Um teste tem que seguir 3 fases

* `Cenario`, montamos todo o fluxo para ser executado o teste

* `Acao`, indicamos a acao a ser realizada para no teste

* `Verificacao`, indicamos se a acao realizada foi executada como esperado

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
		
# F.I.R.S.T.

* um teste tem que atender ao `F.I.R.S.T.`
* F. - um teste tem que ser rapido
* I. - um teste tem que ser independente
* R. - um teste tem que ser repetivel, possa ser executado varias vezes
* S. - um teste tem que saber se avaliar, indicando se o teste passou ou nao