      <div class="titulo jumbotron" id="ingrediente">
      	<div class="container">
      		<h2>Ingrediente</h2>
      	</div>
      </div>
      <div class="container">
       <div class="row">
       	<div class="col-md-6">
       		<form:form action="agregarIngrediente" method="POST" modelAttribute="ingrediente">
			  <div class="form-group">
			    <label>Ingrediente</label>
			    <form:input path="nombre" type="text" class="form-control" id="nombreIngrediente" placeholder="Ingrediente"/>
			  </div>
			   <div class="form-group">
			    <label>Stock</label>
			    <form:input path="stock" id="stockIngrediente" type="number" class="form-control" placeholder="Stock"/>
			  </div>
			   <div class="form-group">
			    <label>Precio</label>
			    <form:input path="precio" id="precioIngrediente" type="number" class="form-control" min="0.00" max="20.00" step="0.01" placeholder="Precio"/>
			  </div>
			  <button type="submit" class="btn btn-success">Guardar</button>
			</form:form>
	    </div>
       	
       	<div class="col-md-6">
       		<table class="table">
				<thead>
					<tr>
						<th>Tipo de Ingrediente</th>
						<th>Stock</th>
						<th>Precio unitario</th>
						<th>Editar</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaIngredientes}" var="ingredientes">
						<tr id="idIngrediente_${ingredientes.idIngrediente}">
							<td><c:out value="${ingredientes.nombre}"/></td>
							<td><c:out value="${ingredientes.stock}"/></td>
							<td><c:out value="${ingredientes.precio}"/></td>
							<td><a class="btn btn-warning btn-sm" onclick="editarIngrediente(${ingredientes.idIngrediente})" role="button"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Editar</a></td>
							<td><a class="btn btn-danger btn-sm" onclick="eliminarIngrediente(${ingredientes.idIngrediente})" role="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody> 
			</table>
       	</div>
      </div> 
	</div>
<hr>