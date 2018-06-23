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