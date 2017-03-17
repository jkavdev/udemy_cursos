Passos para radar a aplicação my-app-money

instalar o mongodb
- instalar o mongodb
- configurar variável de ambiente apontando para a pasta bin do mongodb
- criar a pasta C:\data\db

instalar o nodejs
- instalar o node 10

importar o repositório https://github.com/cod3rcursos/curso-react-redux.git
- git clone https://github.com/cod3rcursos/curso-react-redux.git
- baixar as depêndencias de cada módulo backend e frontend
    - ir na pasta \curso-react-redux\my-money-app\backend e rodar o seguinte comando
        -  npm i, para baixar todas as depêndencias do módulo
    - ir na pasta \curso-react-redux\my-money-app\frontend e rodar o seguinte comando
        -  npm i, para baixar todas as depêndencias do módulo

- Para executar a aplicação
- inicie o mongodb
    - mongod
- inicie o módulo backend
    - npm run dev
    - npm run production - iniciará com o p2m
- inicie o módulo frontend
    - npm run dev - aqui o webpack realizará o bundle da aplicação
- acesse localhost:8080