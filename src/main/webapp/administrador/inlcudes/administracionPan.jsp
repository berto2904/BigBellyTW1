<!-- ============ Pan Section  ============= -->
      <div class="titulo jumbotron" id="pan">
      	<div class="container">
      		<h2>Pan</h2>
      	</div>
      </div>
      <div class="container">
       <div class="row">
       	<div class="col-md-6">
       		<form:form action="agregarPan" method="POST" modelAttribute="pan">
			  <div class="form-group">
			    <label>Tipo de Pan</label>
			    <form:input path="nombre" type="text" class="form-control" id="nombrePan" placeholder="Pan"/>
			  </div>
			   <div class="form-group">
			    <label>Stock</label>
			    <form:input path="stock" id="stockPan" type="number" class="form-control" placeholder="Stock"/>
			  </div>
			   <div class="form-group">
			    <label>Precio</label>
			    <form:input path="precio" id="precioPan" type="number" class="form-control" min="0.00" max="20.00" step="0.01" placeholder="Precio"/>
			  </div>
			  <button type="submit" class="btn btn-success">Guardar</button>
			</form:form>
	    </div>
       	
       	<div class="col-md-6">
       		<table class="table">
				<thead>
					<tr>
						<th>Tipo de Pan</th>
						<th>Stock</th>
						<th>Precio unitario</th>
						<th>Editar</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaPanes}" var="panes">
						<tr id="idPan_${panes.idPan}">
							<td><c:out value="${panes.nombre}"/></td>
							<td><c:out value="${panes.stock}"/></td>
							<td><c:out value="${panes.precio}"/></td>
							<td><a class="btn btn-warning btn-sm" onclick="editarPan(${panes.idPan})" role="button"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Editar</a></td>
							<td><a class="btn btn-danger btn-sm" onclick="eliminarPan(${panes.idPan})" role="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody> 
			</table>
       	</div>
      </div> 
	</div>
<hr>
<!-- ============ Footer Section  ============= -->