Inicializar o projeto e criar o package.json

package.json - descritor do projeto

	npm init -y

Instalando a dependencia do webpack

	npm i --save-dev webpack@1.14.0

Instalando a dependencia do webserver

	npm i --save-dev webpack-dev-server@1.16.2

Instalando as duas dependencias ao mesmo tempo

	npm i --save-dev webpack@1.14.0 webpack-dev-server@1.16.2

Uma vez que é instalando as dependencias, eh alterado o package.json com a dependencias do projeto
E quando for rodar o projeto novamente apenas utilize o comando
 
	npm i

Adicionando arquivo gitignore, com a definicao do node_modules, criado pelo comando acima

	node_modules
	*.log
	
Configurando script a ser rodado, exibir barra de progresso colorida e atualizações no código e página da web

	webpack-dev-server --progress --color --inline --hot
	
Executando projeto

	npm run dev 
