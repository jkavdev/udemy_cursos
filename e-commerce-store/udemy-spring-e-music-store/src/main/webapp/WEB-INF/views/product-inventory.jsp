<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product inventory page</h1>


			<p class="lead">this is the product inventory page!</p>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Proto Thumb</th>
					<th>Product name</th>
					<th>Category</th>
					<th>Condition</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><img src="#" alt="image"/></td>
						<td>${product.productName}</td>
						<td>${product.productCategory}</td>
						<td>${product.productCondition}</td>
						<td>${product.productPrice}</td>
						<td><a href="<spring:url value="/viewProduct/${product.productId}" />"><span class="glyphicon glyphicon-info-sign"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a class="btn btn-primary" href="<spring:url value="/admin/productInventory/addProduct"/>">Add product</a>

		<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		