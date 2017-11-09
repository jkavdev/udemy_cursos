# Projeto Spring Boot com Wildfly da Udemy

# Aula 3

# Configuração do lombok 

- Eclipse - <https://projectlombok.org/setup/eclipse>
- Intellij - <https://projectlombok.org/setup/intellij>

* Adicionando usuário manager no wildfly
			
	* Ir na pasta \bin do servidor
	
	* add-user.bat
		
* Para acessar o console administrador do wildfly, e realizar deploy da aplicação

	* http://localhost:9990
	
	* Ir em Deployments, e selecionar o war, do projeto que será realizado o deploy
	
* Podemos alterar o contexto da aplicação através do arquivo jboss-web.xml
	
	* <context-root>boot-wildfly</context-root>
	
* Caso o projeto não tenha o arquivo, o wildfly adotará nome do war como contexto da aplicação		