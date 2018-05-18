# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Template AdminLTE

* realizando a inclusao de paginas com o `angular` `ng-include="'/template/header.html'"`
* passando o controle das `view` para `angular-route` `ui-view`

    <body class="skin-blue fixed sidebar-mini">
        <div class="wrapper">
            <header class="main-header" ng-include="'/template/header.html'"></header>
            <header class="main-sidebar" ng-include="'/template/menu.html'"></header>
            <header class="content-wrapper" ui-view></header>
            <div class="content-footer" ng-include="'/template/footer.html'"></div>
        </div>
        <script src="/assets/js/deps.min.js"></script>
        <script src="/assets/js/app.min.js"></script>
    </body>

* corrigindo posicao do `footer`    

    .main-footer{
        position: fixed;
        bottom: 0px;
        width: 100%;
    }