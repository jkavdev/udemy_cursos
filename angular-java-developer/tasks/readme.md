# Frontend

    
        $app_root$\src\main\
            ng new frontend
            
* rodando a aplicacao ``frontend``

    
        ng serve
        
* adicionando os componentes ``tasks``

    
        ng g c tasks                    
        ng g c tasks/tasks-add                    
        ng g c tasks/tasks-list          
        
# Bootstrap
* instalando a dependencia do ``bootstrap``
    
    
        npm install --save bootstrap
        
* declarando ``bootstrap`` no projeto

    
        "styles": [
            "node_modules/bootstrap/dist/css/bootstrap.min.css",
          "src/styles.css"
        ],  
        
* configurando identacao dos ``sources`` do `angular`

    
        indent_size = 4       
        
* configurando ``proxy`` para requisicoes ao `backend`


        {
            "/api": {
                "target": "http://localhost:8080",
                "secure": false
            }
        }

* com o arquivo criado, podemos indicar ao iniciar o ``frontend`` para aceitar as configuracoes de `proxy`

    
        "scripts": {
            "start": "ng serve --proxy-config proxy-conf.json",
          },         
               
               
* toda chamado que tivermos ``api`` sera utilizado as configuracoes de `proxy`

    
        taskUrl = '/api/tasks' //a mesma coisa de http://localhost:8080/api/tasks
        constructor(private http: HttpClient) {}
        getTasks(): Observable<Task[]> {
            return this.http.get<Task[]>(this.taskUrl)
        }                
        
# ``Build`` da aplicacao

* gerando os arquivos finais do ``frontend``
* adicionando ``tarefas`` para realizar o `deploy` da aplicacao `frontend`
* ``"postbuild": "npm run deploy"`` que sera executando depois do `build`, chamando a proxima tarefa `deploy`
* antes do ``deploy`` indicamos `predeploy` para remover o diretorio `../resources/static/` com `rimraf`
* e recria-lo `&& mkdirp`
* no ``deploy`` copiamos todo o conteudo de `dist/**` para a pasta acima `copyfiles -f dist/** ../resources/static`

    
        "postbuild": "npm run deploy",
        "predeploy": "rimraf ../resources/static/ && mkdirp ../resources/static/",
        "deploy": "copyfiles -f dist/** ../resources/static", 
        
* instalando as dependencias para o ``deploy`` em modo `dev`         

    
        npm install --save-dev rimraf      
        npm install --save-dev mkdirp      
        npm install --save-dev copyfiles      
        
* depois apenas rodar a aplicacao ``backend`` que o `spring boot` servira o conteudo dentro `/resources/static`        