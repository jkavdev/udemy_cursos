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

# Selects

* exibindo todos os documentos da collections

    db.billingCycle.find()

* exibindo todos os documentos num formato json 'bonito'        

    db.billingCycles.find().pretty()

* exibindo um unico registro, no caso o primeiro que encontrar

    db.billingCycles.findOne()    

* exibindo um unico registro, no caso o primeiro que encontrar, com filtro

    db.billingCycles.findOne({month: 2})

    db.billingCycles.find({$or: [{month: 1}, {month: 2}]}).pretty()

* exibindo apenas os documentos com a seguinte propriedades

    db.billingCycles.find({credits: {$exists: true}}).pretty()    

* exibindo os documento com filtro e ignorando o primeiro registro

    db.billingCycles.find({year: 2017}).skip(1).pretty()    

* exibindo os documento com filtro e pegando apenas um registro

    db.billingCycles.find({year: 2017}).skip(1).limit(1).pretty()

* exibindo apenas atributos especificos dos documento
* o id vem por padrao, por isso indicamos que nao precisa, e apenas o nome
* `, {_id:0, name:1}`

    db.billingCycles.find({credits: {$exists: true}}, {_id:0, name:1}).pretty()

# Agregacao

* `$project:{credit:{$sum:"$credits.value"},debt:{$sum:"$debts.value"}}`
* criara uma projecao com duas retornos das somas dos debitos e creditos
* `$group:{_id:null,credit:{$sum:"$credit"},debt:{$sum:"$debt"}}`
* agrupara os resultados da projecao em duas variaveis, a soma de creditos e debitos

    db.billingCycles.aggregate([{ 
	    $project:{credit:{$sum:"$credits.value"},debt:{$sum:"$debts.value"}}, 
	},{ 
	    $group:{_id:null,credit:{$sum:"$credit"},debt:{$sum:"$debt"}} 
	}])

# Update

* indicamos um filtro para os documento a serem atualizados
* `{$and:[{month:1},{year:2017}]}`
* indicamos os atributos a serem atualizados
* `{$set:{credits:[{name: "Sálario", value:5000}]}}`

    db.billingCycles.update( 
        {$and:[{month:1},{year:2017}]}, 
        {$set:{credits:[{name: "Sálario", value:5000}]}}
    )    

* visualizando alteracao, como fizemos a alteracao no primeiro documento
    
    db.billingCycles.findOne()

# Removes

* exibindo o total de documentos no banco

    db.billingCycles.count()

* removendo um documento de acordo com um filtro

    db.billingCycles.remove({month:2})

* removendo apenas um documento de acordo com um filtro

    db.billingCycles.remove({month:2}, 1)

* removendo o banco de dados

    db.dropDatabase();