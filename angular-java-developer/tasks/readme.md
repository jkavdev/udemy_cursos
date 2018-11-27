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
          "../node_modules/bootstrap/dist/css/bootstrap.css",
          "src/styles.css"
        ],        
        
                