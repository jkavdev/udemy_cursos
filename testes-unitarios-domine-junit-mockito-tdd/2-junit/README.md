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

# JUnit

* utilizando o `JUnit` para realizar os testes unitarios e que implementa todos os requisitos do `F.I.R.S.T.`

* adicionando dependencia no projeto

		<dependencies>
			<dependency>
				<groupId>junit</groupId>
				<artifactId>junit</artifactId>
				<version>4.12</version>
			</dependency>
		</dependencies>
		
* criando um metodo de teste
* para indicamos o metodo com `@Test`
* utilizando as assertivas do `JUnit`, `Assert.assertTrue()`, indicamos que o resultado tem que ser verdadeiro
* do qual importamos de `import org.junit.`

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
		
# Reestruturando local dos testes	

* colocando os testes em outro `source folder`
* estaremos separando os arquivos fisicamente, mas o java logicamente entende que os arquivos 
* possam estar no mesmo pacote

		src/main/java
			br.com.jkavdev.wcaquino.testesunitarios.servicos/LocacaoService.java
			
		src/test/java
			br.com.jkavdev.wcaquino.testesunitarios.servicos/LocacaoServiceTest.java
			
* pontos a se considerar com a separacao dos testes para o mesmo pacote

		public class LocacaoService {
			public String vPublica;
			private String vPrivate;
			protected String vProtected;
			String vDefault;
		}

* acessando as variaveis `default` e `protected`

		public class LocacaoServiceTest {
			@Test
			public void teste() {
				LocacaoService service = new LocacaoService();
				service.vDefault;
				service.vProtected;
				service.vPublica;
			}
		}					