# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Autenticação - Backend

* dependencias a serem instaladas

    npm install --save bcrypt@1.0.2 jsonwebtoken@7.3.0

* criando arquivo que conterara a chave de para geracao do token
* `.env`, via de regra eh um arquivo que deve ser protegido, nao deve ir para git

    module.exports = {
        authSecret: 'ChaveMuitoSecreta'
    }    