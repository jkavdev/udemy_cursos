<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Cover Template - Clientes</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/resources/css/cover.css'/>" rel="stylesheet">
  </head>

  <body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Udemy spring exercise 4</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="#">Clientes</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Clientes cadastrados.</h1>
            <p class="lead">
              <table class="table">
              	<thead>
				  <tr>
				    <th style="text-align: center;">Nome</th>
				    <th style="text-align: center;">Idade</th>
				  </tr>
				</thead>
				<tbody>
					<c:forEach items="${clientes}" var="cliente">
						<tr>
						    <td>${cliente.nome}</td>
						    <td>${cliente.idade}</td>				    
					  	</tr>
					</c:forEach>				  
				</tbody>
				</table>
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>Exercício 4 <a href="https://github.com/jkavdev/udemy_cursos/">Cliente</a>, por <a href="https://github.com/jkavdev/">JKAVDEV</a>.</p>
            </div>
          </div>

        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value='/resources/js/jquery-3.1.1.min.js'/>"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
  </body>
</html>
