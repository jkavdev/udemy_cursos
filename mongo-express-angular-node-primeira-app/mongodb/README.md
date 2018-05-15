# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# MongoDb

# Comandos Basicos

* inicializando o servidor 

    mongod

* inicializando o console 

    mongo

* visualizando os banco de dados

    show dbs

* utilizando um banco de dados

    use db_finance

* criando uma colecao dentro do banco de dados

    db.createCollection('billingCycles')      

* exibindo todas as colecoes

    show collections

* removendo uma colecao    

    db.billingCycles.drop()

# Inserts

* nao precisamos criar uma collection para inserir um documento
* aqui sera criado uma collection com toda estrutura necessario para o `insert`

    db.billingCycles.insert({name: "Janeiro/17", month: 1, year: 2017})

* inserindo com `save`

    db.billingCycles.save({name: "Fevereiro/17", month: 2, year: 2017})

* inserindo em varias linhas

    db.billingCycles.insert({ 
        name: "Março/2017", month: 3, year: 2017, 
        credits: [ 
            {name: "Sálario", value: 5000} 
        ], 
        debts: [ 
            {name: "Luz", value: 100, status: "PAGO"}, 
            {name: "Água", value: 150, status: "PENDENTE"}, 
        ], 
    })