<!-- ============ Carne Section  ============= -->
      <div class="titulo jumbotron" id="carne">
      	<div class="container">
      		<h2>Carne</h2>
      	</div>
      </div>
      <div class="container">
       <div class="row">
       	<div class="col-md-6">
       		<form:form action="agregarCarne" method="POST" modelAttribute="carne">
			  <div class="form-group">
			    <label>Tipo de Carne</label>
			    <form:input path="nombre" type="text" class="form-control" id="nombreCarne" placeholder="Carne"/>
			  </div>
			   <div class="form-group">
			    <label>Stock</label>
			    <form:input path="stock" id="stockCarne" type="number" class="form-control" placeholder="Stock"/>
			  </div>
			  <div class="form-group">
			    <label>Tiempo de coccion</label>
			    <form:input path="tiempoCoccion" id="tiempoCarne" type="number" class="form-control" placeholder="Tiempo de coccion"/>
			  </div>
			   <div class="form-group">
			    <label>Precio</label>
			    <form:input path="precio" id="precioCarne" type="number" class="form-control" min="0.00" max="30.00" step="0.01" placeholder="Precio"/>
			  </div>
			  <button type="submit" class="btn btn-success">Guardar</button>
			</form:form>
	    </div>
       	
       	<div class="col-md-6">
       		<table class="table">
				<thead>
					<tr>
						<th>Tipo de Carne</th>
						<th>Stock</th>
						<th>Precio unitario</th>
						<th>Tiempo De Coccion</th>
						<th>Editar</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaCarne}" var="carne">
						<tr id="idCarne_${carne.idCarne}">
							<td><c:out value="${carne.nombre}"/></td>
							<td><c:out value="${carne.stock}"/></td>
							<td><c:out value="${carne.precio}"/></td>
							<td><c:out value="${carne.tiempoCoccion}"/></td>
							<td><a class="btn btn-warning btn-sm" onclick="editarPan(${carne.idCarne})" role="button"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Editar</a></td>
							<td><a class="btn btn-danger btn-sm" onclick="eliminarPan(${carne.idCarne})" role="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody> 
			</table>
       	</div>
      </div> 
	</div>
<hr>
<!-- ============ Other Section  ============= -->