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