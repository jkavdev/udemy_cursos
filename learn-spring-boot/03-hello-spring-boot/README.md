# Learn Spring Boot - Rapid Spring Application Development com Dan Vega

# Hello, Spring Boot

# Criando uma aplicacao com o groovy

* criar um arquivo, app.groovy
* adicionar conteudo

		@RestController
		public class HelloWorld {
		    @RequestMapping("/")
		    public String home(){
		        "Massa, ta funcionando..........."
		    }
		}

* rodando aplicacaco, indicando o arquivo e a porta para acessa-lo

		spring run app.groovy -- --server.port=9000

* criando uma aplicacao spring boot java

* ir no site https://start.spring.io/
* criar o projeto spring boot com o modulo web
* iniciar em alguma ide o projeto e executar a classe principal
* temos um controller que fica escutando uri base do projeto

		@RestController
		public class HomeController {
			@RequestMapping("/")
			public String home(){
				return "Massa, ta funcionando......";
			}
		}

* acessando a aplicacao

		localhost:8080/

# Rodando a aplicacao com o maven

		mvn spring-boot:run